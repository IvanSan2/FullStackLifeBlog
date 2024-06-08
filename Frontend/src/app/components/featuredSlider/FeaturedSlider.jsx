"use client";
import styles from "./featuredSlider.module.css";
import { useEffect, useLayoutEffect, useRef, useState } from "react";
import FeaturedSlide from "../featuredSlide/FeaturedSlide";
import { getRandomLogoShape } from "../../utils/math";
import { useRouter } from "next/navigation";

export default function FeaturedSlider({ slides }) {
  // ref - to get the width of the slider container
  const ref = useRef(null);
  // current index of the slide
  const [currentIndex, setCurrentIndex] = useState(0);
  // width of the slider container
  const [sliderWidth, setSliderWidth] = useState(0);

  const router = useRouter();

  // get the width of the slider container on mount
  useLayoutEffect(() => {
    setSliderWidth(ref.current.clientWidth);
  }, []);

  // get the width of the slider container on resize
  useEffect(() => {
    function handleResize() {
      setSliderWidth(ref.current.clientWidth);
    }
    window.addEventListener("resize", handleResize);

    return () => window.removeEventListener("resize", handleResize);
  }, []);

  // auto scroll
  function autoScroll() {
    if (currentIndex === slides.length - 1) {
      setCurrentIndex(0);
    } else {
      setCurrentIndex(currentIndex + 1);
    }
  }

  // auto scroll every 5 seconds
  useEffect(() => {
    const interval = setInterval(autoScroll, 5000);
    return () => clearInterval(interval);
  }, [currentIndex, autoScroll]);

  //TODO: add swipe effect to the slider

  return (
    <div className={styles.container} ref={ref}>
      <div className={styles.sliderContainer}>
        <div
          className={styles.slider}
          style={{
            transform: `translateX(-${currentIndex * sliderWidth}px)`,
          }}
        >
          {slides.map((slide, i) => (
            <div key={i} className={styles.slide}>
              <FeaturedSlide slide={slide} key={slide.id} />
            </div>
          ))}
        </div>
      </div>
      <div className={styles.arrowContainer}>
        <div
          className={styles.arrowLeft}
          style={{
            borderRadius: `${getRandomLogoShape()}`,
            display: currentIndex === 0 && "none",
          }}
          onClick={() => setCurrentIndex(currentIndex - 1)}
        >
          ❰
        </div>
        <div
          className={styles.arrowRight}
          style={{
            borderRadius: `${getRandomLogoShape()}`,
            display: currentIndex === slides.length - 1 && "none",
          }}
          onClick={() => setCurrentIndex(currentIndex + 1)}
        >
          ❱
        </div>
      </div>
    </div>
  );
}
