package javasssqlconnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ekle extends Baglan {
	public Ekle(Connection con, String ad, String soyad, String email) {
		super(con);
		try {
			String sorgu = "insert into Members(Ad,Soyad,Email) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sorgu);
			ps.setString(1, ad);
			ps.setString(2, soyad);
			ps.setString(3, email);
			ps.executeUpdate();
			System.out.println("Ekleme iþlemi baþarýlý.");
		} catch (Exception e) {
			Logger.getLogger(Ekle.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
