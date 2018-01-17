package javasssqlconnect;

import java.sql.*;

public class Guncelle extends Baglan {
	public Guncelle(Connection conStr, String ad, String soyad, String email, int id) {
		super(conStr);
		try {
			String sorgu = "update Members set "
					+ "ad=?,"
					+ "soyad=?,"
					+ "email=? "
					+ " where MemberID=?";
			PreparedStatement ps = conStr.prepareStatement(sorgu);
			ps.setString(1, ad);
			ps.setString(2, soyad);
			ps.setString(3, email);
			ps.setInt(4, id);
			ps.execute();
			ps.close();
			System.out.println("Güncelleme iþlemi baþarýyla tamamlanmýþtý.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
