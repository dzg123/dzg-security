package com.dzg.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: dzg-security
 * @description: FileInfo
 * @author: dzg
 * @create: 2019-02-05 14:21
 **/
public class FileInfo {
    private @Getter
    @Setter
    String path;

    public FileInfo(String path) {
        this.path = path;

    }
}
