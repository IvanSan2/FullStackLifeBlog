import React from "react";
import styles from "./menuPost.module.css";
import Link from "next/link";
import Image from "next/image";
import p1 from "../../../../public/p1.jpeg";
import { getRandomLogoShape } from "@/app/utils/math";

const MenuPost = () => {
  return (
    <div className={styles.container}>
      <Link href="/post" className={styles.item}>
        <div className={styles.imageContainer}>
          <Image
            src={p1}
            alt=""
            fill
            className={styles.image}
            style={{ borderRadius: getRandomLogoShape() }}
          ></Image>
        </div>

        <div className={styles.textContainer}>
          <span
            className={styles.category}
            style={{ background: "var(--categoryJava)" }}
          >
            Java
          </span>

          <h3 className={styles.postTitle}>
            Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          </h3>
          <div className={styles.detail}>
            <span className={styles.username}>John Doe - </span>
            <span className={styles.date}>27.03.2023</span>
          </div>
        </div>
      </Link>
    </div>
  );
};

export default MenuPost;
