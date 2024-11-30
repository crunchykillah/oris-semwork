package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private Long visitorId;
    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private List<Exhibition> exhibitions;
    public Visitor(Long visitorId, String name, String email,String username,String password,String phoneNumber) {
        this.visitorId = visitorId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}