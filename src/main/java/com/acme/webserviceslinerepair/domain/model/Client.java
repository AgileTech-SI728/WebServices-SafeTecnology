package com.acme.webserviceslinerepair.domain.model;

import com.acme.webserviceslinerepair.domain.values.FullName;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "clients", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private FullName fullName;

    @NotNull
    @NotBlank
    @Size(max=100)
    private String address;

    @NotNull
    @NotBlank
    @Size(max=100)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=5,max=100)
    private String password;

    @NotNull
    @NotBlank
    @Size(max=9)
    private String cellPhoneNumber;

    @NotNull
    @NotBlank
    @Size(max=20)
    private String planType;
}
