package user;

public class DTO_RESULT {

	private int member_id;
	private String gohyulap, biman, am, dangnyo, chunsik, gankyungha;
	
	public DTO_RESULT(int member_id, String gohyulap, String biman, String am, String dangnyo, String chunsik,
			String gankyungha) {
		this.member_id = member_id;
		this.gohyulap = gohyulap;
		this.biman = biman;
		this.am = am;
		this.dangnyo = dangnyo;
		this.chunsik = chunsik;
		this.gankyungha = gankyungha;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getGohyulap() {
		return gohyulap;
	}

	public void setGohyulap(String gohyulap) {
		this.gohyulap = gohyulap;
	}

	public String getBiman() {
		return biman;
	}

	public void setBiman(String biman) {
		this.biman = biman;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getDangnyo() {
		return dangnyo;
	}

	public void setDangnyo(String dangnyo) {
		this.dangnyo = dangnyo;
	}

	public String getChunsik() {
		return chunsik;
	}

	public void setChunsik(String chunsik) {
		this.chunsik = chunsik;
	}

	public String getGankyungha() {
		return gankyungha;
	}

	public void setGankyungha(String gankyungha) {
		this.gankyungha = gankyungha;
	}

	
	
	
	
	
}
