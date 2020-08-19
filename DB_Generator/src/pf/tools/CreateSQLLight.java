package pf.tools;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import de.pfeiffy.help.Helper;

/**
 *
 * @author sqlitetutorial.net
 */
public class CreateSQLLight {

	static String db = "db_generator" + Helper.getDateDatei() + ".db";
	static String tabelle = "tab1";
	static String csvName = "InputDB.csv";
	static String staticFile = "dateien/2_static.txt";
	static String labeltextFile = "labelText.txt";
	static String tabFelder[] = { "ID;int4", "FeldChar;varchar(254)" };

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		makeGui(csvName);
		connect();
		createNewTable(db, tabelle, csvName);

		String[] dateien = { "dateien/1_deklaration.txt", staticFile,"dateien/3_nachStatic.txt","dateien/4_labelText.txt","dateien/5_suchButton.txt", "dateien/6_table_Ende.txt" };
		File outFile = Helper.dateienInDatei(dateien, "src\\pf\\gui\\OutGui.java");

		System.out.println();
	}



	private static void makeGui(String csvName) {
		ArrayList<DbFeld> tabFelder = GetDbFelder(csvName);
		new File(staticFile).delete();
		new File(labeltextFile).delete();

		int liO = 33;
		int liU = 36;
		int textBound = 40;

		for (DbFeld dbFeld : tabFelder) {
			// globale Variablen Deklaration
			Helper.schreiben("--------Beginn generierte Komponenten-----------", labeltextFile, true);

			Helper.schreiben("private JTextField text" + dbFeld.feld + ";", staticFile, true);

			// Label schreiben
//			JLabel lblSuche = new JLabel("Suchwert");
			String text = "JLabel lbl" + dbFeld.feld + " = new JLabel(\"" + dbFeld.feld + "\");";
			Helper.schreiben(text, labeltextFile, true);
//			lblSuche.setBounds(12, 13, 56, 16);
			text = "lbl" + dbFeld.feld + ".setBounds(12," + liO + " , 56, " + liU + ");";
			Helper.schreiben(text, labeltextFile, true);
//			frame.getContentPane().add(lblSuche);
			text = "frame.getContentPane().add(" + "lbl" + dbFeld.feld + ");";
			Helper.schreiben(text, labeltextFile, true);
//			
			Helper.schreiben(" ", labeltextFile, true);

//			textSuche = new JTextField();
			text = "text" + dbFeld.feld + " = new JTextField();";
			Helper.schreiben(text, labeltextFile, true);
//			textSuche.setBounds(80, 10, 209, 22);
			text = "text" + dbFeld.feld + ".setBounds(80, " + textBound + ", 209, 22);";
			Helper.schreiben(text, labeltextFile, true);
//			frame.getContentPane().add(textSuche);
			text = "frame.getContentPane().add(" + "text" + dbFeld.feld + ");";
			Helper.schreiben(text, labeltextFile, true);
			Helper.schreiben("-------------------------------------------------", labeltextFile, true);

			liO += 20;
			liU += 20;
			textBound += 30;

			System.out.println();
		}
		System.out.println();
	}

	private static ArrayList<DbFeld> GetDbFelder(String csvName2) {
		ArrayList<String> tabFelder = Helper.file2ArrayList(csvName2);
		ArrayList<DbFeld> outList = new ArrayList<DbFeld>();
		for (String tabF : tabFelder) {
			String[] feld = tabF.split(";");
			DbFeld dbFeld = new DbFeld(feld[0], feld[1], 0);
			outList.add(dbFeld);
		}

		return outList;
	}

	/**
	 * Connect to a sample database
	 */
	public static void connect() {
		Connection conn = null;
		try {
			// db parameters
			String url = db;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private static void createNewTable(String dbname, String tabname, String csvName) {
		// SQLite connection string
		String url = "jdbc:sqlite:" + dbname;
		ArrayList<String> tabFelder = Helper.file2ArrayList(csvName);

		StringBuffer sb = new StringBuffer();
		for (String felder : tabFelder) {
			String[] feld = felder.split(";");
			sb.append(" " + feld[0] + " " + feld[1] + "," + " ");
		}
		String sbf = sb.toString();
		sb.deleteCharAt(sb.length() - 2);

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + tabname + " (" + sb.toString() + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}