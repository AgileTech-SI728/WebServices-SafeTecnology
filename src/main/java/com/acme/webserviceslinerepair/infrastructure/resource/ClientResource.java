package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.FullName;
import lombok.*;


@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ClientResource {
    private Long id;
    private FullName fullName;
    private String address;
    private String email;
    private String password;
    private String cellPhoneNumber;
    private String planType;
}
