package javasssqlconnect;

import java.sql.*;

public class Baglan {
	Connection baglan;

	public Baglan(Connection con) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			baglan = con;
			System.out.println("Veri Taban� Baglantisi basarili..");
		} catch (Exception e) {
			System.out.println(
					"Veri Taban� Ba�lant�s� ba�ar�s�z. L�tfen ba�lant� bilgileri kontrol edip tekrar deneyiniz.");
		}
	}
}
