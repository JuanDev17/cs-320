package com.ContactService.ContactService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    // Constructor injection
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> createContact(
            @RequestBody ContactRequest request) {

        contactService.addContact(
                request.firstName(),
                request.lastName(),
                request.phone(),
                request.address()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Contact created successfully");
    }

    // DTO for incoming JSON
    public record ContactRequest(
            String firstName,
            String lastName,
            String phone,
            String address
    ) {}


    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {

        Contact contact = contactService.getContactById(id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(
            @PathVariable String id,
            @RequestBody ContactRequest request) {

        if (!contactService.searchContact(id)) {
            return ResponseEntity.notFound().build();
        }

        contactService.updateFirstName(id, request.firstName());
        contactService.updateLastName(id, request.lastName());
        contactService.updatePhoneNum(id, request.phone());
        contactService.updateAddress(id, request.address());

        return ResponseEntity.ok("Contact updated successfully");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable String id) {

        if (!contactService.searchContact(id)) {
            return ResponseEntity.notFound().build();
        }

        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

}