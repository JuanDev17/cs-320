public class Contact {
	// needed variables for the class
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	
	// how to create an object of the class
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// checking ID against requirements
		validateContactId(contactId);

		// checking first name against requirements
		validateFirstName(firstName);

		// checking last name against requirements
		validateLastName(lastName);

		// checking phone against requirements
		validatePhone(phone);

		// checking address against requirements
		validateAddress(address);

		// handling assuming no exceptions
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getter methods
	public String getId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	// setter methods for use by ContactService
	// no set methods for the contactId because it should not be updated
	public void setFirstName(String fName) {
		validateFirstName(fName);
		this.firstName = fName;
	}
	public void setLastName(String lName) {
		validateLastName(lName);
		this.lastName = lName;
	}
	public void setPhone(String newPhone) {
		validatePhone(newPhone);
		this.phone = newPhone;
	}

	public void setAddress(String newAddress) {
		validateAddress(newAddress);
		this.address = newAddress;
	}

	// HELPER METHODS -
	private static void validatePhone(String phoneNumber){
		if(phoneNumber == null || !phoneNumber.matches("\\d{10}")){
			throw new IllegalArgumentException("Phone number is invalid");
		}
	}

	private static void validateFirstName(String firstName){
		if (firstName == null || firstName.isBlank() || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}

	private static void validateLastName(String lastName){
		if (lastName == null || lastName.isBlank() || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}

	private static void validateContactId(String contactId){
		if(contactId == null || contactId.isBlank() || contactId.length() > 10 ){
			throw new IllegalArgumentException("Invalid Contact Id");
		}
	}

	private static void validateAddress(String address){
		if (address == null || address.isBlank() || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}


	}


}