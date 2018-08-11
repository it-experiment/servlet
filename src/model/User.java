package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name,password;

	public User() {	}
	public void SetName(String name){
		this.name=name;
	}
	public String GetName(){
		return this.name;
	}
	public void SetPass(String password){
		this.password=password;
	}
	public String GetPass(){
		return this.password;
	}

}
