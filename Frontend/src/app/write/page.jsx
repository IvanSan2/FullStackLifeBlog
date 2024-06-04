"use client";

import MarkdownEditor from "../components/markdown/MarkdownEditor";
import styles from "./writePage.module.css";
import { getRandomPostPageShape } from "@/app/utils/math";
import { useState } from "react";
import MarkdownPreview from "../components/markdown/MarkdownPreview";
import axios from "axios";
import { useAuth } from "../context/AuthContext";
import { useRouter } from "next/navigation";
import imageCompression from "browser-image-compression";

const WritePage = () => {
  const { jwt, isLoggedIn } = useAuth();
  const router = useRouter();
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [content, setContent] = useState("");
  const [image, setImage] = useState(null);

  if (!isLoggedIn) {
    router.push("/login");
  }
  const handleData = (data) => {
    setContent(data);
  };

  async function handleOnChange(changeEvent) {
    // compress image
    const compressedFile = await imageCompression(changeEvent.target.files[0], {
      maxSizeMB: 1,
      maxWidthOrHeight: 1920,
      useWebWorker: true,
    });

    const reader = new FileReader();

    reader.onload = function (onLoadEvent) {
      setImage(onLoadEvent.target.result);
    };

    reader.readAsDataURL(compressedFile);
    console.log(` Image Size: ${compressedFile.size / 1024 / 1024} MB`);
    setImage(compressedFile);
  }

  const handlePublish = async () => {
    try {
      // send image to cloudinary and get url
      const imgUrlResponse = await axios
        .post(
          "https://api.cloudinary.com/v1_1/fullstacklifeblog/image/upload/",
          {
            file: image,
            upload_preset: "fullstacklifeblog",
            tags: "blogpost",
          }
        )
        .then((res) => res.data.secure_url);

      // send post data to server

      const response = await axios.post(
        "/api/v1/posts",
        {
          title,
          description,
          content,
          image: imgUrlResponse,
        },
        { headers: { Authorization: `Bearer ${jwt}` } }
      );

      

      const status = response.status;
      if (status === 201) {
        router.push("/");
      }
    } catch (error) {
      console.error(error);
    }
  };

  const categories = ["web", "mobile", "java", "design", "lifestyle"];

  return (
    isLoggedIn && (
      <div className={styles.container}>
        <div
          className={styles.imageContainer}
          style={{ borderRadius: getRandomPostPageShape() }}
        >
          <input
            type="file"
            accept="image/*"
            onChange={handleOnChange}
            className={styles.imageUploadBtn}
          />
          {image && (
            <img
              id="output"
              src={image}
              className={styles.image}
              alt="cover image"
            />
          )}
        </div>
        <input
          type="text"
          placeholder="Title"
          onChange={(e) => setTitle(e.target.value)}
          className={styles.titleInput}
        />
        <textarea
          type="text"
          placeholder="Description"
          onChange={(e) => {
            setDescription(e.target.value);
          }}
          className={styles.descriptionInput}
          role="textbox"
          contentEditable
        />
        <div className={styles.catContainer}></div>
        <div className={styles.contentTitle}>
          Use Markdown to write and format posts.
        </div>
        <div className={styles.editor}>
          <MarkdownEditor onData={handleData} />
        </div>
        <button className={styles.publishBtn} onClick={handlePublish}>
          Publish
        </button>

        <div style={{ paddingTop: 100 }}>
          <h2>Preview</h2>
          <br />
          <MarkdownPreview value={content} />
        </div>
      </div>
    )
  );
};

export default WritePage;
