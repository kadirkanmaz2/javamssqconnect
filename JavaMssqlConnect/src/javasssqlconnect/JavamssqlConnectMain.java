package javasssqlconnect;

import java.sql.*;

import javax.swing.JOptionPane;

public class JavamssqlConnectMain {
	public static Connection conStr = null;
	public static boolean dongu = true;

	public static void Listele() {
		Listele list = new Listele(conStr);
	}

	public static void Dongu() {
		int yesorno = JOptionPane.showConfirmDialog(null, "Ýþlemlere devam etmek istiyor musunuz ?",
				"JAVA MSSQL Connect", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (yesorno == 0)
			dongu = true;
		else
			dongu = false;
	}

	public static void main(String[] args) {
		System.out.println("JavaMSSQLConnect: Veri Tabaný iþlemleri..");
		try {
			conStr = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=veri;user=sa;password=sqlpass7.");
		} catch (Exception e) {
			// TODO: handle exception
		}

		while (dongu) {
			int cevap = Integer.parseInt(
					JOptionPane.showInputDialog(null, "{1}Listele\n{2}Kayýt Ekle\n{3}Güncelle\n{4}Kayýt Sil\n{5}Çýkýþ",
							"Yapmak istediðiniz Ýþlemi Belirtiniz..", JOptionPane.QUESTION_MESSAGE));
			String ad, soyad, email = "";
			switch (cevap) {
			case 1:
				Listele();
				Dongu();
				break;
			case 2:
				ad = JOptionPane.showInputDialog(null, "Ad giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				soyad = JOptionPane.showInputDialog(null, "Soyad giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				email = JOptionPane.showInputDialog(null, "Email giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				Ekle ekle = new Ekle(conStr, ad, soyad, email);
				Listele();
				Dongu();
				break;
			case 3:
				int MemberID = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Güncellemek istediðiniz kaydýn ID'sini giriniz.",
								"Kayýt Silme", JOptionPane.QUESTION_MESSAGE));
				ad = JOptionPane.showInputDialog(null, "Ad giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				soyad = JOptionPane.showInputDialog(null, "Soyad giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				email = JOptionPane.showInputDialog(null, "Email giriniz...", "Yapmak istediðiniz Ýþlemi Belirtiniz..",
						JOptionPane.QUESTION_MESSAGE);
				Guncelle g = new Guncelle(conStr, ad, soyad, email, MemberID);
				Listele();
				Dongu();
				break;
			case 4:
				Listele();
				int id = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Silmek istediðiniz kaydýn ID'sini giriniz.", "Kayýt Silme", JOptionPane.QUESTION_MESSAGE));
				Sil sil = new Sil(conStr, id);
				Listele();
				Dongu();
				break;
			case 5:
				System.out.println("Güvenli bir þekilde çýkýþ yapýldý.");
				dongu = false;
				break;
			default:
				System.out.println("Yanlýþ bir deðer girdiniz.");
				break;
			}
		}

	}
}
