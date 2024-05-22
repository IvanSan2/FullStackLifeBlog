package com.ivansan.blogfinalproject.entity;

import com.ivansan.blogfinalproject.enums.AuthProvider;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(uniqueConstraints = {
        // unique constraint for the email
        @UniqueConstraint(name = "UQ_USER_EMAIL",columnNames = {"email"}),
        @UniqueConstraint(name = "UQ_USER_USERNAME",columnNames = {"username"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;

    private String image;

    // @Enumerated is used to specify the type of the enum
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    // FetchType.EAGER is used to load the roles of the user when the user is loaded
    // FetchType.LAZY is used to load the roles of the user when the roles are accessed
    @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable is used to specify the name of the join table and the column names
    // Honestly, I don't know why we need to specify the name of the join table and the column names
    // just for showing that we can do it
    // if we don't specify the name of the join table and the column names, Hibernate will create the join table and the column names for us
    // and the names will be the same
    @JoinTable(
            // name of the join table
            name = "user_roles",
            // name of the column in the join table that references the user
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            // name of the column in the join table that references the role
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_comments",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id")
    )
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Post> posts;


}


