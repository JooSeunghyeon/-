package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPasswordField;

import manager.M_DTO_RESULT;

public class DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	DTO_PEOPLE dto_people = null;
	DTO_RSRSTT dto_rsrstt = null;
	DTO_CHECK dto_check = null;
	DTO_GUIDE dto_guide = null;
	DTO_RESULT dto_result = null;
	DTO_DISEASE disease = null;
	int cnt = 0;
	String sql = "";

// -------------------------------------------------------------------------------------------------------------------
	public void getConn() {

		String url = "jdbc:oracle:thin:@172.30.1.47:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// --------------------------------------------------------------------------------------------------------------------
	public void close() {

		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
// --------------------------------------------------------------------------------------------------------------------

	// 회원가입
	public int DAO_join(int member_id, String name, int age, String gender, String contact, String password) {

		try {
			getConn();

			sql = "insert into member values(?,?,?,?,?,?)"; // 회번번호, 이름, 나이, 성별, 연락처, 비밀번호 삽입
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, member_id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, gender);
			psmt.setString(5, contact);
			psmt.setString(6, password);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

//---------------------------------------------------------------------------------------------------------------------	

	// 회원정보 받아오기(로그인)
	public DTO_PEOPLE DAO_people(int member_id, String password) {
		try {
			getConn();

			sql = "select * from member where member_id = ? and password = ? "; // 회원번호, 비밀번호 입력받음
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, member_id);
			psmt.setString(2, password);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int r_member_id = rs.getInt(1);
				String r_member_name = rs.getString(2);
				int r_age = rs.getInt(3);
				String r_gender = rs.getString(4);
				String r_tel = rs.getString(5);
				String r_password = rs.getString(6);

				dto_people = new DTO_PEOPLE(r_member_id, r_member_name, r_age, r_gender, r_tel, r_password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return dto_people;
	}

//----------------------------------------------------------------------------------------------------------------------	

	// 예약
	public int DAO_rsr(String date, String time, int member_id) {

		try {
			getConn();

			sql = "insert into booking values (?,?,?,booking_seq.nextval)"; // 예약날짜, 예약시간, 회원번호삽입
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, date);
			psmt.setString(2, time);
			psmt.setInt(3, member_id);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

//--------------------------------------------------------------------------------------------------------------------------

	// 예약확인
	public DTO_RSRSTT DAO_rsrStt(int member_id) {

		try {
			getConn();

			sql = "select * from booking where member_id = ? "; // 회원번호를 입력받음
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, member_id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				String r_date = rs.getString(1);
				String r_time = rs.getString(2);
				int r_member_id = rs.getInt(3);
				int r_booking_number = rs.getInt(4);

				dto_rsrstt = new DTO_RSRSTT(r_date, r_time, r_member_id, r_booking_number);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return dto_rsrstt;

	}
// --------------------------------------------------------------------------------------------------------------------------

	// 예약취소
	public int DAO_rsrDel(int member_id) {

		try {
			getConn();

			sql = "delete from booking where member_id = ?"; // 회원번호를 입력받음
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, member_id);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

//---------------------------------------------------------------------------------------------------------------------------	

	// 대기번호 (관리자가 접수한 애들은 삭제한다는 가정하에)
	public int DAO_wait(String date, String time) {
		int resultcount = 0;

		try {
			getConn();

			sql = "select count(*) from booking where (rsrvt_date = ? and rsrvt_time < ?) or rsrvt_date < ? order by rsrvt_date, rsrvt_time";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, date);
			psmt.setString(2, time);
			psmt.setString(3, date);
			rs = psmt.executeQuery();

			if (rs.next()) {
				resultcount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultcount;
	}

//-------------------------------------------------------------------------------------------------------------------------------

	// 기저질환(중복가능) 체크한거에서 질병이름을 받아오고 -> 질병번호,질병이름 리턴
	public ArrayList<DTO_DISEASE> DAO_disease(String[] disease_list) {

		ArrayList<DTO_DISEASE> arr_dis = new ArrayList<DTO_DISEASE>();

		try {
			getConn();

			for (int i = 0; i < disease_list.length; i++) {
				sql = "select * from disease where disease_name =?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, disease_list[i]);
				rs = psmt.executeQuery();

				while (rs.next()) {
					int r_disease_number = rs.getInt(1);
					String r_disease_name = rs.getString(2);

					disease = new DTO_DISEASE(r_disease_number, r_disease_name);
					arr_dis.add(disease);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return arr_dis;
	}

//---------------------------------------------------------------------------------------------------------------------------

	// 질병관련정보 확인
	public ArrayList<DTO_CHECK> DAO_check(ArrayList<DTO_DISEASE> arr) {

		ArrayList<DTO_CHECK> arr_check = new ArrayList<DTO_CHECK>();

		try {
			getConn();

			String disease_number = "";
			for (int i = 0; i < arr.size() - 1; i++) {
				disease_number += arr.get(i).getDisease_number() + ",";
			}
			disease_number += arr.get(arr.size() - 1).getDisease_number();

			sql = "select b.check_number, b.check_name, b.cost, b.script from (select '000' code, disease_number from disease) a inner join(select '000' code, check_number, check_name, disease_number, cost, script from examination_items) b on a.code = b.code where a.disease_number in ((select trim(regexp_substr(b.disease_number, '[^,]+',1,level)) as temp from examination_items connect by instr(b.disease_number, ',',1,level-1) > 0)) and a.disease_number in("
					+ disease_number + ")";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int r_check_number = rs.getInt(1);
				String r_check_name = rs.getString(2);
				int r_cost = rs.getInt(3);
				String r_script = rs.getString(4);

				dto_check = new DTO_CHECK(r_check_number, r_check_name, r_cost, r_script);
				arr_check.add(dto_check);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return arr_check;
	}

//-------------------------------------------------------------------------------------------------------------------------	

	// 검진결과데이터 보기
	public ArrayList<DTO_RESULT> DAO_RESULT_VIEW(int member_id) {

		ArrayList<DTO_RESULT> arr_result = new ArrayList<DTO_RESULT>();

		try {
			getConn();

			sql = "select * from result where member_id = ?"; // 회원번호 받아옴
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, member_id);

			rs = psmt.executeQuery();

			if (rs.next()) {

				int r_member_id = rs.getInt(1);
				String r_gohyulap = rs.getString(2);
				String r_biman = rs.getString(3);
				String r_am = rs.getString(4);
				String r_dangnyo = rs.getString(5);
				String r_chunsik = rs.getString(6);
				String r_gankyungha = rs.getString(7);

				dto_result = new DTO_RESULT(r_member_id, r_gohyulap, r_biman, r_am, r_dangnyo, r_chunsik, r_gankyungha);
				arr_result.add(dto_result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return arr_result;
	}
//--------------------------------------------------------------------------------------------------------------------------

	// 검진 기초항목 확인
	public ArrayList<DTO_CHECK> DAO_base() {
		ArrayList<DTO_CHECK> base = new ArrayList<DTO_CHECK>();

		try {
			getConn();

			sql = "select * from examination_items where check_number < 21";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				int r_check_num = rs.getInt(1);
				String r_check_name = rs.getString(2);
				int r_cost = rs.getInt(3);
				String r_script = rs.getString(4);

				dto_check = new DTO_CHECK(r_check_num, r_check_name, r_cost, r_script);
				base.add(dto_check);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return base;
	}

//----------------------------------------------------------------------------------------------------------------

	// 검진 추가항목 확인
	public ArrayList<DTO_CHECK> DAO_plus() {
		ArrayList<DTO_CHECK> plus = new ArrayList<DTO_CHECK>();

		try {
			getConn();

			sql = "select * from examination_items where check_number > 20";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				int r_check_num = rs.getInt(1);
				String r_check_name = rs.getString(2);
				int r_cost = rs.getInt(3);
				String r_script = rs.getString(4);

				dto_check = new DTO_CHECK(r_check_num, r_check_name, r_cost, r_script);
				plus.add(dto_check);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return plus;
	}

//--------------------------------------------------------------------------------------------------------------

	// 검진번호 받아서 검진이름, 안내사항 리턴
	public DTO_GUIDE DAO_guide(Object num) {

		try {
			getConn();

			sql = "select check_name, script from examination_items where check_number = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				String r_check_name = rs.getString(1);
				String r_script = rs.getString(2);

				dto_guide = new DTO_GUIDE(r_check_name, r_script);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return dto_guide;
	}

//----------------------------------------------------------------------------------------------------------

	// 검사이름 받아와서 검진항목 전체 리턴
	public DTO_CHECK DAO_select(String check_name) {

		try {
			getConn();

			sql = "select check_number,check_name,cost,script from examination_items where check_name = ?"; // 검진이름 받아옴
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, check_name);

			rs = psmt.executeQuery();

			if (rs.next()) {

				int r_check_num = rs.getInt(1);
				String r_check_name = rs.getString(2);
				int r_cost = rs.getInt(3);
				String r_script = rs.getString(4);

				dto_check = new DTO_CHECK(r_check_num, r_check_name, r_cost, r_script);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto_check;
	}
}
