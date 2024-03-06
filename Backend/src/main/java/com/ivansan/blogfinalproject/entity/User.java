package com.ivansan.blogfinalproject.entity;

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
        // unique constraint for the email and username
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

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;



}
