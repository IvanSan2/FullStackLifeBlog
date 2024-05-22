import styles from "./featuredSlide.module.css";
import Image from "next/image";
import noImage from "../../../../public/no-image.svg";
import userImage from "../../../../public/no-user-image.gif";

export default function FeaturedSlide({ slide }) {
  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <div className={styles.imageContainer}>
          <Image
            src={slide.image ? slide.image : noImage}
            alt=""
            fill="responsive"
            priority={true}
            className={styles.image}
          />
          <div className={styles.textContainer}>
            {/* max 70 symbols for title */}
            <h1 className={styles.title}>
              {slide.title.length > 70
                ? slide.title.slice(0, 67) + "..."
                : slide.title}
            </h1>
            <div className={styles.user}>
              <Image
                src={slide.user.image ? slide.user.image : userImage}
                alt=""
                width={50}
                height={50}
                className={styles.userImage}
              />
              <div className={styles.userTextContainer}>
                <span className={styles.username}>{slide.user.username}</span>
                <span className={styles.date}>
                  {
                    //if the date is more than 1 day ago, show the date, else show the time, if the date is less then 5 hours ago, show "just now"
                    new Date(slide.createdAt).getTime() <
                    new Date().getTime() - 86400000 // 1 day in ms
                      ? new Date(slide.createdAt).toLocaleDateString()
                      : new Date(slide.createdAt).getTime() >
                        new Date().getTime() - 3600000 // 1 hour in ms
                      ? "Just now"
                      : // show how much time ago the post was created
                        `${
                          Math.floor(
                            (new Date().getTime() -
                              new Date(slide.createdAt).getTime()) /
                              3600000
                          ) || 1
                        }h and ${Math.floor(
                          (new Date().getTime() -
                            new Date(slide.createdAt).getTime()) /
                            600000
                        )}m
                         ago`
                  }
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
