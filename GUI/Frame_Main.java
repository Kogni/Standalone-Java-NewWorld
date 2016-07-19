package GUI;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Model.Object_Building;
import Model.Object_BuildingType;
import Model.Object_Landtypes;
import Model.Object_Resource;
import control.API;
import control.Brain_Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;

public class Frame_Main extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel Tekst1;
    public JLabel Month;
    JTextArea Tekst3;
    private JLabel Tekst2;
    JButton Knapp;
    public JProgressBar ExpeditionBar;
    public JProgressBar BuildingBar;
    public JProgressBar ResourceBar;
    public JProgressBar MonthBar;
    public boolean ExpeditionGoing = false;
    public boolean BuildingGoing = false;
    public Container pane = getContentPane();
    public JLabel BygningsNavn;
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
    Object_BuildingType[] Array_ByggTyper = new Object_BuildingType[99];
    Object_Building[] Array_Bygg = new Object_Building[99];
    // String[] ResurssTekster = new String[24];
    public JLabel[] ResurssTekster = new JLabel[99];
    public JLabel[] ResurssProduksjon = new JLabel[99];
    public JLabel[] LandTekster = new JLabel[13];
    public JLabel ExpeditionTekst;
    public JLabel PopulationTekst;
    public JLabel PopulationSizeTekst;
    public JButton[] BygningsKnapper = new JButton[99];
    int Bygningsantall;
    public Frame_Main(API api) {
	super("New World - Main");
    }

    public void SettOpp(Object_Resource Array_Resources2[], Object_Landtypes Array_Land2[], Object_BuildingType Array_ByggTyper2[],
	    Object_Building Array_Bygg2[], int Bygningsantallet) {
	Array_Resources = Array_Resources2;
	Array_Land = Array_Land2;
	Array_ByggTyper = Array_ByggTyper2;
	Array_Bygg = Array_Bygg2;
	// System.out.println(Bygningsantall);
	Bygningsantall = Bygningsantallet;
	LagGUI();
    }
    public void LagGUI() {
	Container pane = getContentPane();
	pane.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	// venstre side
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("Production:");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 1;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	ResourceBar = new JProgressBar(0, 1000);
	ResourceBar.setValue(2000);
	ResourceBar.setStringPainted(true);
	c.gridx = 0;
	c.gridy = 2;
	pane.add(ResourceBar, c);
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	for (int x = 0; x < 24; x++) {
	    Tekst1 = new JLabel(Array_Resources[x].HentNavn());
	    c.gridx = 1;
	    c.gridy = 1 + x;
	    pane.add(Tekst1, c);
	    Tekst2 = new JLabel(Array_Resources[x].HentStorage() + "");
	    c.gridx = 2;
	    c.gridy = 1 + x;
	    pane.add(Tekst2, c);
	    // ResurssTekster[x] = Tekst2.getText();
	    ResurssTekster[x] = Tekst2;
	    // System.out.println("Adder " + Tekst2.getText() + " til nr " + x);
	    // System.out.println("adder til X=1 og 0, Y="+x);
	    Tekst2 = new JLabel(Array_Resources[x].Production + "");
	    // System.out.println(x);
	    c.gridx = 3;
	    c.gridy = 1 + x;
	    pane.add(Tekst2, c);
	    ResurssProduksjon[x] = Tekst2;
	}
	// midterste side
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 5;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 6;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	for (int x = 0; x < 13; x++) {
	    Tekst1 = new JLabel(Array_Land[x].HentNavn());
	    c.gridx = 5;
	    c.gridy = 1 + x;
	    pane.add(Tekst1, c);
	    Tekst1 = new JLabel(Array_Land[x].HentStorage() + "");
	    c.gridx = 6;
	    c.gridy = 1 + x;
	    pane.add(Tekst1, c);
	    LandTekster[x] = Tekst1;
	}
	Knapp = new JButton("Search for more land");
	Knapp.setActionCommand("Search for more land");
	Knapp.addActionListener(this);
	c.gridx = 5;
	c.gridy = 14;
	c.gridwidth = 1;
	pane.add(Knapp, c);
	ExpeditionBar = new JProgressBar(0, 7000);
	ExpeditionBar.setValue(7000);
	ExpeditionBar.setStringPainted(true);
	c.gridx = 5;
	c.gridy = 15;
	pane.add(ExpeditionBar, c);
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 7;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	// System.out.println(Bygningsantall);
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    // Tekst1 = new JLabel(Array_ByggTyper[x].HentNavn());
	    Knapp = new JButton(Array_Bygg[x].HentNavn() + " (" + Array_Bygg[x].HentLevel() + ")");
	    Knapp.setActionCommand(Array_ByggTyper[x].HentNavn());
	    Knapp.addActionListener(this);
	    c.gridx = 7;
	    c.gridy = 1 + x;
	    c.gridwidth = 1;
	    pane.add(Knapp, c);
	    BygningsKnapper[x] = Knapp;
	    // System.out.println(x);
	}
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 8;
	c.gridy = 0;
	c.gridwidth = 1;
	pane.add(Tekst1, c);
	BygningsNavn = new JLabel("Navnet");
	c.gridx = 8;
	c.gridy = 1;
	c.gridwidth = 2;
	// pane.add(Tekst3, c);
	// pane.add(Tekst1, c);
	pane.add(BygningsNavn, c);
	BygningsInfo = new JTextArea("Beskrivelse", 5, 20);
	// BygningsInfo = new JTextArea("Here your workers can get stone for your settlement. Stone is needed for making bricks, which is
	// needed for building any building. You NEED this building.",11, 1 ) ;
	BygningsInfo.setLineWrap(true);
	BygningsInfo.setWrapStyleWord(true);
	c.gridx = 8;
	c.gridy = 2;
	c.gridheight = 3;
	c.gridwidth = 1;
	pane.add(BygningsInfo, c);
	BygningsLevel = new JLabel("Level");
	c.gridx = 8;
	c.gridy = 4;
	pane.add(BygningsLevel, c);
	ByggingsTid = new JLabel("Byggetid");
	c.gridx = 8;
	c.gridy = 5;
	pane.add(ByggingsTid, c);
	// Råvare krevd #1
	ByggingsRaavare1 = new JLabel("");
	c.gridx = 8;
	c.gridy = 6;
	pane.add(ByggingsRaavare1, c);
	// Mengde råvare krevd #1
	ByggingsRaavareTall1 = new JLabel("");
	c.gridx = 8;
	c.gridy = 7;
	pane.add(ByggingsRaavareTall1, c);
	// Råvare krevd #2
	ByggingsRaavare2 = new JLabel("");
	c.gridx = 8;
	c.gridy = 7;
	pane.add(ByggingsRaavare2, c);
	// Mengde råvare krevd #2
	ByggingsRaavareTall2 = new JLabel("");
	c.gridx = 8;
	c.gridy = 9;
	pane.add(ByggingsRaavareTall2, c);
	ByggingBricks = new JLabel("Bricks needed:");
	c.gridx = 8;
	c.gridy = 8;
	pane.add(ByggingBricks, c);
	ByggingLumber = new JLabel("Lumber needed:");
	c.gridx = 8;
	c.gridy = 9;
	pane.add(ByggingLumber, c);
	ByggingTools = new JLabel("Tools needed:");
	c.gridx = 8;
	c.gridy = 10;
	pane.add(ByggingTools, c);
	ByggingLand = new JLabel("Land type needed:");
	c.gridx = 8;
	c.gridy = 11;
	pane.add(ByggingLand, c);
	ByggingProdukt = new JLabel("Resource produced:");
	c.gridx = 8;
	c.gridy = 12;
	pane.add(ByggingProdukt, c);
	Knapp = new JButton("Build this");
	Knapp.setActionCommand("Build this");
	Knapp.addActionListener(this);
	c.gridx = 8;
	c.gridy = 13;
	c.gridwidth = 1;
	pane.add(Knapp, c);
	BuildingBar = new JProgressBar(0, 7000);
	BuildingBar.setValue(7000);
	BuildingBar.setStringPainted(true);
	c.gridx = 8;
	c.gridy = 14;
	pane.add(BuildingBar, c);
	// høyre side
	// JPanel Panel5 = new JPanel(new GridLayout(0, 1));
	// Panel5.setBorder(BorderFactory.createLineBorder(Color.black));
	Tekst1 = new JLabel("_________________");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 9;
	c.gridy = 0;
	// c.gridwidth = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("Knapper til andre vinduer");
	c.gridx = 9;
	c.gridy = 1;
	pane.add(Tekst1, c);
	Tekst1 = new JLabel("Month: ");
	c.gridx = 9;
	c.gridy = 2;
	pane.add(Tekst1, c);
	Month = new JLabel("December");
	c.gridx = 9;
	c.gridy = 3;
	pane.add(Month, c);
	MonthBar = new JProgressBar(0, 30000);
	MonthBar.setValue(30000);
	MonthBar.setStringPainted(true);
	c.gridx = 9;
	c.gridy = 4;
	pane.add(MonthBar, c);
	Tekst1 = new JLabel("Meldinger om div her");
	c.gridx = 9;
	c.gridy = 5;
	pane.add(Tekst1, c);
	ExpeditionTekst = new JLabel("");
	c.gridx = 9;
	c.gridy = 6;
	// ExpeditionTekst.setText("");
	pane.add(ExpeditionTekst, c);
	PopulationTekst = new JLabel("");
	c.gridx = 9;
	c.gridy = 7;
	// PopulationTekst.setText("");
	pane.add(PopulationTekst, c);
	PopulationSizeTekst = new JLabel("");
	c.gridx = 9;
	c.gridy = 8;
	// PopulationTekst.setText("");
	pane.add(PopulationSizeTekst, c);
	pack();
	setVisible(true);
	// setSize( 600, 1000 );
    }
    public void actionPerformed(ActionEvent e) {
	// System.out.println(e);
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    if (e.getActionCommand().equals(Array_ByggTyper[x].HentNavn())) {
		// System.out.println(BuildingGoing);
		if (BuildingGoing == false) {
		    // System.out.println("pling: " + x + " " + Array_ByggTyper[x].HentNavn());
		    BygningsNavn.setText(Array_ByggTyper[x].HentNavn());
		    BygningsInfo.setText(Array_ByggTyper[x].HentInfo());
		    int Level = (Array_Bygg[x].HentLevel());
		    // Level =Level + 1;
		    BygningsLevel.setText("Level: " + (Level + 1));
		    // ByggingsTid.setText("Buildingtime: " + 100*((1.5^(Level-1))));
		    int Temp = 7000;
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
		    if (Array_ByggTyper[x].HentProdukt() == null) {
			ByggingProdukt.setText("resource produced: ");
		    } else {
			ByggingProdukt.setText("resource produced: " + Array_ByggTyper[x].HentProdukt().HentNavn() + " (" + Temp + ")");
		    }
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
	}
	if (e.getActionCommand().equals("Search for more land")) {
	    // System.out.println("Lete etter land");
	    if (ExpeditionGoing == false) {
		ExpeditionGoing = true;
		ExpeditionBar.setValue(0);
	    }
	}
	if (e.getActionCommand().equals("Build this")) {
	    boolean Greit = true;
	    // System.out.println("Lete etter land");
	    for (int x = 0; x < Bygningsantall + 1; x++) {
		if (Array_Bygg[x].HentNavn() == BygningsNavn.getText()) {
		    int Level = (Array_Bygg[x].HentLevel());
		    int Price = 7000;
		    Price = (int) (25 * (Math.pow(1.5, (Level))));
		    ByggingBricks.setText("Bricks needed: " + Price);
		    ByggingLumber.setText("Lumber needed: " + Price);
		    for (int y = 0; y < 24; y++) {
			if (Array_Resources[y].ResourceName == "Bricks") {
			    if (Price > Array_Resources[y].ResourceStorage) {
				Greit = false;
				System.out.println("Not enough bricks");
			    }
			}
			if (Array_Resources[y].ResourceName == "Lumber") {
			    if (Price > Array_Resources[y].ResourceStorage) {
				Greit = false;
				System.out.println("Not enough lumber");
			    }
			}
			if (Array_Resources[y].ResourceName == "Tools") {
			    if (Price > Array_Resources[y].ResourceStorage) {
				Greit = false;
				System.out.println("Not enough tools");
			    }
			}
		    }
		    if (Array_ByggTyper[x].BuildSpot.LandStorage < (Array_Bygg[x].Level + 1)) {
			Greit = false;
			System.out.println("Not enough land");
		    } else {
			// System.out.println("Enough land, have " + Array_ByggTyper[x].BuildSpot.LandStorage + " and need only " +
			// (Array_Bygg[x].Level+1));
		    }
		    if (Greit == true) {
			BuildingGoing = true;
			// int Temp = 7000;
			int Temp = 7000;
			// int Level = (Array_Bygg[x].HentLevel());
			Temp = (int) (Temp * (Math.pow(1.5, (Level))));
			BuildingBar.setMaximum(Temp);
			BuildingBar.setValue(0);
			// myControl.LandGained();
			for (int y = 0; y < 24; y++) {
			    if (Array_Resources[y].ResourceName == "Bricks") {
				Array_Resources[y].ResourceStorage = Array_Resources[y].ResourceStorage - Price;
			    }
			    if (Array_Resources[y].ResourceName == "Lumber") {
				Array_Resources[y].ResourceStorage = Array_Resources[y].ResourceStorage - Price;
			    }
			    if (Array_Resources[y].ResourceName == "Tools") {
				Array_Resources[y].ResourceStorage = Array_Resources[y].ResourceStorage - Price;
			    }
			}
			Array_ByggTyper[x].BuildSpot.LandStorage = Array_ByggTyper[x].BuildSpot.LandStorage - (Array_Bygg[x].Level + 1);
		    } else {
			// System.out.println("Not enough resources");
		    }
		}
	    }
	}
    }
}
