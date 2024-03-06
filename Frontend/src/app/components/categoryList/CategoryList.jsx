"use client";
import styles from "./categoryList.module.css";
import Link from "next/link";
import Image from "next/image";
import image from "../../../../public/style.png";
import { getRandomLogoShape } from "../../utils/math.js";
import { useSearchParams } from "next/navigation";
import Featured from "../featured/Featured";

const CategoryList = () => {
  const searchParams = useSearchParams();
  const cat = searchParams.get(`cat`);

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Categories</h1>
      <div className={styles.categories}>
        <Link
          href="/blog?cat=web"
          className={`${styles.category} ${styles.web}`}
          style={
            cat === "web"
              ? {
                  boxShadow: "0 0 30px 0 var(--categoryWeb)",
                  transition: "all 0.4s ease-out",
                }
              : { opacity: 0.7, transition: "all 0.4s ease-out" }
          }
        >
          <Image
            src={image}
            alt=""
            width={32}
            height={32}
            className={styles.image}
            style={{
              transition: "all 1s ease-out",
              borderRadius: getRandomLogoShape(),
            }}
          />
          Web
        </Link>
        <Link
          href="/blog?cat=mobile"
          className={`${styles.category} ${styles.mobile}`}
          style={
            cat === "mobile"
              ? {
                  boxShadow: "0 0 30px 0 var(--categoryMobile)",
                  transition: "all 0.4s ease-out",
                }
              : { opacity: 0.7, transition: "all 0.4s ease-out" }
          }
        >
          <Image
            src={image}
            alt=""
            width={32}
            height={32}
            className={styles.image}
            style={{
              transition: "all 1s ease-out ",
              borderRadius: getRandomLogoShape(),
            }}
          />
          Mobile
        </Link>
        <Link
          href="/blog?cat=java"
          className={`${styles.category} ${styles.java}`}
          style={
            cat === "java"
              ? {
                  boxShadow: "0 0 30px 0 var(--categoryJava)",
                  transition: "all 0.4s ease-out",
                }
              : { opacity: 0.7, transition: "all 0.4s ease-out" }
          }
        >
          <Image
            src={image}
            alt=""
            width={32}
            height={32}
            className={styles.image}
            style={{
              transition: "all 1s ease-out ",
              borderRadius: getRandomLogoShape(),
            }}
          />
          Java
        </Link>
        <Link
          href="/blog?cat=design"
          className={`${styles.category} ${styles.design}`}
          style={
            cat === "design"
              ? {
                  boxShadow: "0 0 30px 0 var(--categoryDesign)",
                  transition: "all 0.4s ease-out",
                }
              : { opacity: 0.7, transition: "all 0.4s ease-out" }
          }
        >
          <Image
            src={image}
            alt=""
            width={32}
            height={32}
            className={styles.image}
            style={{
              transition: "all 1s ease-out ",
              borderRadius: getRandomLogoShape(),
            }}
          />
          Design
        </Link>
        <Link
          href="/blog?cat=lifestyle"
          className={`${styles.category} ${styles.lifestyle}`}
          style={
            cat === "lifestyle"
              ? {
                  boxShadow: "0 0 30px 0 var(--categoryLifestyle)",
                  transition: "all 0.4s ease-out",
                }
              : { opacity: 0.7, transition: "all 0.4s ease-out" }
          }
        >
          <Image
            src={image}
            alt=""
            width={32}
            height={32}
            className={styles.image}
            style={{
              transition: "all 1s ease-out ",
              borderRadius: getRandomLogoShape(),
            }}
          />
          Lifestyle
        </Link>
      </div>
    </div>
  );
};

export default CategoryList;
