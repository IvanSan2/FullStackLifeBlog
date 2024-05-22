package com.ivansan.blogfinalproject.config;

import com.ivansan.blogfinalproject.entity.Role;
import com.ivansan.blogfinalproject.entity.User;
import com.ivansan.blogfinalproject.enums.AuthProvider;
import com.ivansan.blogfinalproject.repository.RoleRepository;
import com.ivansan.blogfinalproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Set;

@Configuration
@RequiredArgsConstructor
// CommandLineRunner is an interface that is used to run code after the application context is loaded
// CommandLineRunner is used to run code after the application context is loaded
public class SQLRunner implements CommandLineRunner {


    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    // Transactional is used to specify that the method is a transactional method
    // that means that the method will be executed in a transaction and if the method fails, the transaction will be rolled back
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            var adminRole = roleRepository.save(new Role(1L, "ROLE_ADMIN"));
            var userRole = roleRepository.save(new Role(2L, "ROLE_USER"));

            userRepository.save(
                    new User(
                            1L,
                            "admin@domain.com",
                            "Admin",
                            passwordEncoder.encode("Admin123@"),
                            null,
                            AuthProvider.LOCAL,
                            null,
                            Set.of(adminRole,userRole),
                            null,
                            null

                    )
            );

            userRepository.save(
                    new User(
                            2L,
                            "user@Domain.com",
                            "User",
                            passwordEncoder.encode("User123@"),
                            null,
                            AuthProvider.LOCAL,
                            null,
                            Set.of(userRole),
                            null,
                            null
                    )
            );
        }



    }
}
