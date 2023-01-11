package com.heh.superconcessionnaire2000.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
public class Contract
{
    @Getter
    private final Integer contractId;

    @Getter
    private final Integer carId;

    @Getter
    private final String username;

    @Getter
    private final String firstname;

    @Getter
    private final String lastname;

    @Getter
    private final Timestamp date;

    @Getter
    private final String carString;
}
