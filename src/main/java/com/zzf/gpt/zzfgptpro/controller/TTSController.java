package com.zzf.gpt.zzfgptpro.controller;

import com.zzf.gpt.zzfgptpro.util.FileUtil;
import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class TTSController {

    @Resource
    private OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @RequestMapping("/ai/tts")
    public Object tts(@RequestParam("msg") String msg) {
        byte[] call = openAiAudioSpeechModel.call(msg);
        FileUtil.save2File("D:\\GPT相关\\Gpt开发生成\\test.mp3",call);
        return "OK";
    }


}