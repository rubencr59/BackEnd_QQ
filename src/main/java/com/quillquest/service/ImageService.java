package com.quillquest.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageService {

    public static byte[] converttoBlob(String image) {
        String base64Image = image;

        byte[] decodedImage = Base64.getDecoder().decode(base64Image);


        return decodedImage;
    }

    public static String convertToBase64(byte[] image) {
        String base64Image = Base64.getEncoder().encodeToString(image);

        return base64Image;
    }
}
