package pro04_test;

public class Member {
	private String userId;
	private String userPw;
	private String userPw_2;
	private String userName;
	private String userBirth;
	private String usernum;
	private String userEmail;
	private String userAdress;
	public String getUserId() {		return userId;	}
	public void setUserId(String userId) {	this.userId = userId;	}
	
	public String getUserPw() {	return userPw;	}
	public void setUserPw(String userPw) {	this.userPw = userPw;   }
	
	public String getUserPw_2() {	return userPw_2;	}
	public void setUserPw_2(String userPw_2) {	this.userPw_2 = userPw_2;	}
	
	public String getUserName() {	return userName;	}
	public void setUserName(String userName) {	this.userName = userName;	}
	
	public String getUserBirth() {	return userBirth;	}
	public void setUserBirth(String userBirth) {	this.userBirth = userBirth;   	}
	
	public String getUsernum() {	return usernum;	}
	public void setUsernum(String usernum) {	this.usernum = usernum;	}
	
	public String getUserEmail() {	return userEmail;	}
	public void setUserEmail(String userEmail) {	this.userEmail = userEmail;	}
	
	public String getUserAdress() {	return userAdress;	}
	public void setUserAdress(String userAdress) {	this.userAdress = userAdress;	}
	
	public String toString() {
		return "User[userId=" + userId + ", userPw=" + userPw + ", userPw_2=" +userPw_2 + 
				", userName=" +userName + ", userBirth= " + userBirth + ", usernum= " + usernum + 
	            ", userEmail=" +userEmail +", userAdress=" + userAdress + "]";
	}
	
}




