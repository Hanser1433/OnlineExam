package com.onlinejudge.test002.pojo;

import lombok.Data;
import lombok.Getter;

@Data
public class Admin {
    private int id;
    @Getter
    private String username;
    @Getter
    private String password;
    private String email;

}
