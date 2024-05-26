"use client";
import Image from "next/image";
import styles from "./loginPage.module.css";
import googleIcon from "../../../public/google_icon.svg";
import githubIcon from "../../../public/github_icon.png";
import { useContext, useEffect, useState } from "react";
import { ThemeContext } from "../context/ThemeContext";
import { useRouter } from "next/navigation";
import { useAuth } from "../context/AuthContext";

const page = () => {
  const { theme } = useContext(ThemeContext);
  const router = useRouter();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useAuth();

  const handleGoogleLogin = () => {
    window.location.href = "/api/v1/auth/oauth2/authorize/google";
  };

  const handleGithubLogin = () => {
    window.location.href = "/api/v1/auth/oauth2/authorize/github";
  };

  const formLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("api/v1/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: email,
          password: password,
        }),
      });

      const data = await response.json();
      const jwt = data.jwt;
      login(jwt);
      router.push("/");
    } catch (error) {
      console.error("Error logging in:", error);
    }
  };

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <h1 className={styles.title}>Login</h1>
        <div className={styles.loginFormContainer}>
          <form className={styles.loginForm}>
            <input
              type="text"
              name="email"
              placeholder="Email or Username"
              className={styles.input}
              onChange={(e) => setEmail(e.target.value)}
            />
            <input
              type="password"
              name="password"
              placeholder="Password"
              className={styles.input}
              onChange={(e) => setPassword(e.target.value)}
            />
            <button
              type="submit"
              className={styles.submitButton}
              onClick={formLogin}
            >
              Login
            </button>
          </form>
          <p
            className={styles.forgotPassword}
            onClick={() => alert("I feel for you :(")}
          >
            Forgot password?
          </p>
        </div>
        <p className={styles.description}>
          Or login with your social media account
        </p>
        <div className={styles.socialButtonContainer}>
          <div className={styles.socialButton} onClick={handleGoogleLogin}>
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

          <div className={styles.socialButton} onClick={handleGithubLogin}>
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
    </div>
  );
};

export default page;
