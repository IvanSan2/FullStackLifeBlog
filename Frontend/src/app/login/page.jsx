"use client";
import Image from "next/image";
import styles from "./loginPage.module.css";
import googleIcon from "../../../public/google_icon.svg";
import githubIcon from "../../../public/github_icon.png";
import { useContext, useEffect } from "react";
import { ThemeContext } from "../context/ThemeContext";
import { signIn } from "next-auth/react";
import { useSession } from "next-auth/react";
import { useRouter } from "next/navigation";
// import { backendConnection } from "../utils/backendConnection";

const page = () => {
  //export theme to use in other components
  const { theme } = useContext(ThemeContext);
  const { data, status } = useSession();
  const router = useRouter();

  if (status === "loading") {
    return <div>Loading...</div>;
  }

  /* if user is in database, give him jwt token
  if user is not in database, add him to database and give him jwt token */
  useEffect(() => {
    if (status === "authenticated") {
      const login = async () => {
        const response = await fetch("/api/auth/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            email: data.user.email,
            name: data.user.name,
            image: data.user.image,
          }),
        });
        const data = await response.json();
        if (data.success) {
          router.push("/");
        }
      };
      login();
    }
  }, [status]);

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <div className={styles.socialButton} onClick={() => signIn("google")}>
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

        <div className={styles.socialButton} onClick={() => signIn("github")}>
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
