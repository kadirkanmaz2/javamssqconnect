package javasssqlconnect;

import java.sql.*;

public class Baglan {
	Connection baglan;

	public Baglan(Connection con) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			baglan = con;
			System.out.println("Veri Tabaný Baglantisi basarili..");
		} catch (Exception e) {
			System.out.println(
					"Veri Tabaný Baðlantýsý baþarýsýz. Lütfen baðlantý bilgileri kontrol edip tekrar deneyiniz.");
		}
	}
}
