package pf.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JTable;
import java.util.ArrayList;

public class OutGui {

	private JFrame frame;
	private JTextField textSuche;
	private JButton btnSuchen;
	private JButton btnSpeichern;
	static ArrayList<String> feldListe = new ArrayList<String>();
private JTextField textID;
private JTextField textFeldChar;
private JTextField textFeldInt;
private JTextField texttest1;
private JTextField textTest4;
private JTextField textBlkk;
private JTextField textff;
private JTextField textttt;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutGui window = new OutGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OutGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1049, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSuche = new JLabel("Suchwert");
		lblSuche.setBounds(12, 13, 56, 16);
		frame.getContentPane().add(lblSuche);

		textSuche = new JTextField();
		textSuche.setBounds(80, 10, 209, 22);
		frame.getContentPane().add(textSuche);
		
		
//--------Beginn generierte Komponenten-----------
JLabel lblID = new JLabel("ID");
lblID.setBounds(12,33 , 56, 36);
frame.getContentPane().add(lblID);
feldListe.add("ID");
 
textID = new JTextField();
textID.setBounds(80, 40, 209, 22);
frame.getContentPane().add(textID);
 
 
JLabel lblFeldChar = new JLabel("FeldChar");
lblFeldChar.setBounds(12,53 , 56, 56);
frame.getContentPane().add(lblFeldChar);
feldListe.add("FeldChar");
 
textFeldChar = new JTextField();
textFeldChar.setBounds(80, 70, 209, 22);
frame.getContentPane().add(textFeldChar);
 
 
JLabel lblFeldInt = new JLabel("FeldInt");
lblFeldInt.setBounds(12,73 , 56, 76);
frame.getContentPane().add(lblFeldInt);
feldListe.add("FeldInt");
 
textFeldInt = new JTextField();
textFeldInt.setBounds(80, 100, 209, 22);
frame.getContentPane().add(textFeldInt);
 
 
JLabel lbltest1 = new JLabel("test1");
lbltest1.setBounds(12,93 , 56, 96);
frame.getContentPane().add(lbltest1);
feldListe.add("test1");
 
texttest1 = new JTextField();
texttest1.setBounds(80, 130, 209, 22);
frame.getContentPane().add(texttest1);
 
 
JLabel lblTest4 = new JLabel("Test4");
lblTest4.setBounds(12,113 , 56, 116);
frame.getContentPane().add(lblTest4);
feldListe.add("Test4");
 
textTest4 = new JTextField();
textTest4.setBounds(80, 160, 209, 22);
frame.getContentPane().add(textTest4);
 
 
JLabel lblBlkk = new JLabel("Blkk");
lblBlkk.setBounds(12,133 , 56, 136);
frame.getContentPane().add(lblBlkk);
feldListe.add("Blkk");
 
textBlkk = new JTextField();
textBlkk.setBounds(80, 190, 209, 22);
frame.getContentPane().add(textBlkk);
 
 
JLabel lblff = new JLabel("ff");
lblff.setBounds(12,153 , 56, 156);
frame.getContentPane().add(lblff);
feldListe.add("ff");
 
textff = new JTextField();
textff.setBounds(80, 220, 209, 22);
frame.getContentPane().add(textff);
 
 
JLabel lblttt = new JLabel("ttt");
lblttt.setBounds(12,173 , 56, 176);
frame.getContentPane().add(lblttt);
feldListe.add("ttt");
 
textttt = new JTextField();
textttt.setBounds(80, 250, 209, 22);
frame.getContentPane().add(textttt);
 
 
String[] columnNames = ArrayList2StringList(feldListe) ;


        //----------------------------------
		btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(327, 9, 97, 25);
		frame.getContentPane().add(btnSuchen);

		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(12, 355, 97, 25);
		frame.getContentPane().add(btnSpeichern);
		// ----------Table----------

		
//		String[][] rowData = { { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" }, { "Spanien", "217" },
//				{ "Türkei", "215" }, { "England", "214" }, { "Frankreich", "190" }, { "Griechenland", "185" },
//				{ "Deutschland", "180" }, { "Portugal", "170" } };
		String[][] rowData = {};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 37, 696, 348);
		frame.getContentPane().add(scrollPane);
		
				table = new JTable(rowData, columnNames);
				scrollPane.setViewportView(table);

	}
	
	
		// ----------------------------------------------------------------
	private static String[] ArrayList2StringList(ArrayList arrayList) {
		// ----------------------------------------------------------------

		String[] outStringList = new String[arrayList.size()];
		for (int x = 0; x < arrayList.size(); x++) {
			outStringList[x] = (String) arrayList.get(x);

		}

		return outStringList;
	}
	
	
}
