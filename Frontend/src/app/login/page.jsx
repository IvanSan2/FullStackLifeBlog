"use client";
import Image from "next/image";
import styles from "./loginPage.module.css";
import googleIcon from "../../../public/google_icon.svg";
import githubIcon from "../../../public/github_icon.png";
import { useContext, useEffect, useState } from "react";
import { ThemeContext } from "../context/ThemeContext";
import { useRouter } from "next/navigation";

const page = () => {
  //export theme to use in other components
  const { theme } = useContext(ThemeContext);
  const router = useRouter();
  const [jwt, setJwt] = useState(null);

  useEffect(() => {
    const getJwtFromUrl = async () => {
      const { jwt: token } = router.query;
      if (token) {
        try {
          const response = await fetch(
            `/api/v1/auth/oauth2/success`,
            {
              credentials: "include",
            }
          );
          const data = await response.json();
          const { jwt } = data;
          if (jwt) {
            console.log("JWT found in the response:", jwt);
            setJwt(jwt);
            saveJwtToLocalStorage(jwt);
            router.replace("/loginPage", undefined, { shallow: true });
          } else {
            console.error("JWT not found in the response");
          }
        } catch (error) {
          console.error("Error fetching JWT:", error);
        }
      }
    };

    getJwtFromUrl();
  }, [router]);

  const saveJwtToLocalStorage = (token) => {
    localStorage.setItem("jwt", token);
  };

  const handleGoogleLogin = () => {
    window.location.href =
      "/api/v1/auth/oauth2/authorize/google?redirect_uri=/loginPage";
  };

  const handleGithubLogin = () => {
    window.location.href =
      "/api/v1/auth/oauth2/authorize/github?redirect_uri=/loginPage";
  };

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <h1 className={styles.title}>Login</h1>
        <div className={styles.loginFormContainer}>
          <form className={styles.loginForm}>
            <input
              type="email"
              name="email"
              placeholder="Email"
              className={styles.input}
            />
            <input
              type="password"
              name="password"
              placeholder="Password"
              className={styles.input}
            />
            <button type="submit" className={styles.submitButton}>
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
          {/* if user is in database, give him jwt token */}
          {/* if user is not in database, add him to database and give him jwt token */}

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
