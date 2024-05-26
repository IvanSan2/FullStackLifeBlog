"use client";

import { createContext, useContext, useState, useEffect } from "react";
import { jwtDecode } from "jwt-decode";
import axios from "axios";

const AuthContext = createContext();

export const useAuth = () => {
  return useContext(AuthContext);
};

export const AuthProvider = ({ children }) => {
  const [jwt, setJwt] = useState(null);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const storedJwt = localStorage.getItem("jwt");
    if (storedJwt) {
      setJwt(storedJwt);
      setIsLoggedIn(true);
      checkTokenExpiration(storedJwt);
    }
  }, []);

  const login = (token) => {
    setJwt(token);
    setIsLoggedIn(true);
    localStorage.setItem("jwt", token);
    checkTokenExpiration(token);
  };

  const logout = () => {
    setJwt(null);
    setIsLoggedIn(false);
    localStorage.removeItem("jwt");
  };

  const checkTokenExpiration = (token) => {
    const decodedToken = jwtDecode(token);
    const currentTime = Date.now() / 1000;

    if (decodedToken.exp < currentTime) {
      // JWT token expired, refresh it
      refreshToken();
    }
  };

  const refreshToken = async () => {
    try {
      const response = await axios.post("/api/v1/auth/refresh-token", null, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      const newToken = await response.data.jwt;
      setJwt(newToken);
      localStorage.setItem("jwt", newToken);
      checkTokenExpiration(newToken);
    } catch (error) {
      console.error("Error accrued while refreshing token:", error);
      logout();
    }
  };

  const value = {
    jwt,
    isLoggedIn,
    login,
    logout,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
