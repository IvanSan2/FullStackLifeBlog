import React from "react";
import styles from "./pagination.module.css";

const Pagination = () => {
  return (
    <nav className={styles.container}>
      <button className={styles.button}>Previous</button>
      <button className={styles.button}>Next</button>
    </nav>
  );
};

export default Pagination;
