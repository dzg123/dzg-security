package com.dzg.web.controller;


import com.dzg.dto.FileInfo;
import jdk.internal.util.xml.impl.Input;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @program: dzg-security
 * @description: 文件控制类
 * @author: dzg
 * @create: 2019-02-05 14:15
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    private String folder = "D:\\localrepository\\git\\dzg-security\\dzg-security-demo\\src\\main\\resources\\static";

    @PostMapping
    public FileInfo upload(MultipartFile file) {
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        log.info(String.valueOf(file.getSize()));
        File localFile = new File(folder, new Date().getTime() + ".txt");
        try {
            file.transferTo(localFile);
            return new FileInfo(localFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream ips = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream ops = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(ips, ops);
            ops.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
