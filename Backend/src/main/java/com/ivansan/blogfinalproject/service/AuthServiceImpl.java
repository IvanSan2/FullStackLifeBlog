package com.ivansan.blogfinalproject.service;

import com.ivansan.blogfinalproject.dto.LoginRequestDTO;
import com.ivansan.blogfinalproject.dto.LoginResponseDTO;
import com.ivansan.blogfinalproject.dto.UserRequestDTO;
import com.ivansan.blogfinalproject.dto.UserResponseDTO;
import com.ivansan.blogfinalproject.enums.AuthProvider;
import com.ivansan.blogfinalproject.error.AuthenticationException;
import com.ivansan.blogfinalproject.error.UserAlreadyExistsException;
import com.ivansan.blogfinalproject.repository.RoleRepository;
import com.ivansan.blogfinalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
// Primary is used to tell spring that this class is the primary implementation of the interface
@Primary
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final JWTService jwtService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getUserEntityOrThrow(username);

        // map our Set<Role> to a Set<spring.Role>
        var roles = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(username, user.getPassword(), roles);
    }



    @Override
    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        // check if the username or email already exists
        checkIfUsernameOrEmailExists(userRequestDTO);
        // map the UserRequestDTO to a User
        var user = com.ivansan.blogfinalproject.entity.User.builder()
                .username(userRequestDTO.getUsername())
                .password(passwordEncoder.encode(userRequestDTO.getPassword()))
                .email(userRequestDTO.getEmail())
                .image(userRequestDTO.getImage())
                .build();


        var role = roleRepository.findByNameIgnoreCase("ROLE_USER").orElseThrow();
        user.setRoles(Set.of(role));


        user.setProvider(AuthProvider.LOCAL);

        // save the user
        var savedUser = userRepository.save(user);

        // map the saved user to a UserResponseDTO
        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .image(savedUser.getImage())
                .build();

    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        var user = getUserEntityOrThrow(loginRequestDTO.username());

        if (!passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            throw new AuthenticationException("Invalid username or password.");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                loginRequestDTO.password(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .toList()
        );

        return new LoginResponseDTO(jwtService.jwtToken(authentication));
    }




    com.ivansan.blogfinalproject.entity.User getUserEntityOrThrow(String username) {
        return userRepository.findByUsernameOrEmailIgnoreCase(username, username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(STR."User \{username} not found.")
                );
    }


    private void checkIfUsernameOrEmailExists(UserRequestDTO userRequestDTO) {
        userRepository.findByEmailIgnoreCase(userRequestDTO.getEmail())
                .ifPresent(
                        u -> {
                            if (u.getUsername().equalsIgnoreCase(userRequestDTO.getEmail())) {
                                throw new UserAlreadyExistsException(userRequestDTO.getUsername(), userRequestDTO.getEmail());
                            } else {
                                throw new UserAlreadyExistsException(userRequestDTO.getUsername(), userRequestDTO.getEmail());
                            }
                        }
                );
    }
}
