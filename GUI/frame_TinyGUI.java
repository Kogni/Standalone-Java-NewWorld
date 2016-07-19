package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import Model.Object_Building;
import Model.Object_BuildingType;
import Model.Object_Landtypes;
import Model.Object_Resource;
import Model.SpringUtilities;

public class frame_TinyGUI extends JFrame implements ActionListener {
    private JLabel Tekst1;
    JTextArea Tekst3;
    private JTextField Tekst2;
    JButton Knapp;
    JLabel BygningsNavn;
    JTextArea BygningsInfo;
    JLabel BygningsLevel;
    JLabel ByggingsTid;
    JLabel ByggingsRaavare1;
    JLabel ByggingsRaavareTall1;
    JLabel ByggingsRaavare2;
    JLabel ByggingsRaavareTall2;
    JLabel ByggingBricks;
    JLabel ByggingLumber;
    JLabel ByggingTools;
    JLabel ByggingLand;
    JLabel ByggingProdukt;
    Object_Resource[] Array_Resources = new Object_Resource[24];
    Object_Landtypes[] Array_Land = new Object_Landtypes[13];
    Object_BuildingType[] Array_ByggTyper = new Object_BuildingType[24];
    Object_Building[] Array_Bygg = new Object_Building[24];
    public frame_TinyGUI() {
	super("New World - Main");
    }
    public void SettOpp(Object_Resource Array_Resources2[], Object_Landtypes Array_Land2[], Object_BuildingType Array_ByggTyper2[],
	    Object_Building Array_Bygg2[]) {
	Array_Resources = Array_Resources2;
	Array_Land = Array_Land2;
	Array_ByggTyper = Array_ByggTyper2;
	Array_Bygg = Array_Bygg2;
	JPanel panel = new JPanel(new SpringLayout());
	int rows = 10;
	int cols = 10;
	for (int r = 0; r < rows; r++) {
	    // for (int c = 0; c < cols; c++) {
	    // int anInt = (int) Math.pow(r, c);
	    // JTextField textField = new JTextField(Integer.toString(anInt));
	    // JTextField textField2 = new JTextField("beh");
	    // panel.add(textField);
	    // panel.add(textField2);
	    // }
	}
	JTextField textField = new JTextField("A");
	panel.add(textField);
	JTextField textField2 = new JTextField("B");
	panel.add(textField2);
	JTextField textField3 = new JTextField("C");
	panel.add(textField3);
	JTextField textField4 = new JTextField("D");
	panel.add(textField4);
	/*
	 * SpringUtilities.makeCompactGrid(panel, //parent rows, cols, 3, 3, //initX, initY 3, 3); //xPad, yPad
	 */
	SpringUtilities.makeCompactGrid(panel, // parent
		2, 2, 1, 1, // initX, initY
		1, 1); // xPad, yPad
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame = new JFrame("SpringCompactGrid");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setOpaque(true); // content panes must be opaque
	frame.setContentPane(panel);
	frame.pack();
	frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
	// System.out.println(e);
	for (int x = 0; x < 24; x++) {
	    if (e.getActionCommand().equals(Array_ByggTyper[x].HentNavn())) {
		// System.out.println("pling: " + x + " " + Array_ByggTyper[x].HentNavn());
		BygningsNavn.setText(Array_ByggTyper[x].HentNavn());
		BygningsInfo.setText(Array_ByggTyper[x].HentInfo());
		int Level = (Array_Bygg[x].HentLevel());
		// Level =Level + 1;
		BygningsLevel.setText("Level: " + (Level + 1));
		// ByggingsTid.setText("Buildingtime: " + 100*((1.5^(Level-1))));
		int Temp = 100;
		Temp = (int) (Temp * (Math.pow(1.5, (Level))));
		// System.out.println(Math.pow(2,3));
		ByggingsTid.setText("Buildingtime: " + Temp);
		Temp = (int) (25 * (Math.pow(1.5, (Level))));
		ByggingBricks.setText("Bricks needed: " + Temp);
		Temp = (int) (25 * (Math.pow(1.5, (Level))));
		ByggingLumber.setText("Lumber needed: " + Temp);
		Temp = (int) (25 * (Math.pow(1.5, (Level))));
		ByggingTools.setText("Tools needed: " + Temp);
		Temp = (int) (25 * (Math.pow(1.5, (Level))));
		ByggingLand.setText("Land type needed: " + Array_ByggTyper[x].HentLand().HentNavn() + " (" + (Level + 1) + ")");
		Temp = (int) (5 * (Math.pow(1.5, (Level))));
		ByggingProdukt.setText("resource produced: " + Array_ByggTyper[x].HentProdukt().HentNavn() + " (" + Temp + ")");
		Temp = (int) (5 * (Math.pow(1.5, (Level))));
		if (Array_ByggTyper[x].HentRaavaren1() == null) {
		    ByggingsRaavare1.setText("");
		    ByggingsRaavareTall1.setText("");
		} else {
		    // ByggingsRaavare1.setText(Array_ByggTyper[x].HentRaavaren1().HentNavn());
		    // ByggingsRaavareTall1.setText((5)+"");
		    ByggingsRaavare1.setText(Array_ByggTyper[x].HentRaavaren1().HentNavn() + ": " + Temp);
		}
		if (Array_ByggTyper[x].HentRaavaren2() == null) {
		    ByggingsRaavare2.setText("");
		    ByggingsRaavareTall2.setText("");
		} else {
		    // ByggingsRaavare2.setText(Array_ByggTyper[x].HentRaavaren2().HentNavn());
		    // ByggingsRaavareTall2.setText((5)+"");
		    ByggingsRaavare2.setText(Array_ByggTyper[x].HentRaavaren2().HentNavn() + ": " + Temp);
		}
		// ByggingsRaavareTall;
	    }
	}
	/*
	 * if ( e.getActionCommand().equals("Action") ) { if ( Action.getText().equals(RegBil) ) { //RegistrerBil(); } } else if (
	 * e.getActionCommand().equals(RegBil) ) { /* Action.setText(e.getActionCommand()); EierNavn.setVisible(true);
	 * EierAdresse.setVisible(true); EierNummer.setVisible(true); BilNummer.setVisible(true); BilMerkeType.setVisible(true);
	 * BilRegistrert.setVisible(true); Utskrift.setVisible(true); Action.setVisible(true); Line1.setVisible(true);
	 * Line2.setVisible(true); Line3.setVisible(true); Line4.setVisible(true); Line5.setVisible(true); EierNummeret.setVisible(true);
	 * Line6.setVisible(true); Line7.setVisible(true); Line8.setVisible(true); Utskrift.setText(""); }
	 */
    }
}
