package com.zzf.gpt.zzfgptpro.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    @Resource
    private OpenAiChatModel openAiChatModel;

    @RequestMapping(value = "/ai/chat")
    public String chat(@RequestParam(value = "msg") String msg){
        String called = openAiChatModel.call(msg);
        return called;
    }

    @RequestMapping(value = "/ai/chat2")
    public Object chat2(@RequestParam(value = "msg") String msg){
        ChatResponse callResponse = openAiChatModel.call(new Prompt(msg));
        return callResponse.getResult().getOutput().getContent();
    }

    @RequestMapping(value = "/ai/chat3")
    public Object chat3(@RequestParam(value = "msg") String msg){
        ChatResponse callResponse = openAiChatModel.call(new Prompt(msg, OpenAiChatOptions.builder()
//                .withModel("gpt-4-turbo")
                .withTemperature(0.4f)
                .build()));
        return callResponse.getResult().getOutput().getContent();
    }

    @RequestMapping(value = "/ai/chat4")
    public Object chat4(@RequestParam(value = "msg") String msg){
        Flux<ChatResponse> flux = openAiChatModel.stream(new Prompt(msg));
        flux.toStream().forEach(chatResponse -> {
            System.out.println(chatResponse.getResult().getOutput().getContent());
        });
        return flux.collectList();
    }
}
