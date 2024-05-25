package com.zzf.gpt.zzfgptpro.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Resource
    private OpenAiImageModel openAiImageModel;

    @RequestMapping("/ai/image")
    private Object image(@RequestParam("msg") String msg){
        ImageResponse imageResponse = openAiImageModel.call(new ImagePrompt(msg));
        System.out.println(imageResponse);
        return imageResponse.getResult().getOutput();
    }

    @RequestMapping("/ai/image2")
    private Object image2(@RequestParam("msg") String msg){
        ImageResponse imageResponse = openAiImageModel.call(new ImagePrompt(msg, OpenAiImageOptions.builder()
                .withN(1)
                .withHeight(1792)
                .withWidth(1024)
                .build()));
        System.out.println(imageResponse);
        return imageResponse.getResult().getOutput();
    }
}
