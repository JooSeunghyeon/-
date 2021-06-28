package user;

public class DTO_GUIDE {

	private String check_name;			//검진이름
	private String script;				//추가설명
	
	public DTO_GUIDE(String check_name, String script) {
		this.check_name = check_name;
		this.script = script;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
}
