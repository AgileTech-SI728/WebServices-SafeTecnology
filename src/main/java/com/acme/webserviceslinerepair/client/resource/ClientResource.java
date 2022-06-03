package com.acme.webserviceslinerepair.client.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResource {
    private Long id;
    private String names;
    private String lastNames;
    private String address;
    private String email;
    private String password;
    private String cellPhoneNumber;
    private String planType;
}
