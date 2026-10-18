package com.ContactService.ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	// Test valid contact creation
	@Test
	void testContactClass() {
		Contact newContact = new Contact(
				"1001",
				"James",
				"Smith",
				"6618886118",
				"123 Fake St. Encino, CA 91158"
		);

		assertEquals("James", newContact.getFirstName());
		assertEquals("Smith", newContact.getLastName());
		assertEquals("1001", newContact.getId());
		assertEquals("6618886118", newContact.getPhone());
		assertEquals("123 Fake St. Encino, CA 91158", newContact.getAddress());
	}

	// ---------------- ID TESTS ----------------

	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10000000000",
					"James",
					"Smith",
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					null,
					"James",
					"Smith",
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	// Enhancement: blank IDs should not be accepted
	@Test
	void testContactClassIdBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"   ",
					"James",
					"Smith",
					"6618886118",
					"123 Fake St."
			);
		});
	}

	// ---------------- FIRST NAME TESTS ----------------

	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James123456",
					"Smith",
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					null,
					"Smith",
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	// Enhancement: blank first names should not be accepted
	@Test
	void testContactClassFirstNameBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"   ",
					"Smith",
					"6618886118",
					"123 Fake St."
			);
		});
	}

	// ---------------- LAST NAME TESTS ----------------

	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith123456",
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					null,
					"6618886118",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	// Enhancement: blank last names should not be accepted
	@Test
	void testContactClassLastNameBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"   ",
					"6618886118",
					"123 Fake St."
			);
		});
	}

	// ---------------- PHONE TESTS ----------------

	@Test
	void testContactClassPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					"661888611",
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	@Test
	void testContactClassPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					null,
					"123 Fake St. Encino, CA 91158"
			);
		});
	}

	// Enhancement: phone must contain exactly 10 numeric digits
	@Test
	void testContactClassPhoneNonNumeric() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					"abcdefghij",
					"123 Fake St."
			);
		});
	}

	// ---------------- ADDRESS TESTS ----------------

	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					"6618886118",
					"123 Fake St. Encino, CA 91158 123456"
			);
		});
	}

	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					"6618886118",
					null
			);
		});
	}

	// Enhancement: blank addresses should not be accepted
	@Test
	void testContactClassAddressBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"10001",
					"James",
					"Smith",
					"6618886118",
					"   "
			);
		});
	}

	// ---------------- FIRST NAME SETTER TESTS ----------------

	@Test
	void testContactClassSetFirstName() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		newContact.setFirstName("Jonesy");

		assertEquals("Jonesy", newContact.getFirstName());
	}

	@Test
	void testContactClassSetFirstNameTooLong() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("JonesyTooLong");
		});
	}

	@Test
	void testContactClassSetFirstNameNull() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}

	// Enhancement: setter uses strengthened validation
	@Test
	void testContactClassSetFirstNameBlank() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("   ");
		});
	}

	// ---------------- LAST NAME SETTER TESTS ----------------

	@Test
	void testContactClassSetLastName() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		newContact.setLastName("Jonesy");

		assertEquals("Jonesy", newContact.getLastName());
	}

	@Test
	void testContactClassSetLastNameTooLong() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("JonesyTooLong");
		});
	}

	@Test
	void testContactClassSetLastNameNull() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}

	// ---------------- PHONE SETTER TESTS ----------------

	@Test
	void testContactClassSetPhone() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		newContact.setPhone("6618886119");

		assertEquals("6618886119", newContact.getPhone());
	}

	@Test
	void testContactClassSetPhoneTooLong() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("66188861199999999");
		});
	}

	@Test
	void testContactClassSetPhoneNull() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}

	@Test
	void testContactClassSetPhoneTooShort() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("44444");
		});
	}

	// Enhancement: 10 characters is not enough; they must be digits
	@Test
	void testContactClassSetPhoneNonNumeric() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("abcdefghij");
		});
	}

	// ---------------- ADDRESS SETTER TESTS ----------------

	@Test
	void testContactClassSetAddress() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		newContact.setAddress("new address 2");

		assertEquals("new address 2", newContact.getAddress());
	}

	@Test
	void testContactClassSetAddressTooLong() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("new address too long 1324566874685");
		});
	}

	@Test
	void testContactClassSetAddressNull() {
		Contact newContact =
				new Contact("845", "Jack", "Jones", "6618886118", "new address");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
}