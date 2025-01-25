package com.example.loginproject.service.serviceImpl;

import com.example.loginproject.entity.Writer;
import com.example.loginproject.mapper.WriterMapper;
import com.example.loginproject.service.WriterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("WriterService")
public class WriterServiceImpl implements WriterService {
    @Resource
    private WriterMapper writerMapper;

    @Override
    public List<Writer> getWriterList(String w_name) {
        return writerMapper.getWriterList(w_name);
    }

    @Override
    public void deleteWriter(int id) {
        writerMapper.deleteWriter(id);
    }
    public void addWriterInfo(Writer writer){
        List<Writer> writers=writerMapper.getWriterList("");
        int maxId=0;
        for(int i=0;i<writers.size();i++){
            if(writers.get(i).getW_id()>maxId){
                maxId=writers.get(i).getW_id();
            }
        }
        writer.setW_id(maxId+1);
        writerMapper.addWriter(writer);
    }

    @Override
    public Writer getWriterById(int id) {
        return writerMapper.getWriterById(id);
    }

    @Override
    public void updateWriter(Writer writer) {
        writerMapper.updateWriter(writer);
    }
}
