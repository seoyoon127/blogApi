package me.leeseoyoon.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserfRequest {
    private String email;
    private String password;
}
