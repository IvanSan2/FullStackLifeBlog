"use client";
import "@uiw/react-md-editor/markdown-editor.css";
import "@uiw/react-markdown-preview/markdown.css";
import dynamic from "next/dynamic";
import { useState } from "react";
import { useContext } from "react";
import { ThemeContext } from "@/app/context/ThemeContext";
import MarkdownPreview from "./MarkdownPreview";

const MDEditor = dynamic(
  () => import("@uiw/react-md-editor").then((mod) => mod.default),
  { ssr: false }
);

function MarkdownEditor() {
  const { theme } = useContext(ThemeContext);
  const [value, setValue] = useState("**Hello world!!!**");

  return (
    <div data-color-mode={theme}>
      <MDEditor
        value={value}
        onChange={setValue}
        style={{ height: "300px" }}
        height={document.documentElement.clientHeight - 550}
      />
      <div style={{ paddingTop: 50 }}>
        <MarkdownPreview value={value} />
      </div>
    </div>
  );
}

export default MarkdownEditor;
