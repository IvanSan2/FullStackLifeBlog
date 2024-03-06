"use client";
import React from "react";
import styles from "./footer.module.css";
import Image from "next/image";
import instagram from "../../../../public/instagram_icon.png";
import linkedin from "../../../../public/linkedinl_icon.png";
import github from "../../../../public/github_icon.png";
import { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";
import Link from "next/link";

const Footer = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <div className={styles.container}>
      <div className={styles.info}>
        <div className={styles.logo}>FullstackLife</div>
        <p className={styles.desc}>
          Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ducimus
          iusto corrupti impedit, reiciendis nobis quo ex accusantium, sequi
          consequatur in voluptate possimus. Laudantium qui vel repellat tempore
          voluptatum odit nulla?
        </p>
        <div className={theme === "light" ? styles.social : styles.social_dark}>
          <Image src={instagram} alt="instagram" width={18} height={18} />
          <Image src={linkedin} alt="linkedin" width={18} height={18} />
          <Image src={github} alt="github" width={18} height={18} />
        </div>
      </div>
      <div className={styles.links}>
        <div className={styles.list}>
          <span className={styles.listTitle}>Links</span>
          <Link href="/">Home</Link>
          <Link href="/">Blog</Link>
          <Link href="/">About</Link>
          <Link href="/">Contact</Link>
        </div>
        <div className={styles.list}>
          <span className={styles.listTitle}>Tags</span>
          <Link href="/">Web</Link>
          <Link href="/">Mobile</Link>
          <Link href="/">Java</Link>
          <Link href="/">Design</Link>
          <Link href="/">Lifestyle</Link>
        </div>
        <div className={styles.list}>
          <span className={styles.listTitle}>Social</span>
          <Link href="/">Instagram</Link>
          <Link href="/">Linkedin</Link>
          <Link href="/">Github</Link>
        </div>
      </div>
    </div>
  );
};

export default Footer;
