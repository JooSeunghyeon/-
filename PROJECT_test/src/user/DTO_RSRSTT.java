package user;

public class DTO_RSRSTT {

	private String date;				//���೯¥
	private String time;				//����ð�
	private int member_id;				//ȸ����ȣ *
	private int booking_number;			//�����ȣ
	private int check_number;			//������ȣ *
	
	
	public DTO_RSRSTT(String date, String time, int member_id, int booking_number, int check_number) {
		this.date = date;
		this.time = time;
		this.member_id = member_id;
		this.booking_number = booking_number;
		this.check_number = check_number;
	}


	public DTO_RSRSTT(String date, String time, int member_id, int booking_number) {
		
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

	public int getCheck_number() {
		return check_number;
	}

	public void setCheck_number(int check_number) {
		this.check_number = check_number;
	}
	

	
}
