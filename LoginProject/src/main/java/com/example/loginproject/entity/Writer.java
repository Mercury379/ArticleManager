package com.example.loginproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Writer {
    private int w_id;
    private Date w_date;
    private String w_name;
    private String w_provice;
    private String w_city;
    private String w_address;
    private String w_code;
}
