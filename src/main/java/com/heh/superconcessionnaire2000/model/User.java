package com.heh.superconcessionnaire2000.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@RequiredArgsConstructor
public class User
{
    @Getter
    private final Integer userId;

    @Getter
    private final String firstname;

    @Getter
    private final String lastname;

    @Getter
    private final LocalDate birthdate;

    @Setter
    @Getter
    private boolean admin;

    public Integer getAge()
    {
        LocalDate today = LocalDate.now();
        return today.getYear() - this.getBirthdate().getYear();
    }

    public void OP()
    {
        this.admin = true;
    }

    public void deOP()
    {
        this.admin = false;
    }
}



