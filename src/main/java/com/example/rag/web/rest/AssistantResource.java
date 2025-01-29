package com.example.rag.web.rest;

import com.example.rag.service.AssistantAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {
    private final AssistantAIService assistantAiService;

    public AssistantResource(AssistantAIService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantAiService.chat(query);
    }
}
