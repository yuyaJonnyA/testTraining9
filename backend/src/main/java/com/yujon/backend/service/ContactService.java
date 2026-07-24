package com.yujon.backend.service;

import com.yujon.backend.dto.ContactRequest;
import com.yujon.backend.model.ContactMessage;
import com.yujon.backend.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContactService {

    private final ContactMessageRepository repository;

    public ContactService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ContactMessage save(ContactRequest request) {
        ContactMessage message = new ContactMessage();
        message.setName(request.getName());
        message.setEmail(request.getEmail());
        message.setMessage(request.getMessage());
        return repository.save(message);
    }

    public List<ContactMessage> findAll() {
        return repository.findAll();
    }
}
