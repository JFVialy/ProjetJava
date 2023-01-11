package com.heh.superconcessionnaire2000.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class User
{
    @Getter
    private final String userId;

    @Getter
    private final String firstname;

    @Getter
    private final String lastname;

    @Getter
    private final String email;

    @Getter
    private final String username;

    @Getter
    private final String role;

    public String userToString()
    {
        return username + " (" + firstname + " " + lastname + ")";
    }
}



