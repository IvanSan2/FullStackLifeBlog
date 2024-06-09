"use client";

import React from "react";
import styles from "./navbar.module.css";
import Image from "next/image";
import Link from "next/link";
import AuthLinks from "../authLinks/AuthLinks";
import ThemeToggle from "../themeToggle/ThemeToggle";
import linkedin from "../../../../public/linkedinl_icon.png";
import github from "../../../../public/github_icon.png";
import { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";

const NavBar = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <nav className={styles.container}>
      <div className={theme === "light" ? styles.social : styles.social_dark}>
        
        <Link href="https://www.linkedin.com/in/ivansann/" target="_blank">
          <Image src={linkedin} alt="linkedin" width={24} height={24} />
        </Link>
        <Link href="https://github.com/IvanSan2" target="_blank">
          <Image src={github} alt="github" width={24} height={24} />
        </Link>
      </div>
      <Link href="/" className={styles.logo}>
        FullstackLife
      </Link>
      <div className={styles.links}>
        <ThemeToggle />
        <Link href="/" className={styles.link}>
          Home
        </Link>
      
        <Link href="/about" className={styles.link}>
          About
        </Link>
        <AuthLinks />
      </div>
    </nav>
  );
};

export default NavBar;
