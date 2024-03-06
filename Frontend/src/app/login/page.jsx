"use client";
import Image from "next/image";
import styles from "./loginPage.module.css";
import googleIcon from "../../../public/google_icon.svg";
import facebookIcon from "../../../public/facebook_icon.svg";
import githubIcon from "../../../public/github_icon.png";
import { useContext } from "react";
import { ThemeContext } from "../context/ThemeContext";

const page = () => {
  //export theme to use in other components
  const { theme } = useContext(ThemeContext);

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <div className={styles.socialButton}>
          <Image
            src={googleIcon}
            width={24}
            height={24}
            alt=""
            style={{
              filter: theme === "light" ? "invert(1)" : "",
            }}
          />
          Log in with Google
        </div>
        <div className={styles.socialButton}>
          <Image
            src={facebookIcon}
            width={24}
            height={24}
            alt=""
            style={{
              filter: theme === "light" ? "invert(1)" : "",
            }}
          />
          Log in with Facebook
        </div>
        <div className={styles.socialButton}>
          <Image
            src={githubIcon}
            width={24}
            height={24}
            alt=""
            style={{
              filter: theme === "light" ? "invert(1)" : "",
            }}
          />
          Log in with Github
        </div>
      </div>
    </div>
  );
};

export default page;
