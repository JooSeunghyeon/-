package user;

public class DTO_DISEASE {

	int disease_number;			//질병번호
	String disease_name;		//질병이름

	public DTO_DISEASE(int disease_number, String disease_name) {
		this.disease_number = disease_number;
		this.disease_name = disease_name;
	}

	public int getDisease_number() {
		return disease_number;
	}

	public void setDisease_number(int disease_number) {
		this.disease_number = disease_number;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}
}
