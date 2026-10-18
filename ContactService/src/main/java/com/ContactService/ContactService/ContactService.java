package com.ContactService.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	// introducing our DB repo,
	private ContactRepository contactRepository;

	// constructor injection
	public ContactService(ContactRepository contactRepository){
		this.contactRepository = contactRepository;
	}
	private  int nextId = 100000002;
	
	// generate unique Id
	public  String generateUniqueId() {
		// placeholder string
		return Integer.toString(nextId++);

		while(contactRepository.existsById(id)){
			id = Integer.toString(nextId++)
		}

		return id;
	}
	
	public  void addContact(String fName, String lName, String phone, String address) {
		String ID = generateUniqueId();
		Contact contact = new Contact(ID, fName, lName, phone, address);

		addContact(contact);
	}

	// add a contact as a whole manually for testing 
	public  void addContact(Contact newContact) {
		String tempId = newContact.getId();

			// new method checking for duplicate IDs
			if (contactIdExists(tempId)){
				throw new IllegalArgumentException("Contact ID already exists.");
			}

		//contactList.add(newContact);
		contactRepository.save(newContact);
	}
	
	// updater methods for fields that can be updated
	public  void updateFirstName(String uniqueId, String publicFirstName) {
		Contact contact = contactRepository.findById(uniqueId).orElse(null);

		if(contact == null) return;

		contact.setFirstName(publicFirstName);
		contactRepository.save(contact);
	}
	public  void updateLastName(String uniqueId, String publicLastName) {
		Contact contact = contactRepository.findById(uniqueId).orElse(null);

		if(contact == null) return;

		contact.setLastName(publicLastName);
		contactRepository.save(contact);
	}
	public  void updatePhoneNum(String uniqueId, String publicPhone) {
		Contact contact = contactRepository.findById(uniqueId).orElse(null);

		if(contact == null) return;

		contact.setPhone(publicPhone);
		contactRepository.save(contact);
	}
	public  void updateAddress(String uniqueId, String publicAddress) {
		Contact contact = contactRepository.findById(uniqueId).orElse(null);

		if(contact == null) return;

		contact.setAddress(publicAddress);
		contactRepository.save(contact);
	}
	// delete a contact from the list
	public  void deleteContact(String uniqueId) {
		contactRepository.deleteById(uniqueId);
	}
	// quick search function for testing
	public  boolean searchContact(String uniqueId) {
		return contactRepository.existsById(uniqueId);
	}

	// method for checking for duplicates -
	public  boolean contactIdExists(String contactId) {
		// existById() is the way to check with Spring Data's JPA
		return contactRepository.existsById(contactId);
		}


}