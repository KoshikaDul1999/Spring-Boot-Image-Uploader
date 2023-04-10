package com.example.ImgApplication;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RequestMapping("api/v1/img")
@RestController
public class ImageUploadController {
    @PostMapping("/upload")
    public void saveImage(@RequestParam("files")MultipartFile[] files){
        String uploadDir = "profileImagesFolder";
        Arrays.asList(files).stream().forEach(file->{
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            System.out.println(fileName);
            try {
                FileUploadUtil.saveFile(uploadDir,fileName,file);
            }catch (IOException ioException){

            }
        });
    }
}
