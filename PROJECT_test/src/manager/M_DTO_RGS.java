package manager;

public class M_DTO_RGS {
	
	private String date;				//���೯¥
	private String time;				//����ð�
	private int member_id;				//ȸ����ȣ *
	private int booking_number;			//�����ȣ
	
	
	public M_DTO_RGS(String date, String time, int member_id, int booking_number) {
		this.date = date;
		this.time = time;
		this.member_id = member_id;
		this.booking_number = booking_number;
	}


	public int getMember_id() {
		return member_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getBooking_number() {
		return booking_number;
	}

	public void setBooking_number(int booking_number) {
		this.booking_number = booking_number;
	}

	
	
	

}
