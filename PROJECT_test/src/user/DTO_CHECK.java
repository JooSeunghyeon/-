package user;

public class DTO_CHECK {
	
	private int check_number;			//검진번호
	private String check_name;			//검진이름
	private int cost;					//비용
	private String script;				//추가설명
	
	public DTO_CHECK(int check_number, String check_name, int cost, String script) {
		this.check_number = check_number;
		this.check_name = check_name;
		this.cost = cost;
		this.script = script;
	}

	public int getCheck_number() {
		return check_number;
	}

	public void setCheck_number(int check_number) {
		this.check_number = check_number;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
	
	
	
	
}	
	