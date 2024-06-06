"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import styles from "./registerPage.module.css";
import imageCompression from "browser-image-compression";
import axios from "axios";

const RegisterPage = () => {
    const router = useRouter();
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [image, setImage] = useState(null);
  
    async function handleOnChange(changeEvent) {
        // compress image
        const compressedFile = await imageCompression(changeEvent.target.files[0], {
          maxSizeMB: 1,
          maxWidthOrHeight: 150,
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
  
    const handleSubmit = async (e) => {
      e.preventDefault();
  
      const formData = new FormData();
      
      try {

        // send image to cloudinary and get url
      const imgUrlResponse = await axios
      .post(
        "https://api.cloudinary.com/v1_1/fullstacklifeblog/image/upload/",
        {
          file: image,
          upload_preset: "fullstacklifeblog",
          tags: "profile",
        }
      )
      .then((res) => res.data.secure_url);

    //    console.log(JSON.stringify({
    //     "username": username,
    //     "password": password,
    //     "email": email,
    //     "image": imgUrlResponse,
    //    }));

        // send post data to server
        const response = await fetch("/api/v1/auth/register", {
          method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
          body: JSON.stringify({
            "username": username,
            "password": password,
            "email": email,
            "image": imgUrlResponse,
          }),
        });
  
        const data = await response.json();
        if (response.status === 201) {
          router.push("/login");
        }
      } catch (error) {
        console.error("Error registering:", error);
      }
    };
  
    return (
      <div className={styles.container}>
        <div className={styles.wrapper}>
          <h1 className={styles.title}>Register</h1>
          <div className={styles.loginFormContainer}>
            <form className={styles.loginForm} onSubmit={handleSubmit}>
              <input
                type="text"
                name="username"
                placeholder="Username"
                className={styles.input}
                onChange={(e) => setUsername(e.target.value)}
              />
              <input
                type="email"
                name="email"
                placeholder="Email"
                className={styles.input}
                onChange={(e) => setEmail(e.target.value)}
              />
              <input
                type="password"
                name="password"
                placeholder="Password"
                className={styles.input}
                onChange={(e) => setPassword(e.target.value)}
              />
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
              style={{ borderRadius: "50%", width: "100px", height: "100px", objectFit: "cover"}}
              alt="cover image"
            />
          )}
              <button type="submit" className={styles.submitButton}>
                Register
              </button>
            </form>
          </div>
        </div>
      </div>
    );
  };
  
  export default RegisterPage;
