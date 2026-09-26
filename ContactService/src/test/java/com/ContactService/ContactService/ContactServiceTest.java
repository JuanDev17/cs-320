import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@BeforeEach
	void setUp() {
		ContactService.contactHashMap.clear();
	}

	// Test adding a contact to the HashMap
	@Test
	void testContactServiceClass() {
		Contact contact = new Contact(
				"1001",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St. Encino, CA 91158"
		);

		ContactService.addContact(contact);

		Contact storedContact = ContactService.contactHashMap.get("1001");

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

		ContactService.addContact(contact);
		ContactService.deleteContact("1002");

		assertFalse(ContactService.searchContact("1002"));
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

		ContactService.addContact(contact);
		ContactService.updateFirstName("1003", "Mary");

		assertEquals(
				"Mary",
				ContactService.contactHashMap.get("1003").getFirstName()
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

		ContactService.addContact(contact);
		ContactService.updateLastName("1004", "Poppins");

		assertEquals(
				"Poppins",
				ContactService.contactHashMap.get("1004").getLastName()
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

		ContactService.addContact(contact);
		ContactService.updatePhoneNum("1005", "8884446161");

		assertEquals(
				"8884446161",
				ContactService.contactHashMap.get("1005").getPhone()
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

		ContactService.addContact(contact);
		ContactService.updateAddress(
				"1006",
				"456 Fake St. Acton, CA"
		);

		assertEquals(
				"456 Fake St. Acton, CA",
				ContactService.contactHashMap.get("1006").getAddress()
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

		ContactService.addContact(original);

		Contact duplicate = new Contact(
				"49594",
				"Smith",
				"Smithson",
				"6618886118",
				"Duplicate Contact Address"
		);

		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> ContactService.addContact(duplicate)
		);
	}
}