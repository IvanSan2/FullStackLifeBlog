"use client";
import Image from "next/image";
import Menu from "../../components/menu/Menu";
import styles from "./singlePage.module.css";
import userImage from "../../../../public/no-user-image.gif";
import Comments from "../../components/comments/Comments";
import { getRandomPostPageShape } from "../../utils/math";
import { useEffect, useState } from "react";
import MarkdownPreview from "../../components/markdown/MarkdownPreview";
import axios from "axios";
import { useAuth } from "../../context/AuthContext";

const SinglePage = ({ params }) => {
  const { jwt, isLoggedIn  } = useAuth();
  const { slug } = params;
  const [post, setPost] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  // get data from server
  const getData = async () => {
    try {
      const response = await axios.get(`/api/v1/posts/${slug}`);
      const data = await response.data;
      setPost(data);
      setIsLoading(false);
    } catch (error) {
      setIsLoading(false);
      console.error(error);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  if (isLoading) {
    return (
      <div className={styles.container}>
        <div className={styles.infoContainer}>
          <div
            className={styles.imageContainer}
            style={{ borderRadius: getRandomPostPageShape() }}
          >
            <div className={styles.image}></div>
            <div className={styles.textContainer}>
              <h1 className={styles.title}></h1>
              <div className={styles.user}>
                <div className={styles.userImageContainer}>
                  <div className={styles.userImage}></div>
                </div>
                <div className={styles.userTextContainer}>
                  <span className={styles.username}></span>
                  <span className={styles.date}></span>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className={styles.content}>
          <div className={styles.post}>
            <div className={styles.description}>
              <p></p>
            </div>
            <div className={styles.comment}></div>
          </div>
          <Menu />
        </div>
      </div>
    );
  }

  // return 404 page if data is null
  if (!post && !isLoading) {
    return (
      <div
        className={styles.container}
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          gap: "10px",
        }}
      >
        <h1>404</h1> | <h1>Post not found</h1>
      </div>
    );
  }

  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <div
          className={styles.imageContainer}
          style={{ borderRadius: getRandomPostPageShape() }}
        >
          <Image src={post.image} alt="" fill className={styles.image} />
          <div className={styles.textContainer}>
            {/* max 70 symbols for title */}
            <h1 className={styles.title}>{post.title}</h1>

            <div className={styles.user}>
              <div className={styles.userImageContainer}>
                {post.user.image ? (
                  <Image
                    src={post.user.image}
                    alt=""
                    fill
                    className={styles.userImage}
                  />
                ) : (
                  <Image
                    src={userImage}
                    alt=""
                    fill
                    className={styles.userImage}
                  />
                )}
              </div>
              <div className={styles.userTextContainer}>
                <span className={styles.username}>{post.user.username}</span>
                <span className={styles.date}>
                  {
                    //if the date is more than 1 day ago, show the date, else show the time, if the date is less then 5 hours ago, show "just now"
                    new Date(post.createdAt).getTime() <
                    new Date().getTime() - 86400000 // 1 day in ms
                      ? new Date(post.createdAt).toLocaleDateString()
                      : new Date(post.createdAt).getTime() >
                        new Date().getTime() - 3600000 // 1 hour in ms
                      ? "Just now"
                      : // show how much time ago the post was created
                        `${
                          Math.floor(
                            (new Date().getTime() -
                              new Date(post.createdAt).getTime()) /
                              3600000
                          ) || 1
                        }h and ${Math.floor(
                          (new Date().getTime() -
                            new Date(post.createdAt).getTime()) /
                            600000
                        )}m
                         ago`
                  }
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className={styles.content}>
        <div className={styles.post}>
          <div className={styles.description}>
            <p>{post.description}</p>
          </div>
          <MarkdownPreview content={post.content} />
          <div className={styles.comment}>
            <Comments comments={post.comments} postId={slug} />
          </div>
        </div>
        <Menu />
      </div>
    </div>
  );
};

export default SinglePage;
