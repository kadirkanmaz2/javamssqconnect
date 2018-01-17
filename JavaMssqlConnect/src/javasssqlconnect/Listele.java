package javasssqlconnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listele extends Baglan {
	public Listele(Connection con) {
		super(con);
		try {
			String sorgu = "Select * from Members";
			Statement durum = con.createStatement();
			ResultSet resultSet = durum.executeQuery(sorgu);
			System.out.println("------- Ogrenci Listesi -------");
			System.out.println("ID\t Adý\t Soyadý \t Email");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("MemberID") + "\t" + resultSet.getString("Ad") + "\t"
						+ resultSet.getString("Soyad") + "\t" + resultSet.getString("Email"));
			}
		} catch (Exception e) {
			Logger.getLogger(Listele.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
