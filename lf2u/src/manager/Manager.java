package manager;

public class Manager {
	String name;
	String created_by = "Super User";
	String create_date = "20161116";
	String phone = "123-0987-659";
	String email = "johnny.smith@example.com";
	int id;
	static int sid = 1;
	
	public Manager(){
		id = sid;
		sid++;
	}
	
	public Manager(String n, String cb, String cd, String p, String e){
		this.name = n;
		this.created_by = cb;
		this.create_date = cd;
		this.phone = p;
		this.email = e;
		id = sid;
		sid++;
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