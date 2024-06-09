import styles from './about.module.css';

export default function Page() {
    return (
        <div className={styles.container} >
        <h1>About</h1>
        <div className={styles.textWrapper}>
        <p>The FullStackLifeBlog project is a fully-functional blogging platform that integrates frontend and backend components seamlessly. Users can authenticate securely, create, update, retrieve, and delete blog posts and comments via RESTful APIs. The backend, built on Spring Boot, ensures secure management of user credentials and authorizations to maintain data integrity and privacy. Docker is leveraged for easy deployment and scaling of the application, enabling quick setup and additional service integration. The project's value lies in its robust feature set, providing a solid foundation for a dynamic blogging experience.</p>
        </div>
        </div>
    );
    }