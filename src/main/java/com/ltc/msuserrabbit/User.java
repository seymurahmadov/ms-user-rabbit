package com.ltc.msuserrabbit;

import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L; // Add a serialVersionUID for serialization

    private String username;
    private String email;
}