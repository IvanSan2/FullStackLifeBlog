"use client";
import "@uiw/react-md-editor/markdown-editor.css";
import "@uiw/react-markdown-preview/markdown.css";
import dynamic from "next/dynamic";
import { useState, useEffect, useContext } from "react";
import { ThemeContext } from "@/app/context/ThemeContext";

const MDEditor = dynamic(
  () => import("@uiw/react-md-editor").then((mod) => mod.default),
  { ssr: false }
);

function MarkdownEditor({ onData }) {
  const { theme } = useContext(ThemeContext);
  const [value, setValue] = useState("# **Hello world!!!**");

  useEffect(() => {
    onData(value);
  }, [value]);

  return (
    <div data-color-mode={theme}>
      <MDEditor
        value={value}
        onChange={setValue}
        style={{ height: "500px" }}
        height={document.documentElement.clientHeight - 550}
      />
    </div>
  );
}

export default MarkdownEditor;
