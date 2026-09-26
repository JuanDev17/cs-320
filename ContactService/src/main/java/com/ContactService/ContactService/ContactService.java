import java.util.HashMap;

public class ContactService {
	
	// needed variables for creating objects of Contact class
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhone;
	public String publicAddress;
	
	// create a structure to store data of contacts
	//static ArrayList<Contact> contactList = new ArrayList<Contact>(0);

	// HashMap takes 2 types
	// HashMap is an object
	static HashMap<String, Contact> contactHashMap = new HashMap<>();
	private static int nextId = 100000002;
	
	// generate unique Id
	public static String generateUniqueId() {
		// placeholder string
		return Integer.toString(nextId++);
	}
	
	// creation of a Contact object and adding it to the arraylist
	public static void addContact(String fName, String lName, String phone, String address) {
		String ID = generateUniqueId();
		Contact Contact1 = new Contact(ID, fName, lName, phone, address);

		addContact(Contact1);
	}

	// add a contact as a whole manually for testing 
	public static void addContact(Contact newContact) {
		String tempId = newContact.getId();

			// new method checking for duplicate IDs
			if (contactIdExists(tempId)){
				throw new IllegalArgumentException("Contact ID already exists.");
			}

		//contactList.add(newContact);
		contactHashMap.put(tempId, newContact);
	}
	
	// updater methods for fields that can be updated
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		Contact contact = contactHashMap.get(uniqueId);

		if(contact == null) return;

		contact.setFirstName(publicFirstName);
	}
	public static void updateLastName(String uniqueId, String publicLastName) {
		Contact contact = contactHashMap.get(uniqueId);

		if(contact == null) return;

		contact.setLastName(publicLastName);
	}
	public static void updatePhoneNum(String uniqueId, String publicPhone) {
		Contact contact = contactHashMap.get(uniqueId);

		if(contact == null) return;

		contact.setPhone(publicPhone);
	}
	public static void updateAddress(String uniqueId, String publicAddress) {
		Contact contact = contactHashMap.get(uniqueId);

		if(contact == null) return;

		contact.setAddress(publicAddress);
	}
	// delete a contact from the list
	public static void deleteContact(String uniqueId) {
		contactHashMap.remove(uniqueId);
	}
	// quick search function for testing
	public static boolean searchContact(String uniqueId) {
		return contactHashMap.containsKey(uniqueId);
	}

	// remove findIndex() method, hashMap doesn't need index

	// method for checking for duplicates -
	public static boolean contactIdExists(String contactId) {
		// compare each id,
		// containsKey checking if the specific key exists within the collection
		return contactHashMap.containsKey(contactId);
		}


}