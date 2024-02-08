package com.quillquest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ImageService {

    public static byte[] converttoBlob(MultipartFile image) throws IOException {
        try {
            byte[] imageByte = image.getBytes();
            return imageByte;
        } catch (IOException e) {
            throw new IOException("Error while converting image to byte array");
        }
    }


}
