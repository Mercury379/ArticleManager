package com.example.loginproject.service;

import com.example.loginproject.entity.Writer;

import java.util.List;

public interface WriterService {
    public List<Writer> getWriterList(String w_name);
    public void deleteWriter(int id);
    public void addWriterInfo(Writer writer);
    public Writer getWriterById(int id);
    public void updateWriter(Writer writer);
}
