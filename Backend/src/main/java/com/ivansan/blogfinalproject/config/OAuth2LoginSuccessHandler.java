package com.ivansan.blogfinalproject.config;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

//    private final OAuth2Service;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("OAuth2 login success");
        logger.info(STR."Authentication: \{authentication}");
        if (authentication instanceof OAuth2AuthenticationToken) {
            logger.info("OAuth2AuthenticationToken");
            // save the authentication in the session
            request.getSession().setAttribute("oauth2Authentication", authentication);

            // redirect to the success page with the token in the URL
            String redirectUri = "https://fullstack-life-blog-frontend-latest.onrender.com/oauth2callback";
            response.sendRedirect(redirectUri);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
