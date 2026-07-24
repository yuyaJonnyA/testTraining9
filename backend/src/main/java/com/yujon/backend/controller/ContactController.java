package com.yujon.backend.controller;

import com.yujon.backend.dto.ContactRequest;
import com.yujon.backend.dto.ContactResponse;
import com.yujon.backend.model.ContactMessage;
import com.yujon.backend.service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> submitContact(@Valid @RequestBody ContactRequest request) {
        log.info("Received contact form from {} <{}>", request.getName(), request.getEmail());
        ContactMessage saved = contactService.save(request);
        ContactResponse response = toResponse(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactResponse>> getMessages() {
        List<ContactResponse> messages = contactService.findAll().stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(messages);
    }

    private ContactResponse toResponse(ContactMessage message) {
        return new ContactResponse(
                message.getId(),
                message.getName(),
                message.getEmail(),
                message.getMessage(),
                message.getCreatedAt()
        );
    }
}
