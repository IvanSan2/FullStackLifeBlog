"use client";
import styles from "./comments.module.css";
import userImage from "@/../../public/fashion.png";
import { useState } from "react";
import { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";
import SendIcon from "../icons/SendIcon";
import Link from "next/link";
import Comment from "../comment/Comment";

const Comments = () => {
  const { theme } = useContext(ThemeContext);

  const [placeholder, setPlaceholder] = useState("Write your comment...");

  // A function to handle the focus event
  const handleFocus = () => {
    // Set the placeholder to an empty string
    setPlaceholder("");
  };

  // A function to handle the blur event
  const handleBlur = () => {
    // Set the placeholder back to the original value
    setPlaceholder("Write your comment...");
  };

  const status = "authenticated";
  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Comments</h1>
      {status === "authenticated" ? (
        <div className={styles.form}>
          <textarea
            className={styles.textarea}
            placeholder={placeholder}
            onFocus={handleFocus}
            onBlur={handleBlur}
          ></textarea>
          <div className={styles.formBar}>
            <div className={styles.utilsContainer}></div>
            <button className={styles.button}>
              <SendIcon
                fillColor={"var(--textColor)"}
                width={24}
                className={styles.commentIcon}
              />
            </button>
          </div>
        </div>
      ) : (
        <div className={styles.login}>
          <span className={styles.loginText}>
            You need to be logged in to comment
          </span>

          <Link className={styles.loginButton} href="/">
            Login
          </Link>
        </div>
      )}
      <div className={styles.comments}>
        <Comment
          liked={true}
          userImage={userImage}
          username={"Salamana Karamba"}
          date={"6 hours ago"}
          likesCount={7}
          text={"I like this post so much! OMG!!!"}
        />
        <Comment
          liked={false}
          userImage={userImage}
          username={"Some Random Guy"}
          date={"2 hours ago"}
          likesCount={0}
          text={"Not bad, but I think it could be better."}
        />
        <Comment
          liked={true}
          userImage={userImage}
          username={"Mary Jane"}
          date={"5 days ago"}
          likesCount={75}
          text={"Peter Parker? Is that you? I love you!"}
        />
        <Comment
          liked={false}
          userImage={userImage}
          username={"John Doe"}
          date={"1 week ago"}
          likesCount={641}
          text={
            "Get out of here, you spammer! You are not welcome here! I hate you! Go away! I will call the police! I will call the FBI! I will call the CIA! I will call the KGB! I will call the NSA! I will call the MI6! I will call the Mossad!"
          }
        />
      </div>
    </div>
  );
};

export default Comments;
