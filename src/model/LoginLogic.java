package model;


public class LoginLogic {

	public boolean excute(model.User u) {
		if(u.GetPass().equals("1234")){
			return true;
		}
		return false;
	}
}
