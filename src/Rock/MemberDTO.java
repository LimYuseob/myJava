package Rock;

//0111 1819


public class MemberDTO{
	
	private String ID;
	private String PW;
	private String email;

	public MemberDTO() {
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getID() {
		return this.email.substring(0,this.email.indexOf('@'));
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
