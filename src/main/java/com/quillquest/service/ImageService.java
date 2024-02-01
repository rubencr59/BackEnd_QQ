package com.quillquest.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageService {

    public static byte[] convertBase64(String image) {
        String base64Image = image;

        byte[] decodedImage = Base64.getDecoder().decode(base64Image);


        return decodedImage;
    }
}
