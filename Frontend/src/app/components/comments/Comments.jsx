"use client";
import styles from "./comments.module.css";
import userImage from "@/../../public/fashion.png";
import { useState,useEffect } from "react";
import SendIcon from "../icons/SendIcon";
import Link from "next/link";
import Comment from "../comment/Comment";
import { useAuth } from "@/app/context/AuthContext";
import axios from "axios";

const Comments = (props) => {
  const { isLoggedIn,jwt } = useAuth();
  const [comments, setComments] = useState(props.comments);
  const [comment, setComment] = useState("");
  const [placeholder, setPlaceholder] = useState("Write your comment...");


  useEffect(() => {
    // reverse the comments array to show the latest comments first
    setComments(comments.reverse());
  }, [comments]);



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

  // A function to handle the form submission
  const handleSubmit = async () => {
    // Check if the comments are not empty
    if (comment.trim() !== "") {
      // Send the comment to the server
      try {
        const response = await axios.post(
          `/api/v1/posts/${props.postId}/comments`,
          {
           comment
          },
          
            { headers: { Authorization: `Bearer ${jwt}` }
          }
        );

        const request = await response.request;
      console.log(request);

        const newComment = await response.data;
        console.log(newComment);
        // Add the new comment to the list of comments
        setComments([ newComment, ...comments]);
      } catch (error) {
        console.error(error);
      }
    }
  }



  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Comments</h1>
      {isLoggedIn ? (
        <div className={styles.form}>
          <textarea
            className={styles.textarea}
            placeholder={placeholder}
            onFocus={handleFocus}
            onBlur={handleBlur}
            onChange={(e) => setComment(e.target.value)}
          ></textarea>
          <div className={styles.formBar}>
            <div className={styles.utilsContainer}></div>
            <button className={styles.button} onClick={handleSubmit}>
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

          <Link className={styles.loginButton} href="/login">
            Login
          </Link>
        </div>
      )}
      <div className={styles.comments}>

        {/* <Comment
          liked={true}
          userImage={userImage}
          username={"Mary Jane"}
          date={"5 days ago"}
          likesCount={75}
          text={"Peter Parker? Is that you? I love you!"}
        /> */}

        
        {comments.map((comment) => (
          <Comment
            key={comment.id}
            //TODO: add the liked prop in the Backend
            liked={false}
            userImage={comment.user.image}
            username={comment.user.username}
            date={
              //if the date is more than 1 day ago, show the date, else show the time, if the date is less then 5 hours ago, show "just now"
              new Date(comment.createdAt).getTime() <
              new Date().getTime() - 86400000 // 1 day in ms
                ? new Date(comment.createdAt).toLocaleDateString()
                : new Date(comment.createdAt).getTime() >
                  new Date().getTime() - 3600000 // 1 hour in ms
                ? "Just now"
                : // show how much time ago the post was created
                  `${
                    Math.floor(
                      (new Date().getTime() -
                        new Date(comment.createdAt).getTime()) /
                        3600000
                    ) || 1
                  }h and ${Math.floor(
                    (new Date().getTime() -
                      new Date(comment.createdAt).getTime()) /
                      6000000
                  )}m
                   ago`
            }
            likesCount={comment.likesCount}
            text={comment.comment}
          />
        ))  
        }
      </div>
    </div>
  );
};


export default Comments;
