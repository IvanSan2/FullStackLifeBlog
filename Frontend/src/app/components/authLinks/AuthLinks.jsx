"use client";

import styles from "./authLinks.module.css";
import Link from "next/link";
import { useState, useContext } from "react";
import Image from "next/image";
import plusIcon from "../../../../public/plus_icon.svg";
import { ThemeContext } from "@/app/context/ThemeContext";
import { useAuth } from "@/app/context/AuthContext";

const AuthLinks = () => {
  const [open, setOpen] = useState(false);
  const { theme } = useContext(ThemeContext);
  // const [status, setStatus] = useState("notauthenticated");
  const { isLoggedIn, logout } = useAuth();

  return (
    <>
      {!isLoggedIn ? (
        <>
          <Link href="/login" className={styles.link}>
            Login
          </Link>
        </>
      ) : (
        <>
          <Link href="/write" className={styles.link}>
            <Image
              src={plusIcon}
              width={24}
              height={24}
              alt="New Post"
              style={{
                filter: theme === "dark" ? "invert(1)" : "invert(0)",
              }}
              className={styles.plusIcon}
            />
          </Link>
          <Link href="/" className={styles.link} onClick={logout}>
            Logout
          </Link>
        </>
      )}
      <div className={styles.burger} onClick={() => setOpen(!open)}>
        <div className={styles.line}></div>
        <div className={styles.line}></div>
        <div className={styles.line}></div>
      </div>
      {open && (
        <div className={styles.responsiveMenu}>
          <Link href="/">Home</Link>
          <Link href="/">Contact</Link>
          <Link href="/">About</Link>
          {!isLoggedIn ? (
            <>
              <Link href="/login">Login</Link>
            </>
          ) : (
            <>
              <Link href="/write">Write</Link>
              <Link href="/logout">Logout</Link>
            </>
          )}
        </div>
      )}
    </>
  );
};

export default AuthLinks;
