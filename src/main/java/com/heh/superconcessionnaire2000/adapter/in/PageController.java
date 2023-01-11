package com.heh.superconcessionnaire2000.adapter.in;

import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class PageController
{
    @Autowired
    private UserManagerIn userManagerIn;
    private User user;

    public PageController(UserManagerIn userManagerIn, User user) {
        this.userManagerIn = userManagerIn;
        this.user = user;
    }

    @GetMapping("/home")
    public String goHome(HttpSession session)
    {
        if(userManagerIn.getConnectedUser() != null)
        {
            user = userManagerIn.getConnectedUser();
            if(Objects.equals(user.getRole(), "admin"))
            {
                session.setAttribute("admin", true);
            }
        }
        return "home";
    }

    @GetMapping("/")
    public RedirectView goHome2(HttpSession session)
    {
        if(userManagerIn.getConnectedUser() != null)
        {
            user = userManagerIn.getConnectedUser();
            if(Objects.equals(user.getRole(), "admin"))
            {
                session.setAttribute("admin", true);
            }
        }
        return new RedirectView("home");
    }


}


