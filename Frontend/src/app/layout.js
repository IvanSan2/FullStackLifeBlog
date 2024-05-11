import "./globals.css";
import { Inter } from "next/font/google";
import NavBar from "./components/navbar/NavBar";
import Footer from "./components/footer/Footer";
import { ThemeContextProvider } from "./context/ThemeContext";
import ThemeProvider from "./providers/ThemeProvider";
import localFont from "next/font/local";
import AuthProvider from "./providers/AuthProvider";

const inter = Inter({ subsets: ["latin"] });

const bartinaRegular = localFont({
  src: "../../fonts/BartinaRegular.ttf",
  display: "swap",
  variable: "--font-bartina-regular",
});

const bartinaBold = localFont({
  src: "../../fonts/BartinaBold.ttf",
  display: "swap",
  variable: "--font-bartina-bold",
});

const bartinaSemibold = localFont({
  src: "../../fonts/BartinaSemibold.ttf",
  display: "swap",
  variable: "--font-bartina-semibold",
});

export const metadata = {
  title: "FullstackLife Blog",
  description: "FullstackLife - Fullstack developer personal blog",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body
        className={`
        ${inter.className} 
        ${bartinaBold.variable} 
        ${bartinaRegular.variable} 
        ${bartinaSemibold.variable} 
        `}
      >
        <AuthProvider>
          <ThemeContextProvider>
            <ThemeProvider>
              <div className="container">
                <div className="wrapper">
                  <NavBar />
                  {children}
                  <Footer />
                </div>
              </div>
            </ThemeProvider>
          </ThemeContextProvider>
        </AuthProvider>
      </body>
    </html>
  );
}
