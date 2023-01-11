package com.heh.superconcessionnaire2000.adapter.out.ContractAdapter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "contracts")
public class ContractJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractid", nullable = false)
    private Integer contractid;

    @Column(name = "carid", nullable = false)
    private Integer carid;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "firstname", length = 20)
    private String firstname;

    @Column(name = "lastname", length = 20)
    private String lastname;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "carstring", nullable = false)
    private String carstring;

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer id) {
        this.contractid = id;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCarstring() {
        return carstring;
    }

    public void setCarstring(String carstring) {
        this.carstring = carstring;
    }
}