import Image from "next/image";
import styles from "./comment.module.css";
import HeartIcon from "../icons/HeartIcon";

export default function Comment({
  liked = false,
  userImage,
  username,
  date,
  text,
  likesCount,
}) {
  return (
    <div className={styles.container}>
      <div className={styles.comment}>
        <div className={styles.userImageContainer}>
          <Image
            src={userImage}
            alt=""
            width={50}
            height={50}
            className={styles.userImage}
          />
        </div>

        <div className={styles.commentContainer}>
          <div className={styles.user}>
            <span className={styles.username}>{username}</span>
            <span className={styles.userDate}>{date}</span>
          </div>
          <p className={styles.commentText}>{text}</p>
          <div className={styles.likeContainer}>
            <div className={styles.likes}>
              <div className={styles.likeButton}>
                <HeartIcon
                  fillColor={liked === true ? "red" : "var(--textColor)"}
                  width={24}
                />
              </div>
              <div className={styles.likesCount}>
                {likesCount > 0 ? likesCount : ""}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
