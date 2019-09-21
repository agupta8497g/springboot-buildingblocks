package com.abhishek.restservices.springbootbuildingblocks.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String city;
}
