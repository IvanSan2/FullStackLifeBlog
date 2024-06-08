"use client";
import { useEffect, useRef } from "react";
import { useRouter } from "next/navigation";
import styles from "./oAuth2Callback.module.css";
import axios from "axios";
import { useAuth } from "@/app/context/AuthContext";

const OAuth2CallbackPage = () => {
  const router = useRouter();
  const { login } = useAuth();
  const effectCalled = useRef(false);

  useEffect(() => {
    if (effectCalled.current) {
      return;
    }

    effectCalled.current = true;

    const getJwtToken = async () => {
      try {
        const response = await axios.get("https://fullstacklifeblogbackend.onrender.com/api/v1/auth/oauth2/success", {
          headers: {
            "Content-Type": "application/json",
          },
        });

        const data = await response.data;
        const jwt = data.jwt;
        console.log("JWT:", jwt);

        if (jwt) {
          login(jwt);
          router.push("/");
        }
      } catch (error) {
        console.error("Error getting JWT:", error);
        router.push("/login");
      }
    };

    getJwtToken();
  }, []);

  return (
    <div className={styles.container}>
      <div className={styles.title}>Redirecting...</div>
    </div>
  );
};

export default OAuth2CallbackPage;
