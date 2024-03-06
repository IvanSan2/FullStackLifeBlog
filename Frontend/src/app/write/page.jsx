"use client";

import Image from "next/image";
import MarkdownEditor from "../components/markdown/MarkdownEditor";
import styles from "./writePage.module.css";
import { getRandomPostPageShape } from "@/app/utils/math";

const WritePage = () => {
  // add drag and drop image upload with preview
  // https://stackoverflow.com/questions/4459379/preview-an-image-before-it-is-uploaded

  var loadFile = function (event) {
    var output = document.getElementById("output");
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
      URL.revokeObjectURL(output.src); // free memory
    };
  };

  // add post categories
  const categories = ["web", "mobile", "java", "design", "lifestyle"];

  return (
    <div className={styles.container}>
      <div
        className={styles.imageContainer}
        style={{ borderRadius: getRandomPostPageShape() }}
      >
        <input
          type="file"
          accept="image/*"
          onChange={loadFile}
          className={styles.imageUploadBtn}
        />
        <Image
          id="output"
          src={""}
          className={styles.image}
          alt="cover image"
        />
      </div>
      <input type="text" placeholder="Title" className={styles.titleInput} />
      <span
        type="text"
        placeholder="Description"
        className={styles.descriptionInput}
        role="textbox"
        contentEditable
      />
      <div className={styles.catContainer}></div>
      <div className={styles.contentTitle}>
        Use Markdown to write and format posts.
      </div>
      <div className={styles.editor}></div>
      <MarkdownEditor />
    </div>
  );
};

export default WritePage;
