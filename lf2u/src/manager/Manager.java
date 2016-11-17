package manager;

public class Manager {
	String name;
	String created_by = "Super User";
	String create_date = "20161116";
	String phone = "123-0987-659";
	String email = "johnny.smith@example.com";
	int id = 79;
	
	public Manager(){
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCreateDate(){
		return this.create_date;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String email(){
		return this.email;
	}
	
	public int getID(){
		return this.id;
	}
}
