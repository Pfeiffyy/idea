package pf.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JTable;

public class GuiDetail {

	private JFrame frame;
	private JTextField textSuche;
	private JButton btnSuchen;
	private JButton btnSpeichern;
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
					GuiDetail window = new GuiDetail();
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
	public GuiDetail() {
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
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(12, 33, 56, 36);
		frame.getContentPane().add(lblID);
		textID = new JTextField();
		textID.setBounds(80, 40, 209, 22);
		frame.getContentPane().add(textID);
		JLabel lblFeldChar = new JLabel("FeldChar");
		lblFeldChar.setBounds(12, 53, 56, 56);
		frame.getContentPane().add(lblFeldChar);
		textFeldChar = new JTextField();
		textFeldChar.setBounds(80, 70, 209, 22);
		frame.getContentPane().add(textFeldChar);
		JLabel lblFeldInt = new JLabel("FeldInt");
		lblFeldInt.setBounds(12, 73, 56, 76);
		frame.getContentPane().add(lblFeldInt);
		textFeldInt = new JTextField();
		textFeldInt.setBounds(80, 100, 209, 22);
		frame.getContentPane().add(textFeldInt);
		JLabel lbltest1 = new JLabel("test1");
		lbltest1.setBounds(12, 93, 56, 96);
		frame.getContentPane().add(lbltest1);
		texttest1 = new JTextField();
		texttest1.setBounds(80, 130, 209, 22);
		frame.getContentPane().add(texttest1);
		JLabel lblTest4 = new JLabel("Test4");
		lblTest4.setBounds(12, 113, 56, 116);
		frame.getContentPane().add(lblTest4);
		textTest4 = new JTextField();
		textTest4.setBounds(80, 160, 209, 22);
		frame.getContentPane().add(textTest4);
		JLabel lblBlkk = new JLabel("Blkk");
		lblBlkk.setBounds(12, 133, 56, 136);
		frame.getContentPane().add(lblBlkk);
		textBlkk = new JTextField();
		textBlkk.setBounds(80, 190, 209, 22);
		frame.getContentPane().add(textBlkk);
		JLabel lblff = new JLabel("ff");
		lblff.setBounds(12, 153, 56, 156);
		frame.getContentPane().add(lblff);
		textff = new JTextField();
		textff.setBounds(80, 220, 209, 22);
		frame.getContentPane().add(textff);
		JLabel lblttt = new JLabel("ttt");
		lblttt.setBounds(12, 173, 56, 176);
		frame.getContentPane().add(lblttt);
		textttt = new JTextField();
		textttt.setBounds(80, 250, 209, 22);
		frame.getContentPane().add(textttt);

//---------------------------------------------------------------------------------
		btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(327, 9, 97, 25);
		frame.getContentPane().add(btnSuchen);

		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(12, 355, 97, 25);
		frame.getContentPane().add(btnSpeichern);

		// ----------Table----------
		String[] columnNames = { "Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten" };

		
		String[][] rowData = { { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" }, { "Spanien", "217" },
				{ "Türkei", "215" }, { "England", "214" }, { "Frankreich", "190" }, { "Griechenland", "185" },
				{ "Deutschland", "180" }, { "Portugal", "170" } };

		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 37, 696, 348);
		frame.getContentPane().add(scrollPane);
		
				table = new JTable(rowData, columnNames);
				scrollPane.setViewportView(table);

	}
}
