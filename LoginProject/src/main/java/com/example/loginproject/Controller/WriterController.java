package com.example.loginproject.Controller;

import com.example.loginproject.entity.User;
import com.example.loginproject.entity.Writer;
import com.example.loginproject.service.UserService;
import com.example.loginproject.service.WriterService;
import com.example.loginproject.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class WriterController {
    @Autowired
    private WriterService writerService;

    @GetMapping("/getWriterList")
    @ResponseBody
    public ResponseData getWriterList(@RequestParam String searchName) {
        ResponseData responseData;
        List<Writer> writerList;
        if(searchName.equals("")){
            writerList=writerService.getWriterList("");
        }else {
            writerList=writerService.getWriterList(searchName);
        }
        if(!writerList.isEmpty()){
            responseData = new ResponseData(200,"查找作者列表成功");
            responseData.putDataValue("writerList",writerList);
        }else{
            responseData = new ResponseData(401,"系统内无对应作者！");
        }
        return responseData;
    }
    @PostMapping("/deleteWriterById")
    @ResponseBody
    public ResponseData deleteWriter(@RequestBody Map<String, String> deleteInfo) {
        ResponseData responseData;
        writerService.deleteWriter(Integer.parseInt(deleteInfo.get("id")));
        List<Writer> writerList=writerService.getWriterList("");
        if(!writerList.isEmpty()){
            responseData = new ResponseData(200,"查找作者列表成功");
            responseData.putDataValue("writerList",writerList);
        }else{
            responseData = new ResponseData(401,"系统内无作者！");
        }
        return responseData;
    }
    @PostMapping("/addWriterInfo")
    @ResponseBody
    public ResponseData addWriter(@RequestBody Map<String, String> writerInfo) {
        ResponseData responseData;
        Writer writer=new Writer();
        writer.setW_name(writerInfo.get("w_name"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(writerInfo.get("w_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        writer.setW_date(date);
        writer.setW_provice(writerInfo.get("w_provice"));
        writer.setW_city(writerInfo.get("w_city"));
        writer.setW_address(writerInfo.get("w_address"));
        writer.setW_code(writerInfo.get("w_code"));
        writerService.addWriterInfo(writer);
        responseData=new ResponseData(200,"添加成功！");
        return responseData;
    }
    @PostMapping("/getWriterById")
    @ResponseBody
    public ResponseData getWriterInfo(@RequestBody Map<String, String> writerInfo) {
        ResponseData responseData=new ResponseData(200,"查找作者信息成功");
        Writer writer=writerService.getWriterById(Integer.parseInt(writerInfo.get("id")));
        responseData.putDataValue("writerInfo",writer);
        return responseData;
    }
    @PostMapping("/updateWriter")
    @ResponseBody
    public ResponseData updateWriter(@RequestBody Map<String, String> writerInfo) {
        ResponseData responseData;
        Writer writer=new Writer();
        writer.setW_id(Integer.parseInt(writerInfo.get("w_id")));
        writer.setW_name(writerInfo.get("w_name"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(writerInfo.get("w_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        writer.setW_date(date);
        writer.setW_provice(writerInfo.get("w_provice"));
        writer.setW_city(writerInfo.get("w_city"));
        writer.setW_address(writerInfo.get("w_address"));
        writer.setW_code(writerInfo.get("w_code"));
        writerService.updateWriter(writer);
        responseData=new ResponseData(200,"添加成功！");
        return responseData;
    }
}
