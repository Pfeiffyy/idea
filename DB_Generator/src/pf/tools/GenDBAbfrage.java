package pf.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import de.pfeiffy.help.Helper;


public class GenDBAbfrage {
	static Connection con;
	static Connection c = null;
	static Statement stmt = null;

	public static void main(String[] args) throws Exception {
		String tabellenName = "IBKAP2_WD_AD";
		String schema = "IBKAZUBI";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String cons = "jdbc:oracle:thin:IBKAZUBI/manager@//DBS-TAZUBI.zdkwh.mlrbw.net:1521/TAZUBI.zdkwh.mlrbw.net";
		// Connect to the database and return a Connection instance
		con = DriverManager.getConnection(cons);

		//Spaltennamen ermitteln
		String abfrage = "SELECT * FROM all_tab_columns WHERE table_name= '"+tabellenName+"'";
		PreparedStatement ps = con.prepareStatement(abfrage);
		ResultSet rs = ps.executeQuery();
		ArrayList<String>  spaltennamen = new ArrayList<String>(); 
		StringBuffer sb = new StringBuffer();
		while (rs.next()) {
			String feld = rs.getString("COLUMN_NAME");
			String format = rs.getString("DATA_TYPE");
			spaltennamen.add(feld+";"+format);
			Helper.s(" Feldname: "+feld);
			Helper.s(" Feldtyp: "+format);
			sb.append(feld);
			sb.append(";");

		}
		
		
		//Daten generisch abfragen
		String abfrageDaten = "SELECT * from "+schema+"."+tabellenName;
		PreparedStatement psDaten = con.prepareStatement(abfrageDaten);
		ResultSet rsDaten = psDaten.executeQuery();
		while (rsDaten.next()) {
			int x=1;
			
			for(String spalt: spaltennamen)
			{
				String feld = spalt.split(";")[0];
				String format = spalt.split(";")[1];
//				System.out.println(feld + " / "+ format + " = " + rsDaten.getString(x));
				sb.append(feld);
				sb.append(";");
				
				x++;
			}
			System.out.println(sb.toString());
			System.out.println("---------------------------------------");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
