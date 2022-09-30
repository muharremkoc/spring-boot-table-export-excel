package com.export.excel.controller;

import com.export.excel.dto.UserRequestDto;
import com.export.excel.enums.SocialMedia;
//import com.export.excel.exporter.UserExcelExporter;
import com.export.excel.exporter.UserExcelExporter;
import com.export.excel.model.User;
import com.export.excel.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.codecs.jsr310.LocalDateCodec;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/export")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @PostMapping("/save")
    public User create(@RequestParam SocialMedia socialMedia, @RequestBody UserRequestDto userRequestDto){
        return userService.saveUser(userRequestDto,socialMedia);
    }


    @GetMapping("/list")
    public List<User> list(){
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
         userService.deleteUser(id);
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException{

        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachment; filename="+getFormattedDate()+"_User_Info.xlsx";

        response.setHeader(headerKey,headerValue);
        List<User> userList=userService.getUsers();
        UserExcelExporter exporter=new UserExcelExporter(userList);
        exporter.export(response);
    }
    private String getFormattedDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date());
    }


}
