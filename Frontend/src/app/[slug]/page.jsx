"use client";
import Image from "next/image";
import Menu from "../components/menu/Menu";
import styles from "./singlePage.module.css";
import userImage from "../../../public/fashion.png";
import Comments from "../components/comments/Comments";
import image from "../../../public/coding.png";
import { getRandomPostPageShape } from "../utils/math";
import MarkdownPreview from "../components/markdown/MarkdownPreview";

//TODO: add description to the post
const SinglePage = () => {
  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <div
          className={styles.imageContainer}
          style={{ borderRadius: getRandomPostPageShape() }}
        >
          <Image src={image} alt="" fill className={styles.image} />
          <div className={styles.textContainer}>
            {/* max 70 symbols for title */}
            <h1 className={styles.title}>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Lorem
              ipsum dolor sit amet consectetur adipisicing elit.
            </h1>
            <div className={styles.user}>
              <div className={styles.userImageContainer}>
                <Image
                  src={userImage}
                  alt=""
                  fill
                  className={styles.userImage}
                />
              </div>
              <div className={styles.userTextContainer}>
                <span className={styles.username}>Ivan San</span>
                <span className={styles.date}>14.12.2023</span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className={styles.content}>
        <div className={styles.post}>
          <div className={styles.description}>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam
              voluptas, voluptatum, quibusdam, asperiores accusantium
              reprehenderit voluptatem quia quos voluptatibus ea dolorum
              consequatur. Quia, voluptate. Quisquam voluptas, voluptatum,
              quibusdam, asperiores accusantium reprehenderit voluptatem quia
              quos voluptatibus ea dolorum consequatur. Quia, voluptate.
            </p>
          </div>
          <MarkdownPreview />
          <div className={styles.comment}>
            <Comments />
          </div>
        </div>
        <Menu />
      </div>
    </div>
  );
};

export default SinglePage;
