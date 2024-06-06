"use client";
import Markdown from "react-markdown";
import rehypeHighlight from "rehype-highlight";
import remarkGfm from "remark-gfm";
import rehypeAttrs from "rehype-attr";
import { useContext } from "react";
import { ThemeContext } from "../../context/ThemeContext";
import styles from "./markdownPreview.module.css";
import { useEffect, useState } from "react";

export default function MarkdownPreview({ ...props }) {
  const { theme } = useContext(ThemeContext);
  const [content, setContent] = useState(props.content);

  useEffect(() => {
    const importCss = async () => {
      if (theme === "dark") {
        await import("highlight.js/styles/a11y-dark.css");
      } else {
        await import("highlight.js/styles/a11y-light.css");
      }
    };

    importCss();
  }, [theme]);


  return (
    <div className={styles.container}>
      <Markdown
        rehypePlugins={[rehypeHighlight, remarkGfm, rehypeAttrs]}
        components={{
          code: ({ node, inline, className, children, ...props }) => {
            const match = /language-(\w+)/.exec(className || "");
            return !inline && match ? (
              <pre className={styles.codeContainer}>
                <div></div>
                <code className={styles.code} {...props}>
                  {children}
                </code>
              </pre>
            ) : (
              <code className={styles.code} {...props}>
                {children}
              </code>
            );
          },
        }}
      >
        {content}
      </Markdown>
    </div>
  );
}
