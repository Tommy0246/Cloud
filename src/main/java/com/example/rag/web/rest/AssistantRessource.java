package com.example.rag.web.rest;

import com.example.rag.service.AssistantAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantRessource {
    private final AssistantAIService assistantAiService;

    public AssistantRessource(AssistantAIService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantAiService.chat(query);
    }
}
