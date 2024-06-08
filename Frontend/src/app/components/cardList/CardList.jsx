"use client";
import React from "react";
import styles from "./cardList.module.css";
import Pagination from "../pagination/Pagination";
import Card from "../card/Card";
import { useEffect, useState } from "react";

const CardList = () => {
  const [loading, setLoading] = useState(true);
  const [posts, setPosts] = useState([]);
  const [totalPosts, setTotalPosts] = useState(0);
  const [pageNumber, setPageNumber] = useState(0);
  const [pageSize, setPageSize] = useState(5);
  const [totalPages, setTotalPages] = useState(0);
  const [isFirst, setIsFirst] = useState(true);
  const [isLast, setIsLast] = useState(false);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await fetch(
          `/api/v1/posts?pageNo=${pageNumber}&pageSize=${pageSize}&sortBy=createdAt&sortOrder=desc`
        );
        const data = await response.json();
        setLoading(false);

        if (response.ok) {
          setPosts(data.posts);
          setPageNumber(data.pageNumber);
          setTotalPosts(data.totalPosts);
          setTotalPages(data.totalPages);
          setIsFirst(data.first);
          setIsLast(data.last);
        }
        console.log(data);
      } catch (error) {
        setError(error);
        console.log(error);
        setLoading(false);
      }
    };
    fetchPosts();
  }, [pageNumber]);

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Recent posts</h1>
      <div className={styles.posts}>
        {loading ? (
          <h1>Loading...</h1>
        ) : (
          posts.map((post, i) => (
            <div className={styles.post}>
              <Card key={i} post={post} />
            </div>
          ))
        )}
      </div>
      <nav className={styles.btnContainer}>
        {!isFirst && (
          <button
            className={styles.button}
            onClick={() => setPageNumber((prev) => prev - 1)}
          >
            Previous
          </button>
        )}
        {!isLast && (
          <button
            className={styles.button}
            onClick={() => setPageNumber((prev) => prev + 1)}
          >
            Next
          </button>
        )}
      </nav>
    </div>
  );
};

export default CardList;
