package javasssqlconnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sil extends Baglan {
	public Sil(Connection con, int id) {
		super(con);
		try {
			String sorgu = "delete from Members where MemberID=" + id;
			System.out.println(sorgu);
			Statement st = con.createStatement();
			st.executeUpdate(sorgu);
			System.out.println("Silme i�lemi ba�ar�l� bir �ekilde ger�ekle�mi�tir.");
		} catch (Exception e) {
			Logger.getLogger(Sil.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
