package com.lawyer.models;

import com.lawyer.support.Magic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Class.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.SEVEN)
    @Column(name = "id")
    @Getter @Setter
    private String id;

    @NotNull
    @Size(min = Magic.TRHEE, max = Magic.TEN)
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @NotNull
    @Size(min = Magic.TRHEE, max = Magic.TEN)
    @Column(name = "name")
    @Getter @Setter
    private String name;

    @NotNull
    @Size(min = Magic.TRHEE, max = Magic.TEN)
    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @NotNull
    @Size(min = Magic.TEN, max = Magic.TEN)
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    @Column(name = "birth_date")
    @Getter @Setter
    private String birthDate;

    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.THIRTY)
    @Pattern(regexp = "^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")
    @Column(name = "email")
    @Getter @Setter
    private String email;

    @NotNull
    @Size(min = Magic.FIVE, max = Magic.SIX)
    @Pattern(regexp = "(admin|seller|client)")
    @Column(name = "type")
    @Getter @Setter
    private String type;

    /**
     * Constructor.
     */
    public User() {
    }
}