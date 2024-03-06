"use client";

import React from "react";
import styles from "./themeToggle.module.css";
import Image from "next/image";
import { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";
import sun from "../../../../public/sun.png";
import moon from "../../../../public/moon.png";

const ThemeToggle = () => {
  const { toggle, theme } = useContext(ThemeContext);

  return (
    <div
      className={styles.container}
      onClick={toggle}
      style={
        theme === "dark" ? { background: "white" } : { background: "#353535" }
      }
    >
      <Image src={sun} alt="sun icon" width={14} height={14} />
      <div
        className={styles.toggle}
        style={
          theme === "dark"
            ? { left: 1, background: "#353535" }
            : { right: 1, background: "white" }
        }
      ></div>
      <Image src={moon} alt="moon icon" width={14} height={14} />
    </div>
  );
};

export default ThemeToggle;
