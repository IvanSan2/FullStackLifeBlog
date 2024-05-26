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

  //   const markdown = `# Hi, *Pluto*!

  //   ## Markdown syntax guide
  //   ### Headers
  //   # H1
  //   ## H2
  //   ### H3
  //   #### H4
  //   ##### H5
  //   ###### H6

  //   ### Emphasis
  //   *This text will be italic*
  //   _This will also be italic_
  //   **This text will be bold**
  //   __This will also be bold__
  //   _You **can** combine them_
  //   ### Lists

  //   #### Unordered

  //   * Item 1
  //   * Item 2
  //     * Item 2a
  //     * Item 2b
  //     * Item 2c
  //   #### Ordered

  //   1. Item 1
  //   2. Item 2
  //   3. Item 3
  //      * Item 3a
  //      * Item 3b
  //      * Item 3c
  //   ### Images

  //   ![GitHub Logo](https://logolook.net/wp-content/uploads/2022/12/GitHub-Logo.svg)
  //   Format: ![Alt Text](url)

  //   ### Links

  //   http://github.com - automatic!
  //   [GitHub](http://github.com)

  //   ### Blockquotes

  //   As Kanye West said:
  //   > We're living the future so
  //   > the present is our past.

  //   ### Inline code

  //   I think you should use an
  //   \`<addr>\` element here instead.

  //   ### Code blocks

  //   \`\`\`javascript
  //   function fancyAlert(arg) {
  //     if(arg) {
  //       $.facebox({div:'#foo'})
  //     }
  //   }
  //   \`\`\`

  //   \`\`\`python
  //   def foo():
  //     if not bar:
  //       return True
  //   \`\`\`

  //   \`\`\`css
  //   .editor tr {
  //     border-top: 1px solid #c6cbd1;
  //     /* background: #fff; */
  //   }
  //   .editor th,
  //   .editor td {
  //     padding: 12px 55px;
  //     border: 1px solid #dfe2e5;
  //   }
  //   .editor table tr:nth-child(2n) {
  //     /* background: #f6f8fa; */
  //   }
  //   .editor h1{
  //     font-size: 2em;
  //   }
  //   .editor h2{
  //     font-size: 1.5em;
  //   }
  //   .editor h3{
  //     font-size: 1.17em;
  //   }
  //   .editor h4{
  //     font-size: 1em;
  //   }
  //   .editor h5{
  //     font-size: .83em;
  //   }
  //   .editor h6{
  //     font-size: .67em;
  //   }
  //   .editor h1, h2, h3, h4, h5, h6{
  //       font-weight: bolder;
  //   }
  //   .editor blockquote {
  //     color: #fff;
  //     margin: 10px;
  //     padding-left: 1.2em;
  //     border-left: 0.2em #666 solid;
  //     font-style: italic;
  //   }
  //   .editor a{
  //     color: rgb(46, 46, 233);
  //   }
  //   .editor li{
  //     list-style-type: square;
  //   }
  //   .fullheight{
  //     height: 92vh;
  //   }
  // \`\`\`

  // \`\`\` java
  // package com.example.springboot;

  // import java.util.Arrays;

  // import org.springframework.boot.CommandLineRunner;
  // import org.springframework.boot.SpringApplication;
  // import org.springframework.boot.autoconfigure.SpringBootApplication;
  // import org.springframework.context.ApplicationContext;
  // import org.springframework.context.annotation.Bean;

  // @SpringBootApplication
  // public class Application {

  // 	public static void main(String[] args) {
  // 		SpringApplication.run(Application.class, args);
  // 	}

  // 	@Bean
  // 	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
  // 		return args -> {

  // 			System.out.println("Let's inspect the beans provided by Spring Boot:");

  // 			String[] beanNames = ctx.getBeanDefinitionNames();
  // 			Arrays.sort(beanNames);
  // 			for (String beanName : beanNames) {
  // 				System.out.println(beanName);
  // 			}

  // 		};
  // 	}

  // }
  // \`\`\`

  //   ### Tables

  //   | Syntax | Description |
  //   | ----------- | ----------- |
  //   | Header | Title |
  //   | Paragraph | Text |
  //   | Header | Title |
  //   | Paragraph | Text |
  //   | Header | Title |
  //   | Paragraph | Text |

  //   ### Task Lists

  //   - [x] @mentions, #refs, [links](), **formatting**, and <del>tags</del> supported
  //   - [x] list syntax required (any unordered or ordered list supported)
  //   - [x] this is a complete item
  //   - [x] this is a complete item @mentions, #refs, [links](), **formatting**, and <del>tags</del> supported list syntax required (any unordered or ordered list supported) this is a complete item this is a complete item this is a complete item
  //   - [ ] this is an incomplete item

  //   `;
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
