package com.ContactService.ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactServiceTest {

	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactRepository contactRepository;

	// Clear database before each test
	@BeforeEach
	void setUp() {
		contactRepository.deleteAll();
	}

	// Test adding a contact to the database
	@Test
	void testContactServiceClass() {
		Contact contact = new Contact(
				"1001",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St. Encino, CA 91158"
		);

		contactService.addContact(contact);

		Contact storedContact = contactRepository
				.findById("1001")
				.orElse(null);

		assertNotNull(storedContact);
		assertEquals("1001", storedContact.getId());
		assertEquals("James", storedContact.getFirstName());
		assertEquals("Smith", storedContact.getLastName());
		assertEquals("6618886118", storedContact.getPhone());
		assertEquals(
				"123 Fake St. Encino, CA 91158",
				storedContact.getAddress()
		);
	}

	// Confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		Contact contact = new Contact(
				"1002",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St."
		);

		contactService.addContact(contact);
		contactService.deleteContact("1002");

		assertFalse(contactService.searchContact("1002"));
	}

	// Test updating first name
	@Test
	void testContactServiceUpdateFirstName() {
		Contact contact = new Contact(
				"1003",
				"Jack",
				"Jones",
				"6618886118",
				"Halloween Ave."
		);

		contactService.addContact(contact);
		contactService.updateFirstName("1003", "Mary");

		Contact updatedContact = contactRepository
				.findById("1003")
				.orElse(null);

		assertNotNull(updatedContact);
		assertEquals(
				"Mary",
				updatedContact.getFirstName()
		);
	}

	// Test updating last name
	@Test
	void testContactServiceUpdateLastName() {
		Contact contact = new Contact(
				"1004",
				"Mary",
				"Jones",
				"6618886118",
				"Halloween Ave."
		);

		contactService.addContact(contact);
		contactService.updateLastName("1004", "Poppins");

		Contact updatedContact = contactRepository
				.findById("1004")
				.orElse(null);

		assertNotNull(updatedContact);
		assertEquals(
				"Poppins",
				updatedContact.getLastName()
		);
	}

	// Test updating phone number
	@Test
	void testContactServiceUpdatePhone() {
		Contact contact = new Contact(
				"1005",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St."
		);

		contactService.addContact(contact);
		contactService.updatePhoneNum(
				"1005",
				"8884446161"
		);

		Contact updatedContact = contactRepository
				.findById("1005")
				.orElse(null);

		assertNotNull(updatedContact);
		assertEquals(
				"8884446161",
				updatedContact.getPhone()
		);
	}

	// Test updating address
	@Test
	void testContactServiceUpdateAddress() {
		Contact contact = new Contact(
				"1006",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St."
		);

		contactService.addContact(contact);
		contactService.updateAddress(
				"1006",
				"456 Fake St. Acton, CA"
		);

		Contact updatedContact = contactRepository
				.findById("1006")
				.orElse(null);

		assertNotNull(updatedContact);
		assertEquals(
				"456 Fake St. Acton, CA",
				updatedContact.getAddress()
		);
	}

	// Test duplicate IDs
	@Test
	void testContactServiceUniqueId() {
		Contact original = new Contact(
				"49594",
				"Smith",
				"Smithson",
				"6618886118",
				"Original Contact Address"
		);

		contactService.addContact(original);

		Contact duplicate = new Contact(
				"49594",
				"Smith",
				"Smithson",
				"6618886118",
				"Duplicate Contact Address"
		);

		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> contactService.addContact(duplicate)
		);
	}
}