package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class M_DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	M_DTO_RGS dto_rgs = null;
	M_DTO_RESULT dto_result = null;
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

//-------------------------------------------------------------------------------------------------------------	
	// ������ �ð��� �Ǹ� �����ڰ� ���� �������̺��� �ش� ������ ���� -> �������̺��̶� �θ�����
	public int M_DAO_Del(int booking_number) {

		try {
			getConn();
			
			sql = "delete booking where booking_number = ?"; // �����ȣ�� �Է¹���
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, booking_number);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

//--------------------------------------------------------------------------------------------------------------
	// �������̺�
	public ArrayList<M_DTO_RGS> M_DAO_RGS() {

		ArrayList<M_DTO_RGS> arr_rgs = new ArrayList<M_DTO_RGS>();

		try {
			getConn();

			sql = "select * from booking order by RSRVT_DATE, RSRVT_TIME";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String r_date = rs.getString(1);
				String r_time = rs.getString(2);
				int r_member_id = rs.getInt(3);
				int r_booking_number = rs.getInt(4);

				dto_rgs = new M_DTO_RGS(r_date, r_time, r_member_id, r_booking_number);
				arr_rgs.add(dto_rgs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return arr_rgs;

	}

//------------------------------------------------------------------------------------------------------------------------	
	// ������̺� �Է� //��� ���̺� �ý����� �־ ������ ��� �����
	public int M_DAO_RESULT_INPUT(int member_id, String gohyulap, String biman, String am, String dangnyo, String chunsik,
			String gankyungha) {

		try {
			getConn();

			sql = "insert into result values (?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, member_id);
			psmt.setString(2, gohyulap);
			psmt.setString(3, biman);
			psmt.setString(4, am);
			psmt.setString(5, dangnyo);
			psmt.setString(6, chunsik);
			psmt.setString(7, gankyungha);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

//--------------------------------------------------------------------------------------------------------------------------------------
	// ��� ����鿡 ���� ������̺� ����
	public ArrayList<M_DTO_RESULT> M_DAO_RESULT_VIEW() {

		ArrayList<M_DTO_RESULT> arr_result = new ArrayList<M_DTO_RESULT>();

		try {
			getConn();

			sql = "select * from result";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int r_member_id = rs.getInt(1);
				String r_gohyulap = rs.getString(2);
				String r_biman = rs.getString(3);
				String r_am = rs.getString(4);
				String r_dangnyo = rs.getString(5);
				String r_chunsik = rs.getString(6);
				String r_gankyungha = rs.getString(7);

				dto_result = new M_DTO_RESULT(r_member_id, r_gohyulap, r_biman, r_am, r_dangnyo, r_chunsik,
						r_gankyungha);
				arr_result.add(dto_result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return arr_result;
	}
//-----------------------------------------------------------------------------------------------------------------------------------

}
