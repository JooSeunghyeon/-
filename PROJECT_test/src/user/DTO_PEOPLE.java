package user;

public class DTO_PEOPLE {
	
	private int member_id;
	private String member_name;
	private int age;
	private String gender;
	private String tel;
	private String pass;

	public DTO_PEOPLE(int member_id, String member_name, int age, String gender, String tel, String pass) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.pass = pass;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
