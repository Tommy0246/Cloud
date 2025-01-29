package com.example.rag.controller;

import com.example.rag.domain.Document;
import com.example.rag.service.DocumentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DocumentController {

    private final DocumentService documentService;
    Log log = LogFactory.getLog(DocumentController.class);
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        log.debug("REST request to get all Documents");
        return documentService.findAll();
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        Document result = documentService.BuildAndSave(document);
        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }
}
