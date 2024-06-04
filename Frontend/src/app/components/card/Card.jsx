import React from "react";
import styles from "./card.module.css";
import Image from "next/image";
import noImage from "../../../../public/no-image.svg";
import Link from "next/link";
import { getRandomPostShape } from "../../utils/math";

const Card = ({ post }) => {
  return (
    <div className={styles.container}>
      <div className={styles.imageContainer}>
        <Image
          src={post.image ? post.image : noImage}
          alt=""
          fill
          className={styles.image}
          style={{
            borderRadius: getRandomPostShape(),
            transition: "all 1s ease-out 0.4s",
          }}
        />
      </div>
      <div className={styles.textContainer}>
        <div className={styles.detail}>
          <span className={styles.date}>
            {new Date(post.createdAt).toLocaleDateString()} -{" "}
          </span>

          <span
            className={styles.category}
            style={{ background: "var(--categoryWeb)" }}
          >
            Web
          </span>
        </div>
        <Link href={`/posts/${post.id}`}>
          <h2 className={styles.title}>
            {post.title.length > 70
              ? post.title.slice(0, 67) + "..."
              : post.title}
          </h2>
        </Link>
        <p className={styles.description}>
          {post.description.length > 250
            ? post.description.slice(0, 247) + "..."
            : post.description}
        </p>
        <Link href={`/posts/${post.id}`} className={styles.link}>
          Read more
        </Link>
      </div>
    </div>
  );
};

export default Card;
