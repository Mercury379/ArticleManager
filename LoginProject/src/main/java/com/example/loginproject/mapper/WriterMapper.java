package com.example.loginproject.mapper;

import com.example.loginproject.entity.User;
import com.example.loginproject.entity.Writer;

import java.util.List;

public interface WriterMapper {
    List<Writer> getWriterList(String w_name);
    void addWriter(Writer writer);
    void deleteWriter(int id);
    Writer getWriterById(int id);
    void updateWriter(Writer writer);
}
