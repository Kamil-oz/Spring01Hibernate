package pl.coderslab.model;


public class PersonDTO {
	private String[] country;
	private String[] programmingSkills;
	private String[] hobbies;
	private String login;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String notes;
	private boolean mailingList;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isMailingList() {
		return mailingList;
	}
	public void setMailingList(boolean mailingList) {
		this.mailingList = mailingList;
	}
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	public String[] getProgrammingSkills() {
		return programmingSkills;
	}
	public void setProgrammingSkills(String[] programmingSkills) {
		this.programmingSkills = programmingSkills;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
