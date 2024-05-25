package com.zzf.gpt.zzfgptpro.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileSystem;

@RestController
public class TranscriptionController {
    @Resource
    private OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

    @RequestMapping("/ai/transcription")
    public Object transcription(){
        ClassPathResource classPathResource = new ClassPathResource("李荣浩 - 贝贝.ogg");
        String call = openAiAudioTranscriptionModel.call(classPathResource);
        System.out.println(call);
        return call;
    }
}
