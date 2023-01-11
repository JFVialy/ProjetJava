package com.heh.superconcessionnaire2000.adapter.out;

import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.out.UserManagerOut;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserAdapter implements UserManagerOut
{
    @Override
    public Map<String, String> getConnectedUserInfo()
    {
        Map<String, String> userInfo = new HashMap<String, String>();
        if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)
        {
            return null;
        }
        else
        {
            KeycloakAuthenticationToken auth = (KeycloakAuthenticationToken) SecurityContextHolder.
                    getContext().
                    getAuthentication();
            Principal principal = (Principal) auth.getPrincipal();

            if (principal instanceof KeycloakPrincipal) {
                KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
                Set<String> roles = kPrincipal.getKeycloakSecurityContext().getToken().getResourceAccess("sc2000").getRoles();
                IDToken idToken = kPrincipal.getKeycloakSecurityContext().getIdToken();
                userInfo.put("userId", principal.toString());
                userInfo.put("firstname", idToken.getGivenName());
                userInfo.put("lastname", idToken.getFamilyName());
                userInfo.put("email", idToken.getEmail());
                userInfo.put("username", idToken.getPreferredUsername());
                userInfo.put("mainrole", roles.toArray()[0].toString());
            }
            return userInfo;
        }
    }
}
