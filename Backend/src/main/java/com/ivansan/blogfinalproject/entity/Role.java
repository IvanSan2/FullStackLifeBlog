package com.ivansan.blogfinalproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UQ_ROLE_NAME",columnNames = {"name"})
})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Pattern(
            regexp = "^ROLE_[A-Z]{2,20}$",
            message = "Invalid role name format. Must be in the format of ROLE_XX where X is a capital letter."
    )
    private String name; // "ROLE_USER" or "ROLE_ADMIN"

    //    @ManyToMany(mappedBy = "roles")
    //    private Set<User> users;
    //    don't need this because we are not going to use it
    //    but if we want to require a user to have a role, we can use this
}
