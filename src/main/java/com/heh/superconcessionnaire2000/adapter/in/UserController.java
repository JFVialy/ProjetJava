package com.heh.superconcessionnaire2000.adapter.in;

import com.heh.superconcessionnaire2000.KeycloakSecurity;
import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.IDToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Set;

@Controller
@Scope("session")
public class UserController {

    @Autowired
    private UserManagerIn userManagerIn;
    private User user;
    private Boolean admin;

    @GetMapping("userinfo")
    public String userinfo(Model model, HttpSession session)
    {
        user = userManagerIn.getConnectedUser();
        model.addAttribute("user", user);
        return "userInfo";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "disconnected";
    }
}
