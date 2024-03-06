"use client";
import React, { use } from "react";
import styles from "./featured.module.css";
import FeaturedSlider from "../featuredSlider/FeaturedSlider";
import { useEffect, useState } from "react";

const Featured = () => {
  // const slides = [
  //   {
  //     id: 1,
  //     title: "Lorem ipsum.",
  //     desc: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     img: p1,
  //   },
  //   {
  //     id: 2,
  //     title: "Lorem ipsum dolor.",
  //     desc: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     img: p1,
  //   },
  //   {
  //     id: 3,
  //     title: "Lorem ipsum dolor sit amet consectetur adipisicing elit.",
  //     desc: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     img: p1,
  //   },
  //   {
  //     id: 4,
  //     title: "Lorem ipsum dolor sit 4.",
  //     desc: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     img: p1,
  //   },
  //   {
  //     id: 5,
  //     title:
  //       "Lorem ipsum dolor sit 5. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     desc: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cupiditate, quam nisi magni ea laborum inventore voluptatum laudantium repellat ducimus unde aspernatur fuga. Quo, accusantium quisquam! Harum unde sit culpa debitis.",
  //     img: whiteImage,
  //   },
  // ];

  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await fetch(
          "http://localhost:8080/api/v1/posts?pageNo=0&pageSize=5&sortBy=createdAt&sortOrder=desc"
        );
        console.log(response);
        const data = await response.json();
        console.log(data);
        setPosts(data.posts);
        setLoading(false);
      } catch (error) {
        setError(error);
        console.log(error);
        setLoading(false);
      }
    };
    fetchPosts();
  }, []);

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>
        <b>
          Welcome to <span className={styles.logo}>FullStackLife</span> blog:
        </b>{" "}
        where developers share knowledge
      </h1>
      {loading ? <div className={styles.sliderSkeleton}></div> : null}
      {error ? <div className={styles.error}>{error.message}</div> : null}

      <FeaturedSlider slides={posts} />
    </div>
  );
};

export default Featured;
