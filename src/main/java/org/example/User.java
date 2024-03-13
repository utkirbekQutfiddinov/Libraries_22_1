package org.example;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@ToString(of = {"lastName","firstName"}, includeFieldNames = false)
public class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Integer blood;
    private Integer age;
    private Double balance;
    private String accountNumber;
    private String username;
    private String password;
    private Boolean isActive;

}
