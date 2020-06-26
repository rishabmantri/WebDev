package model;

public class PhoneEntry {
    private String firstname;

    public PhoneEntry(String phone) {
        this.phone = phone;
    }

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public PhoneEntry(String phone, String name, String lname )
    {
	this.firstname  = name;
	this.lastname  = lname;
	this.phone = phone;
    }

    public void changeName(String newfname, String newlname) {
    	firstname = newfname;
    	// This is here to introduce artifical latency for testing purposes
    	try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	lastname  = newlname;
    }
    public String toString()
    { return firstname + "\n" + lastname + "\n" + phone; }
}



