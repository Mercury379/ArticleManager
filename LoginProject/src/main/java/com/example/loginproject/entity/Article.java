package com.example.loginproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int a_id;
    private String a_name;
    private String a_writer;
    private Date a_date;
    private String a_resource;
    private String a_type;
    private String a_abstract;
    private String a_keyword;
}
