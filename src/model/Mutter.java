package model;

import java.io.Serializable;

public class Mutter implements Serializable {

	private int id;
	private String userName;
	private String text;

	public Mutter (){}
	public Mutter (String user,String text) {
		this.userName=user;
		this.text=text;
	}

	public String GetName() {
		return this.userName;
	}
	public String GetText() {
		return this.text;
	}
}
