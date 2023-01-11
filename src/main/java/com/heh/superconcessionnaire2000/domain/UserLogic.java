package com.heh.superconcessionnaire2000.domain;

import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import com.heh.superconcessionnaire2000.port.out.UserManagerOut;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class UserLogic implements UserManagerIn
{
    public UserManagerOut userManagerOut;
    public Map<String, String> userInfo;
    public Boolean admin = false;

    public UserLogic(UserManagerOut userManagerOut)
    {
        this.userManagerOut = userManagerOut;
    }

    @Override
    public User getConnectedUser() {
        userInfo = userManagerOut.getConnectedUserInfo();
        if(userInfo == null)
        {
            return null;
        }
        else
        {
            return new User(userInfo.get("userId"),
                    userInfo.get("firstname"),
                    userInfo.get("lastname"),
                    userInfo.get("email"),
                    userInfo.get("username"),
                    userInfo.get("mainrole"));
        }
    }
}
