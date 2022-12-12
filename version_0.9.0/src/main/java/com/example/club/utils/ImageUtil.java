package com.example.club.utils;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Base64;
import java.util.Objects;
@Component
public class ImageUtil {




    public static byte[] ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        Base64.Encoder encoder = Base64.getEncoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(Objects.requireNonNull(data));
    }






}
