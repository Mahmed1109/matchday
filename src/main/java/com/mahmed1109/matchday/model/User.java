package com.mahmed1109.matchday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;

}
