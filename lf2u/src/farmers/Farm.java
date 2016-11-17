package farmers;

import java.util.List;
import java.util.ArrayList;

public class Farm {
	private String name;
	private String address;
	private String phone;
	private String web = "no website";
	private String [] dzip;  //delivery zip codes
	private List<Farm> farmList = new ArrayList<Farm>();
	
	public Farm(String n, String a, String p, String [] dz){
		this.name = n;
		this.address = a;
		this.phone = p;
		this.dzip = dz;
	}
	
	public Farm(String n, String a, String p, String w, String [] dz){
		this.name = n;
		this.address = a;
		this.phone = p;
		this.web = w;
		this.dzip = dz;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String [] getDZip(){
		return this.dzip;
	}
	
	public String getWebsite(){
		return this.web;
	}
	
	public List<Farm> getFarmList(){
		List<Farm> newList = farmList;
		return newList;
	}
}