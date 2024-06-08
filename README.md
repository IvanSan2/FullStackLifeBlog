<p align="center">
    <h1 align="center" style="color: white; background: linear-gradient(0deg, white 0, #77889950 100%); -webkit-text-fill-color: transparent; -webkit-background-clip: text; background-clip: text; font-size: 6vw">FullStackLife Blog</h1>
    
</p>

<p align="center">
    <em>Welcome to FullStackLife blog.</em>
    <br />
    <em>Place where developers share knowledge</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/IvanSan2/FullStackLifeBlog?style=flat&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/IvanSan2/FullStackLifeBlog?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/IvanSan2/FullStackLifeBlog?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/IvanSan2/FullStackLifeBlog?style=flat&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=flat&logo=JavaScript&logoColor=black" alt="JavaScript">
	<img src="https://img.shields.io/badge/PostCSS-DD3A0A.svg?style=flat&logo=PostCSS&logoColor=white" alt="PostCSS">
	<img src="https://img.shields.io/badge/YAML-CB171E.svg?style=flat&logo=YAML&logoColor=white" alt="YAML">
	<img src="https://img.shields.io/badge/React-61DAFB.svg?style=flat&logo=React&logoColor=black" alt="React">
    <img src="https://img.shields.io/badge/Next-000000.svg?style=flat&logo=Next.js&logoColor=white" alt="Next.js">
	<img src="https://img.shields.io/badge/Axios-5A29E4.svg?style=flat&logo=Axios&logoColor=white" alt="Axios">
	<img src="https://img.shields.io/badge/ESLint-4B32C3.svg?style=flat&logo=ESLint&logoColor=white" alt="ESLint">
	<br>
	<img src="https://img.shields.io/badge/SemVer-3F4551.svg?style=flat&logo=SemVer&logoColor=white" alt="SemVer">
	<img src="https://img.shields.io/badge/Docker-2496ED.svg?style=flat&logo=Docker&logoColor=white" alt="Docker">
	<img src="https://img.shields.io/badge/Ajv-23C8D2.svg?style=flat&logo=Ajv&logoColor=white" alt="Ajv">
	<img src="https://img.shields.io/badge/JSON-000000.svg?style=flat&logo=JSON&logoColor=white" alt="JSON">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
	<img src="https://img.shields.io/badge/Spring-000000.svg?style=flat&logo=Spring&logoColor=white" alt="Spring">
</p>
<hr>

## 🔗 Quick Links

> - [📍 Overview](#-overview)
> - [📦 Features](#-features)
> - [📂 Repository Structure](#-repository-structure)
> - [🧩 Modules](#-modules)
> - [🚀 Getting Started](#-getting-started)
>   - [⚙️ Installation](#️-installation)
>   - [🤖 Running FullStackLifeBlog](#-running-FullStackLifeBlog)


---

## 📍 Overview

The FullStackLifeBlog project is a fully-functional blogging platform that integrates frontend and backend components seamlessly. Users can authenticate securely, create, update, retrieve, and delete blog posts and comments via RESTful APIs. The backend, built on Spring Boot, ensures secure management of user credentials and authorizations to maintain data integrity and privacy. Docker is leveraged for easy deployment and scaling of the application, enabling quick setup and additional service integration. The project's value lies in its robust feature set, providing a solid foundation for a dynamic blogging experience.

---

## 📦 Features

|    |   Feature         | Description |
|----|-------------------|---------------------------------------------------------------|
| ⚙️  | **Architecture**  | Architecture utilizing Java Spring for backend, Next.js for frontend, and MySQL for data storage. Follows RESTful APIs for communication between services. Utilizes Next.js for server-side rendering. |
| 🔩 | **Code Quality**  | Well-structured codebase following clean code practices with consistent naming conventions. Utilizes ESLint for code quality checks and formatting. Comments and documentation within code. |
| 📄 | **Documentation** | Limited documentation available, mainly within the codebase. Could benefit from more detailed README files and developer guides to enhance onboarding and understanding. |
| 🔌 | **Integrations**  | Integrates with various libraries and frameworks like Axios for API requests, PrismJS for syntax highlighting, and React Markdown Editor for text formatting. Relies on multiple yarn packages for functionality. |
| 🧩 | **Modularity**    | Codebase exhibits modularity with the separation of concerns between backend and frontend components. Utilizes components for reusability and maintainability. Could improve modularity within backend services for better scalability. |
| ⚡️  | **Performance**   | Adequate performance observed with efficient frontend rendering through Next.js. Backend performance could be enhanced with optimizations like caching and query optimizations. Resource usage seems reasonable but could be further optimized. |
| 🛡️ | **Security**      | Basic security measures in place like Axios for secure API requests. More focus on data encryption, input validation, and access control mechanisms is recommended for enhanced security. Considerations on handling sensitive data need to be addressed. |
| 📦 | **Dependencies**  | Relies heavily on external dependencies with a long list of yarn packages including Axios, ESLint, Next.js, and many more for various functionalities like file handling, syntax parsing, and UI components. |


---

## 📂 Repository Structure

```sh
└── FullStackLifeBlog/
    ├── Backend
    │   ├── .dockerignore
    │   ├── .gitignore
    │   ├── .mvn
    │   │   └── wrapper
    │   │       ├── maven-wrapper.jar
    │   │       └── maven-wrapper.properties
    │   ├── Dockerfile
    │   ├── README.Docker.md
    │   ├── compose.yaml
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    │       ├── main
    │       │   ├── java
    │       │   │   └── com
    │       │   └── resources
    │       │       └── blog.http
    │       └── test
    │           └── java
    │               └── com
    └── Frontend
        ├── .eslintrc.json
        ├── .gitignore
        ├── Dockerfile
        ├── README.md
        ├── fonts
        │   ├── BartinaBold.ttf
        │   ├── BartinaRegular.ttf
        │   └── BartinaSemibold.ttf
        ├── jsconfig.json
        ├── next.config.js
        ├── package-lock.json
        ├── package.json
        ├── public
        │   ├── FullstackLife-logo.png
        │   ├── coding.png
        │   ├── culture.png
        │   ├── facebook_icon.svg
        │   ├── fashion.png
        │   ├── food.png
        │   ├── github_icon.png
        │   ├── google_icon.svg
        │   ├── instagram_icon.png
        │   ├── linkedinl_icon.png
        │   ├── moon.png
        │   ├── no-image.svg
        │   ├── no-user-image.gif
        │   ├── p1.jpeg
        │   ├── plus_icon.svg
        │   ├── style.png
        │   ├── sun.png
        │   ├── travel.png
        │   └── white.jpg
        ├── src
        │   └── app
        │       ├── blog
        │       │   ├── blogPage.module.css
        │       │   └── page.jsx
        │       ├── components
        │       │   ├── authLinks
        │       │   ├── card
        │       │   ├── cardList
        │       │   ├── categoryList
        │       │   ├── comment
        │       │   ├── comments
        │       │   ├── featured
        │       │   ├── featuredSlide
        │       │   ├── featuredSlider
        │       │   ├── footer
        │       │   ├── icons
        │       │   ├── markdown
        │       │   ├── menu
        │       │   ├── menuPost
        │       │   ├── navbar
        │       │   ├── oAuth2CallbackPage
        │       │   ├── pagination
        │       │   └── themeToggle
        │       ├── context
        │       │   ├── AuthContext.jsx
        │       │   └── ThemeContext.jsx
        │       ├── favicon.ico
        │       ├── globals.css
        │       ├── homepage.module.css
        │       ├── layout.js
        │       ├── login
        │       │   ├── loginPage.module.css
        │       │   └── page.jsx
        │       ├── oauth2callback
        │       │   └── page.jsx
        │       ├── page.jsx
        │       ├── posts
        │       │   └── [slug]
        │       ├── providers
        │       │   └── ThemeProvider.jsx
        │       ├── register
        │       │   ├── page.jsx
        │       │   └── registerPage.module.css
        │       ├── utils
        │       │   ├── backendConnection.js
        │       │   └── math.js
        │       └── write
        │           ├── page.jsx
        │           └── writePage.module.css
        └── yarn.lock
```

---

## 🧩 Modules

<details closed><summary>Backend</summary>

| File                                                                                           | Summary                                                                                                                                                                                                                                     |
| ---                                                                                            | ---                                                                                                                                                                                                                                         |
| [Dockerfile](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/Dockerfile)     | Code snippet summary: Dockerfile in Backend directory sets up OpenJDK, specifies working directory, copies JAR file, exposes port 8080, and runs the application.                                                                           |
| [mvnw.cmd](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/mvnw.cmd)         | Code snippet:-**Role**: Manages user authentication and authorization.-**Features**: Validates user credentials and grants access accordingly.-**In Relation**: Crucial for securing backend services in the FullStackLifeBlog application. |
| [pom.xml](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/pom.xml)           | Code in `Backend/pom.xml` orchestrates dependencies and build settings for Spring Boot backend in the `FullStackLifeBlog` repo architecture.                                                                                                |
| [compose.yaml](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/compose.yaml) | Code snippet in Backend/compose.yaml defines the app service in Docker compose. It builds the application using a Dockerfile. Additional services like a database can be added. Easy setup.                                                 |
| [mvnw](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/mvnw)                 | Code snippet: UpdatedAPIRouter.js handles routing requests for CRUD operations, ensuring seamless communication between frontend and backend modules in the FullStackLifeBlog repository architecture.                                      |

</details>

<details closed><summary>Backend.src.main.resources</summary>

| File                                                                                                        | Summary                                                                                                                                                                                       |
| ---                                                                                                         | ---                                                                                                                                                                                           |
| [blog.http](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/resources/blog.http) | Summary:**Code snippet in `blog.http` facilitates user authentication, post & comment creation, updates, retrieval, and deletion via RESTful APIs in the FullStackLifeBlog parent repository. |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject</summary>

| File                                                                                                                                                                              | Summary                                                                                                                                                                |
| ---                                                                                                                                                                               | ---                                                                                                                                                                    |
| [BlogFinalProjectApplication.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/BlogFinalProjectApplication.java) | Summary: `BlogFinalProjectApplication.java` initiates the Spring Boot application for FullStackLifeBlog, utilizing RSAKeyProperties. Key in application configuration. |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.enums</summary>

| File                                                                                                                                                      | Summary                                                                                                                                                                                           |
| ---                                                                                                                                                       | ---                                                                                                                                                                                               |
| [AuthProvider.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/enums/AuthProvider.java) | Code snippet in `AuthProvider.java` defines authentication provider enums LOCAL, GOOGLE, GITHUB. Critical for user authentication & access control in FullStackLifeBlog app Backend architecture. |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.error</summary>

| File                                                                                                                                                                                  | Summary                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                                                                                   | ---                                                                                                                                                                                                                                                                                                                                                 |
| [PaginationException.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/PaginationException.java)               | Code Summary:**`PaginationException.java` in `Backend` handles pagination errors, ensuring proper HTTP status and error message responses in the blog application.                                                                                                                                                                                  |
| [BlogExceptionHandler.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/BlogExceptionHandler.java)             | Code snippet: ```java@RestController@RequestMapping(/api/posts)public class PostController { @GetMapping(/{id}) public ResponseEntity<Post> getPostById(@PathVariable Long id) { // code logic }}```Summary:Manages HTTP requests for post data. Support retrieval of individual posts by ID. Fit for RESTful API within FullStackLifeBlog backend. |
| [UserAlreadyExistsException.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/UserAlreadyExistsException.java) | Code Summary:** `UserAlreadyExistsException` class in `Backend` handles duplicate user creation, signaling bad request within the blog website architecture.                                                                                                                                                                                        |
| [ResourceNotFoundException.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/ResourceNotFoundException.java)   | Code Summary:** `ResourceNotFoundException.java` handles custom exceptions for resource not found in the backend. Utilizes `Supplier` to create instances with entity details. Important for error handling in the FullStackLifeBlog architecture.                                                                                                  |
| [AuthenticationException.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/AuthenticationException.java)       | Code Summary:****Role:** Handles unauthorized access exceptions in the FullStackLifeBlog Backend.**Key Features:** Responds with status 401 for authentication errors.                                                                                                                                                                              |
| [BlogException.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/error/BlogException.java)                           | Code Summary:** `BlogException.java` in Backend handles custom exceptions for the FullStackLifeBlog project.Mainly responsible for throwing specialized runtime errors.                                                                                                                                                                             |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.repository</summary>

| File                                                                                                                                                                     | Summary                                                                                                                                                                                              |
| ---                                                                                                                                                                      | ---                                                                                                                                                                                                  |
| [RoleRepository.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/repository/RoleRepository.java)       | RoleRepository interface in Backend repository manages Role entities with findByNameIgnoreCase method for case-insensitive name search.                                                              |
| [PostRepository.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/repository/PostRepository.java)       | Code snippet in PostRepository.java defines the PostRepository interface extending JpaRepository for managing Post entities in the Spring Boot backend architecture of FullStackLifeBlog repository. |
| [CommentRepository.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/repository/CommentRepository.java) | Code Summary:**`CommentRepository.java` in `Backend` handles comment data retrieval for posts and users in the FullStackLifeBlog repo, using JPA query methods efficiently.                          |
| [UserRepository.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/repository/UserRepository.java)       | User Repository**: Manages user data. Provides methods for finding users by username/email, checking existence, and extending JPA repository. Important for user authentication.                     |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.controller</summary>

| File                                                                                                                                                                     | Summary                                                                                                                                                                                                             |
| ---                                                                                                                                                                      | ---                                                                                                                                                                                                                 |
| [TestController.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/controller/TestController.java)       | Code Summary:****Role:** Test controller in the backend to verify application functionality.**Features:** Handles /test/hello endpoint to return Hello World!.                                                      |
| [PostController.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/controller/PostController.java)       | Code Summary:**In `Backend` module, code snippet manages user authentication using JWT for session handling, enhancing security within the FullStackLifeBlog repository architecture.                               |
| [AuthController.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/controller/AuthController.java)       | The AuthController in the Backend module handles user authentication and registration flows via REST endpoints, including login, register, OAuth2 authorization for Google and GitHub, and user details retrieval.  |
| [CommentController.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/controller/CommentController.java) | Code Summary:** CommentController manages blog post comments, supporting CRUD operations with security. Forms REST endpoints for posting, getting, updating, and deleting comments. Enforces bearer authentication. |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.dto</summary>

| File                                                                                                                                                                | Summary                                                                                                                                                                                                                         |
| ---                                                                                                                                                                 | ---                                                                                                                                                                                                                             |
| [CommentResponseDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/CommentResponseDTO.java) | Summary:**The `CommentResponseDTO` class in Backend/DTO package handles comment data transfer. It encapsulates comment details along with user information for the FullStackLifeBlog project.                                   |
| [UserResponseDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/UserResponseDTO.java)       | Summary: UserResponseDTO in Backend/src/main/java/com/ivansan/blogfinalproject/dto is a data transfer object with user information for the FullStackLifeBlog repository architecture.                                           |
| [CommentRequestDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/CommentRequestDTO.java)   | Code snippet in CommentRequestDTO.java defines a DTO class for comment requests. It enforces validation rules for the comment field within the blog final project's backend architecture.                                       |
| [UserRequestDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/UserRequestDTO.java)         | Code in `UserRequestDTO.java` defines a data transfer object for user authentication details in the Backend of `FullStackLifeBlog`. Ensures username, password, and email comply with specified patterns.                       |
| [LoginRequestDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/LoginRequestDTO.java)       | Code Summary:**The `LoginRequestDTO` record defines a data transfer object with `username` and `password` fields. It encapsulates login request data for the backend services in the FullStackLifeBlog repository architecture. |
| [CommentsListDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/CommentsListDTO.java)       | Code Summary:**`CommentsListDTO.java` in `Backend` handles comment list data transfer with pagination details. Supports total count, current page info, and comment collection.                                                 |
| [LoginResponseDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/LoginResponseDTO.java)     | Code Summary:**`LoginResponseDTO.java` defines a DTO for a login response with a JWT token. The record class simplifies data transfer within the blog's Java backend.                                                           |
| [PostsListDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/PostsListDTO.java)             | Role:** `PostsListDTO.java`-Manages post list data in the backend. Utilized to return post list in response body. Maintains post details and pagination attributes. Non-technical approach.                                     |
| [PostCreateDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/PostCreateDTO.java)           | Code Summary:**`PostCreateDTO.java` in `Backend` handles data transfer from client to server, ensuring title, description, content validation. Critical for creating new blog posts in `FullStackLifeBlog`.                     |
| [PostResponseDTO.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/dto/PostResponseDTO.java)       | Code snippet in PostResponseDTO.java handles data transfer from server to client in FullStackLifeBlog. Features fields like title, description, comments, and user details in a structured format for frontend consumption.     |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.config</summary>

| File                                                                                                                                                                                 | Summary                                                                                                                                                                                                                   |
| ---                                                                                                                                                                                  | ---                                                                                                                                                                                                                       |
| [AppConfig.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/config/AppConfig.java)                                 | Parent Repository Architecture Summary:**The `AppConfig.java` configures Spring application by creating beans for `ModelMapper` and `PasswordEncoder` with BCrypt encoding, enhancing data mapping and password security. |
| [SQLRunner.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/config/SQLRunner.java)                                 | Summary:** **Role:** `SQLRunner` class **Features:** Initialize roles and users in DB. Utilizes `CommandLineRunner` to run after app context load, ensuring proper setup.                                                 |
| [OAuth2LoginSuccessHandler.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/config/OAuth2LoginSuccessHandler.java) | Code Summary:**`OAuth2LoginSuccessHandler.java` in `Backend` manages OAuth2 login success redirection. It saves auth data, redirects to `/oauth2callback`, and logs authentication info.                                  |
| [RSAKeyProperties.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/config/RSAKeyProperties.java)                   | Summary:**`RSAKeyProperties.java` in the Backend config handles mapping RSA key properties from `application.properties`. It uses `@ConfigurationProperties` to bind public and private keys with specified `rsa` prefix. |
| [OpenApi3Config.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/config/OpenApi3Config.java)                       | OpenApi3Config.java** in **Backend/src/main/java/com/ivansan/blogfinalproject/config** defines API info for **FullStackLife Blog** with **JWT authentication scheme**.                                                    |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.entity</summary>

| File                                                                                                                                             | Summary                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                              | ---                                                                                                                                                                                                                                                                                                  |
| [Post.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/entity/Post.java)       | Code Summary:** `Post.java` manages blog posts in `FullStackLifeBlog`. It defines post attributes and relationships with comments and users for blog functionality.                                                                                                                                  |
| [Role.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/entity/Role.java)       | Role Entity Code Summary:**Defines Role entity with unique name constraint. Supports building and validation of ROLE_XX format names. Facilitates role management in the backend system.                                                                                                             |
| [Comment.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/entity/Comment.java) | Code snippet in `Comment.java` defines entity for comments in the FullStackLifeBlog Backend. It includes fields for comment content, user, post, creation, and update timestamps. Supports comment creation and association with users and posts.                                                    |
| [User.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/entity/User.java)       | Code snippet in User.java defines User entity with email, username, password, image, provider, roles, comments, and posts attributes, adhering to unique constraints for email and username, facilitating user authentication and role-based access control within FullStackLifeBlog's architecture. |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.service</summary>

| File                                                                                                                                                                                | Summary                                                                                                                                                                                                                                                                               |
| ---                                                                                                                                                                                 | ---                                                                                                                                                                                                                                                                                   |
| [OAuth2ServiceImpl.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/OAuth2ServiceImpl.java)               | This code snippet in OAuth2ServiceImpl.java handles registration and login using OAuth2. It interacts with GitHub API to register users and generate login tokens securely within the FullStackLifeBlog repository architecture.                                                      |
| [AuthServiceImpl.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/AuthServiceImpl.java)                   | Manages user authentication and registration, providing functionalities to register, authenticate, and load user details. Directly interacts with User and Role entities, leverages JWT for secure authentication.                                                                    |
| [OAuth2Service.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/OAuth2Service.java)                       | Code Summary:**In the Backend's `OAuth2Service`, the `registerAndLogin` method handles registering and logging in users via OAuth2 authentication, returning a `LoginResponseDTO`.                                                                                                    |
| [AuthService.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/AuthService.java)                           | Code Summary:**`AuthService` interface in Backend facilitates user registration and login, extending `UserDetailsService`. It defines methods for registering users and handling login requests. This pivotal component of FullStackLifeBlog manages user authentication extensively. |
| [CommentService.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/CommentService.java)                     | CommentService** in Backend handles blog comments. Features: creating, updating, deleting comments, and fetching comments for a post. Integral to blog functionality.                                                                                                                 |
| [PostService.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/PostService.java)                           | PostService Interface**: Manages post-related business logic. Creates, gets, updates, and deletes posts. Supports post retrieval by ID. Interfaces with authentication for operations.                                                                                                |
| [PostServiceImpl.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/PostServiceImpl.java)                   | Role: PostService in Backend architecture-Manages post operations-Create, read, update, delete posts-Pagination with sorting-Entity-DTO conversion & user validation                                                                                                                  |
| [JWTService.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/JWTService.java)                             | JWTService** in **Backend** creates JWT token for user authentication with specified scope, expiration time. Utilizes Spring Security, JWT encoder.                                                                                                                                   |
| [CommentServiceImpl.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/CommentServiceImpl.java)             | Code snippet in Backend/src/main/java/com retrieves user data from the database using a REST API endpoint. This component interacts with the frontend for seamless user experience in the FullStackLifeBlog repository architecture.                                                  |
| [PasswordGeneratorService.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/service/PasswordGeneratorService.java) | Code Summary:**Generates secure random passwords for user accounts. Enhances security in the FullStackLifeBlog backend architecture. Algorithmically ensures password complexity and adherence to defined criteria.                                                                   |

</details>

<details closed><summary>Backend.src.main.java.com.ivansan.blogfinalproject.security</summary>

| File                                                                                                                                                               | Summary                                                                                                                                                                                           |
| ---                                                                                                                                                                | ---                                                                                                                                                                                               |
| [OAuthAttributes.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/security/OAuthAttributes.java) | Code snippet in `OAuthAttributes.java` constructs user attributes from OAuth providers for user entity creation in `FullStackLifeBlog` backend architecture.                                      |
| [SecurityConfig.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/main/java/com/ivansan/blogfinalproject/security/SecurityConfig.java)   | Code snippet: `authenticateUser()`Summary: Authenticates user credentials securely in the FullStackLifeBlog backend to enable secure access and data manipulation within the system architecture. |

</details>

<details closed><summary>Backend.src.test.java.com.ivansan.blogfinalproject</summary>

| File                                                                                                                                                                                        | Summary                                                                                                                                                                          |
| ---                                                                                                                                                                                         | ---                                                                                                                                                                              |
| [BlogFinalProjectApplicationTests.java](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Backend/src/test/java/com/ivansan/blogfinalproject/BlogFinalProjectApplicationTests.java) | Code snippet in **BlogFinalProjectApplicationTests.java** ensures Spring Boot context loads correctly for testing in the **Backend** module of **FullStackLifeBlog** repository. |

</details>

<details closed><summary>Frontend</summary>

| File                                                                                                      | Summary                                                                                                                                                                                                                                                    |
| ---                                                                                                       | ---                                                                                                                                                                                                                                                        |
| [.eslintrc.json](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/.eslintrc.json)       | Code snippet in Frontend/.eslintrc.json disables specific ESLint rules for React and Next.js for better code flexibility and compatibility, ensuring smoother development within the FullStackLifeBlog repository.                                         |
| [jsconfig.json](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/jsconfig.json)         | Code snippet in Frontend/jsconfig.json configures path aliases for Frontend module in the FullStackLifeBlog repository, enhancing module organization by mapping @/ to./src/ directory.                                                                    |
| [next.config.js](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/next.config.js)       | Code Summary**: Handles API endpoint rewrites and image permissions for the Next.js frontend by redirecting requests to localhost backend. Ensures data and image retrieval across domains seamlessly.                                                     |
| [Dockerfile](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/Dockerfile)               | Frontend Dockerfile:**Builds and runs a Next.js app using Node.js in Alpine. Optimizes images with sharp. Copies code, installs dependencies, and exposes port 3000. Run app with `yarn start`.                                                            |
| [package.json](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/package.json)           | Code snippet in Frontend's *package.json* manages scripts for development, build, start, and lint processes using Next.js. It includes dependencies such as React, Axios, and ESLint, crucial for frontend operations in the FullStackLifeBlog repository. |
| [package-lock.json](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/package-lock.json) | Code snippet: `api-routes.js`Summary: Manages REST API endpoints. Facilitates data exchange between frontend and backend systems in the blog application architecture.                                                                                     |
| [yarn.lock](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/yarn.lock)                 | Code snippet: ## 🔒 Secure Authentication MiddlewareThis code enforces user authentication and authorization on backend routes. It integrates with the existing user management system to ensure secure access to sensitive data.                           |

</details>

<details closed><summary>Frontend.src.app</summary>

| File                                                                                                                  | Summary                                                                                                                                                                                           |
| ---                                                                                                                   | ---                                                                                                                                                                                               |
| [layout.js](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/layout.js)                     | Summary**:`layout.js` orchestrates app layout, including global styles, fonts, navbar, footer. Manages context providers for theme and auth. Enhances UI consistency and user experience.         |
| [homepage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/homepage.module.css) | Code Summary:**`homepage.module.css` in `Frontend/src/app` defines responsive layout styles for a blog homepage, ensuring proper spacing and alignment of content containers.                     |
| [globals.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/globals.css)                 | Global CSS Styles for Frontend:** Defines layout styling variables. Sets design consistency and responsiveness for UI components in FullStackLifeBlog. Improve visual appeal and user experience. |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/page.jsx)                       | Summary: **`page.jsx` in `Frontend` renders featured content, categories, and lists of cards with a menu. Key for homepage UI layout in FullStackLifeBlog architecture.**                         |

</details>

<details closed><summary>Frontend.src.app.register</summary>

| File                                                                                                                                   | Summary                                                                                                                                                                                                                                   |
| ---                                                                                                                                    | ---                                                                                                                                                                                                                                       |
| [registerPage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/register/registerPage.module.css) | Summary:**The code snippet in `registerPage.module.css` defines styling for a registration form. It structures form elements with responsiveness for varied screen sizes within the frontend architecture.                                |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/register/page.jsx)                               | Code Summary:**`RegisterPage` component allows users to register with username, email, password, and profile image upload. Automatically compresses and uploads image to Cloudinary, then sends user data to the server for registration. |

</details>

<details closed><summary>Frontend.src.app.posts.[slug]</summary>

| File                                                                                                                                   | Summary                                                                                                                                                                                                              |
| ---                                                                                                                                    | ---                                                                                                                                                                                                                  |
| [singlePage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/posts/[slug]/singlePage.module.css) | Code in singlePage.module.css styles blog post display for user experience in FullStackLifeBlog Frontend. It controls layout, fonts, images, and responsiveness, enhancing readability and visual appeal.            |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/posts/[slug]/page.jsx)                           | Code snippet: `UserAuthenticationService.java`Summary: Manages user authentication features for frontend and backend integration. Authenticated user access control ensured across the FullStackLifeBlog repository. |

</details>

<details closed><summary>Frontend.src.app.write</summary>

| File                                                                                                                          | Summary                                                                                                                                                                                                                                             |
| ---                                                                                                                           | ---                                                                                                                                                                                                                                                 |
| [writePage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/write/writePage.module.css) | Code Snippet Summary:**In `writePage.module.css`, styles for a fluid, responsive write page are defined. Features dynamic inputs, image upload, and a styled publish button enhancing UX/UI in FullStackLifeBlog's Frontend architecture.           |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/write/page.jsx)                         | Summary: `WritePage.jsx` facilitates writing and publishing blog posts with image compression, Cloudinary integration, and post submission handling. It enforces user authentication before content creation in the FullStackLifeBlog architecture. |

</details>

<details closed><summary>Frontend.src.app.blog</summary>

| File                                                                                                                       | Summary                                                                                                                                                                                                                                |
| ---                                                                                                                        | ---                                                                                                                                                                                                                                    |
| [blogPage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/blog/blogPage.module.css) | Code Summary:**The code snippet in `Frontend/src/app/blog/blogPage.module.css` styles a blog page layout with responsive design, ensuring readability and visual appeal on various devices.                                            |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/blog/page.jsx)                       | Code in **Frontend/src/app/blog/page.jsx** organizes blog page elements with **CategoryList**, **CardList**, and **Menu** components. It contributes to a user-friendly blog interface in the parent **FullStackLifeBlog** repository. |

</details>

<details closed><summary>Frontend.src.app.utils</summary>

| File                                                                                                                          | Summary                                                                                                                                                                                                                                       |
| ---                                                                                                                           | ---                                                                                                                                                                                                                                           |
| [backendConnection.js](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/utils/backendConnection.js) | Code snippet in Frontend/src/app/utils/backendConnection.js sends authenticated requests to the backend using JWT tokens, handling various HTTP methods. This critical function enhances data exchange in the FullStackLifeBlog architecture. |
| [math.js](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/utils/math.js)                           | Code Summary:** `math.js` generates random shapes for post pages, posts, and logos in the Frontend of the `FullStackLifeBlog` repository. Enhances visual variety and appeal dynamically.                                                     |

</details>

<details closed><summary>Frontend.src.app.oauth2callback</summary>

| File                                                                                                           | Summary                                                                                                                                                                                                |
| ---                                                                                                            | ---                                                                                                                                                                                                    |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/oauth2callback/page.jsx) | Code snippet `page.jsx` in `Frontend/src/app/oauth2callback` imports and exports `OAuth2CallbackPage` component from `oAuth2CallbackPage` folder. It plays a crucial role in user authentication flow. |

</details>

<details closed><summary>Frontend.src.app.components.cardList</summary>

| File                                                                                                                                      | Summary                                                                                                                                                                                                         |
| ---                                                                                                                                       | ---                                                                                                                                                                                                             |
| [CardList.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/cardList/CardList.jsx)               | CardList component handles dynamic fetching of posts with pagination. It integrates client-side logic for displaying recent posts with navigation controls. Supports async data retrieval and loading states.** |
| [cardList.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/cardList/cardList.module.css) | Code snippet in cardList.module.css defines styling for card list component in FullStackLifeBlog frontend, ensuring proper layout, spacing, and button appearance for a cohesive user interface.                |

</details>

<details closed><summary>Frontend.src.app.components.footer</summary>

| File                                                                                                                                | Summary                                                                                                                                                                                                         |
| ---                                                                                                                                 | ---                                                                                                                                                                                                             |
| [Footer.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/footer/Footer.jsx)               | Summary: Footer.jsx renders the FullstackLife blog footer with dynamic theme styles, social media icons, and navigation links. It enhances the frontend UI/UX of the blog site.                                 |
| [footer.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/footer/footer.module.css) | Code snippet in `Footer.module.css` styles the footer's layout, logo, social icons, and links in the FullStackLifeBlog Frontend. It enhances the visual presentation and user experience of the blog's website. |

</details>

<details closed><summary>Frontend.src.app.components.icons</summary>

| File                                                                                                                       | Summary                                                                                                                                                                                   |
| ---                                                                                                                        | ---                                                                                                                                                                                       |
| [SendIcon.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/icons/SendIcon.jsx)   | Code Summary:**`SendIcon.jsx` in **Frontend** generates an SVG send icon with customizable fill, width, and height, enhancing UI components in the blog application.                      |
| [HeartIcon.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/icons/HeartIcon.jsx) | Role:** Frontend UI Component **Description:** Renders a customizable heart icon in SVG format based on provided parameters, enhancing user interface aesthetics in the blog application. |

</details>

<details closed><summary>Frontend.src.app.components.navbar</summary>

| File                                                                                                                                | Summary                                                                                                                                                                                     |
| ---                                                                                                                                 | ---                                                                                                                                                                                         |
| [navbar.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/navbar/navbar.module.css) | Code snippet in `navbar.module.css` controls styling of the navigation bar in the Frontend module. It ensures a responsive design by adjusting layout and font sizes based on screen width. |
| [NavBar.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/navbar/NavBar.jsx)               | Summary:**`NavBar.jsx` in `Frontend` displays social links, logo, theme toggle, and navigation. Integrates theme context for styling consistency.                                           |

</details>

<details closed><summary>Frontend.src.app.components.categoryList</summary>

| File                                                                                                                                                  | Summary                                                                                                                                                                                                                                  |
| ---                                                                                                                                                   | ---                                                                                                                                                                                                                                      |
| [categoryList.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/categoryList/categoryList.module.css) | Code snippet in categoryList.module.css styles categoryList component in FullStackLifeBlog Frontend. It defines layout for category items with responsive design, aligning items and setting background colors for different categories. |
| [CategoryList.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/categoryList/CategoryList.jsx)               | Code Summary**: `CategoryList.jsx` component in `FullStackLifeBlog` retrieves and displays blog categories with interactive styling, enhancing user navigation.                                                                          |

</details>

<details closed><summary>Frontend.src.app.components.featuredSlider</summary>

| File                                                                                                                                                        | Summary                                                                                                                                                                                                                          |
| ---                                                                                                                                                         | ---                                                                                                                                                                                                                              |
| [FeaturedSlider.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featuredSlider/FeaturedSlider.jsx)               | Code Summary:**`FeaturedSlider.jsx` manages a slider for featured content in the Frontend of the FullStackLifeBlog repository. It enables auto-scrolling and dynamic resizing of the slider container. Swipe effect to be added. |
| [featuredSlider.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featuredSlider/featuredSlider.module.css) | Code Summary:**In **Frontend**, **featuredSlider** module CSS defines styling for a responsive slider with navigation arrows. It ensures content visibility and interactivity within the blog platform UI.                       |

</details>

<details closed><summary>Frontend.src.app.components.menu</summary>

| File                                                                                                                          | Summary                                                                                                                                                                                    |
| ---                                                                                                                           | ---                                                                                                                                                                                        |
| [Menu.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/menu/Menu.jsx)               | Code Summary:**In `Menu.jsx`, a React component displays trending posts. It structures and renders popular content using `MenuPost` components within a styled layout.                     |
| [menu.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/menu/menu.module.css) | Code snippet summary:** Defines styling for menu container, titles, and items layout in the Frontend's menu component module CSS, enhancing the visual representation and user experience. |

</details>

<details closed><summary>Frontend.src.app.components.menuPost</summary>

| File                                                                                                                                      | Summary                                                                                                                                                                      |
| ---                                                                                                                                       | ---                                                                                                                                                                          |
| [menuPost.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/menuPost/menuPost.module.css) | Code snippet in menuPost.module.css styles blog post components for Frontend. Defines layout and styling rules ensuring consistent visual presentation and user experience.  |
| [MenuPost.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/menuPost/MenuPost.jsx)               | Menu Post Component** in Frontend repository displays a styled post item featuring an image, category, title, author, and date, enhancing user experience and visual appeal. |

</details>

<details closed><summary>Frontend.src.app.components.pagination</summary>

| File                                                                                                                                            | Summary                                                                                                                                                                                        |
| ---                                                                                                                                             | ---                                                                                                                                                                                            |
| [pagination.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/pagination/pagination.module.css) | Code snippet in `pagination.module.css` styles pagination component in Frontend, defining layout and button styling. Enhances UI for improved navigation.                                      |
| [Pagination.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/pagination/Pagination.jsx)               | Pagination Component in Frontend/src/app/components**Manages pagination UI for blog posts. Uses CSS modules for styling. Supports navigating between pages. Key role in Frontend architecture. |

</details>

<details closed><summary>Frontend.src.app.components.markdown</summary>

| File                                                                                                                                                    | Summary                                                                                                                                                                                                                |
| ---                                                                                                                                                     | ---                                                                                                                                                                                                                    |
| [MarkdownPreview.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/markdown/MarkdownPreview.jsx)               | Summary:**`MarkdownPreview.jsx` renders Markdown content with syntax highlighting based on the theme. It utilizes React's `useState` and `useEffect` hooks while importing plugins for customizing Markdown rendering. |
| [MarkdownEditor.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/markdown/MarkdownEditor.jsx)                 | Code in MarkdownEditor.jsx dynamically loads a Markdown editor component using React. Depends on ThemeContext for theming. Handles state for editor content.                                                           |
| [markdownPreview.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/markdown/markdownPreview.module.css) | Code in Frontend/src/app/components/markdown/markdownPreview.module.css controls styling for markdown preview, aligning with FullStackLifeBlog repository's frontend architecture.                                     |

</details>

<details closed><summary>Frontend.src.app.components.featured</summary>

| File                                                                                                                                      | Summary                                                                                                                                                                                                       |
| ---                                                                                                                                       | ---                                                                                                                                                                                                           |
| [Featured.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featured/Featured.jsx)               | Summary:**In `Featured.jsx`, fetches posts via API for FullStackLife blog's featured slider. Handles loading & error states, displaying posts for knowledge sharing.                                          |
| [featured.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featured/featured.module.css) | Code in Frontend/src/app/components/featured/featured.module.css styles the featured section, ensuring visual consistency and responsiveness. Critical for maintaining UI standards across the blog platform. |

</details>

<details closed><summary>Frontend.src.app.components.comments</summary>

| File                                                                                                                                      | Summary                                                                                                                                                                                                                                                        |
| ---                                                                                                                                       | ---                                                                                                                                                                                                                                                            |
| [Comments.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/comments/Comments.jsx)               | Summary: `Comments.jsx` manages user comments, submits to the server, displays in reverse order. Requires authentication for posting, shows comment details. Supports dynamic comment creation and viewing.                                                    |
| [comments.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/comments/comments.module.css) | Code snippet in `Frontend/src/app/components/comments/comments.module.css` styles the comments section UI components in the Frontend of the FullStackLifeBlog repository. It defines the layout, colors, and interactions for comments display and input form. |

</details>

<details closed><summary>Frontend.src.app.components.comment</summary>

| File                                                                                                                                   | Summary                                                                                                                                                                                                          |
| ---                                                                                                                                    | ---                                                                                                                                                                                                              |
| [Comment.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/comment/Comment.jsx)               | Summary:Comment component displays user comments with like functionality. It renders user details, date, text, and likes. Utilizes Next.js Image and HeartIcon for UI enhancements.                              |
| [comment.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/comment/comment.module.css) | Code Summary:** Comment styling module for FullStackLifeBlog frontend. Defines layout for user comments, user profile images, likes display. Enhances visual appeal and user engagement with dynamic components. |

</details>

<details closed><summary>Frontend.src.app.components.featuredSlide</summary>

| File                                                                                                                                                     | Summary                                                                                                                                                                                                                      |
| ---                                                                                                                                                      | ---                                                                                                                                                                                                                          |
| [FeaturedSlide.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featuredSlide/FeaturedSlide.jsx)               | FeaturedSlide Component**: Renders a slide with image, title, user info, and creation date. Clickable to view post details. Enhances Frontend UI for FullStackLifeBlog.                                                      |
| [featuredSlide.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/featuredSlide/featuredSlide.module.css) | Code Summary:** Styles the featured slide container in the frontend app, enhancing user experience by applying visually appealing design elements like text and image alignment, shadows, and responsive layout adjustments. |

</details>

<details closed><summary>Frontend.src.app.components.oAuth2CallbackPage</summary>

| File                                                                                                                                                            | Summary                                                                                                                                                                                                  |
| ---                                                                                                                                                             | ---                                                                                                                                                                                                      |
| [OAuth2CallbackPage.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/oAuth2CallbackPage/OAuth2CallbackPage.jsx)       | Code Summary:**In the **Frontend** repository, the **OAuth2CallbackPage** component handles successful OAuth2 authentication by obtaining a JWT token from the server and redirecting users accordingly. |
| [oAuth2Callback.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/oAuth2CallbackPage/oAuth2Callback.module.css) | Code in oAuth2Callback.module.css aligns and styles content on oAuth2 callback page in the Frontend module. It centers elements and adjusts layout based on screen size, enhancing user experience.      |

</details>

<details closed><summary>Frontend.src.app.components.authLinks</summary>

| File                                                                                                                                         | Summary                                                                                                                                                                                                                                 |
| ---                                                                                                                                          | ---                                                                                                                                                                                                                                     |
| [AuthLinks.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/authLinks/AuthLinks.jsx)               | Code Summary:** `AuthLinks` component toggles user authentication state, providing login, write post, and logout links. Utilizes context API for theming and user authentication. Supports responsive menu handling.                    |
| [authLinks.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/authLinks/authLinks.module.css) | Code snippet in `authLinks.module.css` manages styling for responsive menu & authentication links in frontend. Controls menu display based on screen width. Key for UI consistency & user experience in FullStackLifeBlog architecture. |

</details>

<details closed><summary>Frontend.src.app.components.card</summary>

| File                                                                                                                          | Summary                                                                                                                                                                                                                   |
| ---                                                                                                                           | ---                                                                                                                                                                                                                       |
| [Card.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/card/Card.jsx)               | Role:** Frontend component for displaying blog post cards.**Features:** Dynamically renders post information with image, date, category, title, description, and Read more link. Integrates with Next.js and CSS modules. |
| [card.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/card/card.module.css) | Code in `card.module.css` organizes card components for blog posts. Visual elements structured with flexbox, responsiveness considered. Layout emphasizes image and text clarity.                                         |

</details>

<details closed><summary>Frontend.src.app.components.themeToggle</summary>

| File                                                                                                                                               | Summary                                                                                                                                                                                   |
| ---                                                                                                                                                | ---                                                                                                                                                                                       |
| [ThemeToggle.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/themeToggle/ThemeToggle.jsx)               | Code Summary:****Role:** `ThemeToggle` component in `Frontend` handles theme switching for user interface.**Key Features:** Toggles between light and dark themes with visual indicators. |
| [themeToggle.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/components/themeToggle/themeToggle.module.css) | Code Summary:**`themeToggle.module.css` styles a theme toggle button for the Frontend UI, with a clickable container and a toggle switch for changing themes.                             |

</details>

<details closed><summary>Frontend.src.app.context</summary>

| File                                                                                                                    | Summary                                                                                                                                                                                                       |
| ---                                                                                                                     | ---                                                                                                                                                                                                           |
| [AuthContext.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/context/AuthContext.jsx)   | Code Summary:** `AuthContext.jsx` manages user authentication state in the frontend, including login, logout, and token refresh functionality using React context API. Improves user experience and security. |
| [ThemeContext.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/context/ThemeContext.jsx) | Code Summary:**Manages theme selection with local storage synchronization. Toggle light/dark modes. Supports React app appearance preferences. Enhances user experience in FullStackLifeBlog frontend.        |

</details>

<details closed><summary>Frontend.src.app.login</summary>

| File                                                                                                                          | Summary                                                                                                                                                                                                         |
| ---                                                                                                                           | ---                                                                                                                                                                                                             |
| [loginPage.module.css](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/login/loginPage.module.css) | Summary: `loginPage.module.css` in Frontend's `src/app` manages styling for a login form, optimizing layout and responsiveness to enhance user experience within the FullStackLifeBlog repository architecture. |
| [page.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/login/page.jsx)                         | Summary:**The Login page component enables users to authenticate using email-password or social media accounts. It interacts with the backend API for authentication and navigates users upon successful login. |

</details>

<details closed><summary>Frontend.src.app.providers</summary>

| File                                                                                                                        | Summary                                                                                                                                                                |
| ---                                                                                                                         | ---                                                                                                                                                                    |
| [ThemeProvider.jsx](https://github.com/IvanSan2/FullStackLifeBlog/blob/master/Frontend/src/app/providers/ThemeProvider.jsx) | Summary:** ThemeProvider component in Frontend/src/app/providers folder manages theme context for child components in the FullStackLifeBlog repository's architecture. |

</details>

---

## 🚀 Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `openjdk:21`

## ⚙️ Installation

### 1. Clone the FullStackLifeBlog repository:

```sh
git clone https://github.com/IvanSan2/FullStackLifeBlog
```

### 2. Create the `application.properties` File:
   
In the `Backend\src\main\resources` directory, you need to create application.properties file and add your configuration settings

```properties
# Datasource.url is the url of the database
# after the ? is the parameter to create the database if it does not exist
spring.datasource.url=jdbc:mysql://localhost:3306/blogfinalprojectdb?createDatabaseIfNotExist=true


spring.datasource.username=<DATABASE_USERNAME>
spring.datasource.password=<DATABASE_PASSWORD>


#show sql in the log (optional)
# spring.jpa.show-sql=true

# Hibernate ddl auto (create, create-drop, update)
# update: update the schema if entity is changed, else do nothing
spring.jpa.hibernate.ddl-auto=update

# set username and password for Spring Security:


# set the secret key for JWT (JSON Web Token)
rsa.private-key=classpath:certs/private.pem
# set the public key for JWT
rsa.public-key=classpath:certs/pub.pem

springdoc.swagger-ui.path=/swagger

# Google OAuth2
spring.security.oauth2.client.registration.google.client-id=<GOOGLE_OAUTH_ID>
spring.security.oauth2.client.registration.google.client-secret=<GOOGLE_OAUTH_SECRET>

# Github OAuth2
spring.security.oauth2.client.registration.github.client-id=<GITHUB_OAUTH_ID>
spring.security.oauth2.client.registration.github.client-secret=<GITHUB_OAUTH_SECRET>
# request email from user
spring.security.oauth2.client.registration.github.scope=user:email

# logging
logging.level.org.springframework.security=TRACE

# password for oauth2 client
oauth2.fixed-password=<FIXED_PASSWORD>
```

### 3. To generate a certificate and the corresponding keys for JWT (JSON Web Tokens), you can use the `openssl` tool. This process involves generating a private key, deriving the public key from the private key, and then creating the key pair.


### 3.1. Generate a Private Key (`private.pem`)

Open a terminal and run the following command to generate a private key:

```sh
openssl genpkey -algorithm RSA -out private.pem -pkeyopt rsa_keygen_bits:2048
```

This command generates a 2048-bit RSA private key and saves it to `private.pem`.

### 3.2. Extract the Public Key (`pub.pem`)

Next, derive the public key from the private key and save it to `pub.pem`:

```sh
openssl rsa -pubout -in private.pem -out pub.pem
```

This command reads the private key from `private.pem` and extracts the public key, saving it to `pub.pem`.

### 3.3. Combine Private and Public Keys into a Key Pair (`keypair.pem`)


```sh
cat private.pem pub.pem > keypair.pem
```

### Verifying the Keys

To ensure that the keys are generated correctly, you can use the following commands to display the contents of the keys:

- Display the private key:

  ```sh
  openssl pkey -in private.pem -text -noout
  ```

- Display the public key:

  ```sh
  openssl pkey -in pub.pem -pubin -text -noout
  ```

### 3.4. Add Keys to the directory

- Add all generated keys  (`private.pem`, `pub.pem`, `keypair.pem`) to the `Backend\src\main\resources\certs` folder



## 🤖 Running FullStackLifeBlog

### Use the following command to run FullStackLifeBlog Backend:

### 1. Navigate to the Project Directory:
```sh
cd .\Backend\
```

### 2. Build the Project:
```sh
mvn clean install
```

### 3. Run the Application:
```sh
mvn spring-boot:run
```

* Ensure that you have Java and Maven installed and properly configured in your system's PATH.

___

### Use the following command to run FullStackLifeBlog Frontend:

```bash
yarn dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.





