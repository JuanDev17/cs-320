
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import Test.Contact; - Was part of the Junit Test creation but shows error

class ContactTest {
	
	// test for working contact creation
	@Test
	void testContactCalss() {
		Contact newContact = new Contact("1001", "James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		assertTrue(newContact.getFirstName().equals("James"));
		assertTrue(newContact.getLastName().equals("Smith"));
		assertTrue(newContact.getId().equals("1001"));
		assertTrue(newContact.getPhone().equals("6618886118"));
		assertTrue(newContact.getAddress().equals("123 Fake St. Encino, CA 91158"));
	}
	// test for too long ID
	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10000000000", "James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		});
	}
	// test for null ID
	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "James", "Smith", "6618886118", 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for too long first name
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James123456", "Smith", "6618886118", 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for null first name
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", null, "Smith", "6618886118",
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for too long last name
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", "Smith123456", "6618886118", 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for null last name
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", null, "6618886118", 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for not exactly 10 characters
	@Test
	void testContactClassPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", "Smith", "661888611", 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for null phone
	@Test
	void testContactCalssPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", "Smith", null, 
					"123 Fake St. Encino, CA 91158");
		});
	}
	// test for too long address
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", "Smith", "6618886118", 
					"123 Fake St. Encino, CA 91158 123456");
		});
	}
	// test for null address
	@Test
	void testContactClassAddressnull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "James", "Smith", "6618886118", 
					null);
		});
	}
	// test fName setter method
	@Test
	void testContactClassSetFirstName() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		newContact.setFirstName("Jonesy");
		assertTrue(newContact.getFirstName().equals("Jonesy"));
	}
	@Test
	void testContactClassSetFirstNameTooLong() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("JonesyTooLong");
		});
	}
	@Test
	void testContactClassSetFirstNameNull() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	// test lName setter method
	@Test
	void testContactClassSetLastName() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		newContact.setLastName("Jonesy");
		assertTrue(newContact.getLastName().equals("Jonesy"));
	}
	@Test
	void testContactClassSetLastNameTooLong() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("JonesyTooLong");
		});
	}
	@Test
	void testContactClassSetLastNameNull() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	// test phone setter method
	@Test
	void testContactClassSetPhone() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		newContact.setPhone("6618886119");
		assertTrue(newContact.getPhone().equals("6618886119"));
	}
	@Test
	void testContactClassSetPhoneTooLong() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("66188861199999999");
		});
	}
	@Test
	void testContactClassSetPhoneNull() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}
	@Test
	void testContactClassSetPhoneTooShort() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("44444");
		});
	}
	// test address setter method
	@Test
	void testContactClassSetAddress() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		newContact.setAddress("new address 2");
		assertTrue(newContact.getAddress().equals("new address 2"));
	}
	@Test
	void testContactClassSetAddressTooLong() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("new address too long 1324566874685");
		});
	}
	@Test
	void testContactClassSetAddressNull() {
		Contact newContact = new Contact("845", "Jack", "Jones", "6618886118", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	

}