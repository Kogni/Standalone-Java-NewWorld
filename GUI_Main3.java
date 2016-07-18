import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Main3 extends JFrame implements ActionListener {
	
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
	Object_Resource [] Array_Resources = new Object_Resource[24];
	Object_Landtypes [] Array_Land = new Object_Landtypes[13];
	Object_BuildingType [] Array_ByggTyper = new Object_BuildingType[24];
	Object_Building [] Array_Bygg = new Object_Building[24];

	public GUI_Main3(){
	    super( "New World - Main" );

	}
	
	public void SettOpp(Object_Resource Array_Resources2[], Object_Landtypes Array_Land2[], Object_BuildingType Array_ByggTyper2[], Object_Building Array_Bygg2[]){
		Array_Resources = Array_Resources2;
		Array_Land = Array_Land2;
		Array_ByggTyper = Array_ByggTyper2;
		Array_Bygg = Array_Bygg2;

		Container pane = getContentPane();
		JPanel TotalPanel = new JPanel(new SpringLayout());
		//pane.setLayout(new GridLayout(0,3));
		pane.setLayout( new SpringLayout());
		GridBagConstraints c = new GridBagConstraints();
		//pane.setLayout(new BorderLayout());

		//venstre side
		JPanel Panel1 = new JPanel(new GridLayout(2,0));
		//JPanel Panel1 = new JPanel();
		Panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		Tekst1 = new JLabel("Ledig plass");
		//pane.add(Tekst1, c);
		Panel1.add(Tekst1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		//c.gridwidth = 1;
		//pane.add(Panel1, c);
		pane.add(Panel1);
		TotalPanel.add(Panel1);
		
		JPanel ResourcePanel = new JPanel(new GridLayout(0,2));
		ResourcePanel.setBorder(BorderFactory.createLineBorder(Color.black));

	    for ( int x = 0 ; x < 24 ; x++ ) {
		    Tekst1 = new JLabel(Array_Resources[x].HentNavn());
			c.gridx = 2;
			c.gridy = 0+x;
			//pane.add(Tekst1, c);
			ResourcePanel.add(Tekst1);
			Tekst1 = new JLabel(Array_Resources[x].HentStorage()+"");
			c.gridx = 3;
			c.gridy = 0+x;
			ResourcePanel.add(Tekst1);
			//pane.add(Tekst1, c);
			//System.out.println("adder til X=1 og 0, Y="+x);
	    }
	    //pane.add(ResourcePanel, c);
	    pane.add(ResourcePanel);
	    TotalPanel.add(ResourcePanel);
	    
	    //midterste side
	    
	    JPanel Panel2 = new JPanel(new GridLayout(0,2));
	    Panel2.setBorder(BorderFactory.createLineBorder(Color.black));
	    for ( int x = 0 ; x < 13 ; x++ ) {
	    	Tekst1 = new JLabel(Array_Land[x].HentNavn());
			c.gridx = 5;
			c.gridy = 0+x;
			//pane.add(Tekst1, c);
			Panel2.add(Tekst1);
			Tekst1 = new JLabel( 0+"" );
			c.gridx = 6;
			c.gridy = 0+x;
			//pane.add(Tekst2, c);
			Panel2.add(Tekst1);
	    }
	    //pane.add(Panel2, c);
	    pane.add(Panel2);
	    TotalPanel.add(Panel2);
	    
	    JPanel Panel3 = new JPanel(new GridLayout(0,1));
	    Panel3.setBorder(BorderFactory.createLineBorder(Color.black));
	    for ( int x = 0 ; x < 24 ; x++ ) {
	    	//Tekst1 = new JLabel(Array_ByggTyper[x].HentNavn());
	    	Knapp =  new JButton(Array_ByggTyper[x].HentNavn());
	    	Knapp.setActionCommand(Array_ByggTyper[x].HentNavn());
	    	Knapp.addActionListener(this);
			c.gridx = 8;
			c.gridy = 0+x;
			//c.gridwidth = 1;
			//pane.add(Tekst1, c);
			//pane.add(Knapp, c);
			Panel3.add(Knapp);
	    }
	    //pane.add(Panel3, c);
	    pane.add(Panel3);
	    TotalPanel.add(Panel3);
	    
	    /*
	    Tekst1 = new JLabel("Liste over bygninger her");
	    c.gridx = 2;
		c.gridy = 13;
		c.gridwidth = 2;
		pane.add(Tekst1, c);
		*/
	    
	    //Tekst1 = new JLabel("Info om bygning som bygges her");
	    //Tekst3 = new JTextArea("Info om bygning som bygges her"); 
	    //Tekst3.setLineWrap(true);
		//Tekst3.setWrapStyleWord(true);
	    JPanel Panel4 = new JPanel(new GridLayout(0,1));
	    Panel4.setBorder(BorderFactory.createLineBorder(Color.black));
	    BygningsNavn = new JLabel("Navnet");
	    c.gridx = 10;
		c.gridy =0;
		//c.gridwidth = 2;
		//pane.add(Tekst3, c);
		//pane.add(Tekst1, c);
		//pane.add(BygningsNavn, c);
		Panel4.add(BygningsNavn);
	    BygningsInfo =  new JTextArea("Beskrivelse",5, 20 ) ;
	    //BygningsInfo =  new JTextArea("Here your workers can get stone for your settlement. Stone is needed for making bricks, which is needed for building any building. You NEED this building.",11, 1 ) ;
	    BygningsInfo.setLineWrap(true);
		BygningsInfo.setWrapStyleWord(true);
	    c.gridx = 10;
		c.gridy =1;
		c.gridheight=3; 
		//c.gridwidth = 2;
		//pane.add(BygningsInfo, c);
		Panel4.add(BygningsInfo);
	    BygningsLevel = new JLabel("Level") ;
	    c.gridx = 10;
		c.gridy =3;
		//pane.add(BygningsLevel, c);
		Panel4.add(BygningsLevel);
	    ByggingsTid = new JLabel("Byggetid") ;
	    c.gridx = 20;
		c.gridy =4;
		//pane.add(ByggingsTid, c);
		Panel4.add(ByggingsTid);
		//Råvare krevd #1
	    ByggingsRaavare1 = new JLabel("") ;
	    c.gridx = 10;
		c.gridy =5;
		//pane.add(ByggingsRaavare1, c);
		Panel4.add(ByggingsRaavare1);
		//Mengde råvare krevd #1
	    ByggingsRaavareTall1 = new JLabel("") ;
	    c.gridx = 10;
		c.gridy =6;
		//pane.add(ByggingsRaavareTall1, c);
		Panel4.add(ByggingsRaavareTall1);
		//Råvare krevd #2
		ByggingsRaavare2 = new JLabel("") ;
	    c.gridx = 10;
		c.gridy =6;
		//pane.add(ByggingsRaavare2, c);
		Panel4.add(ByggingsRaavare2);
		//Mengde råvare krevd #2
	    ByggingsRaavareTall2 = new JLabel("") ;
	    c.gridx = 10;
		c.gridy =8;
		//pane.add(ByggingsRaavareTall2, c);
		Panel4.add(ByggingsRaavareTall2);
		ByggingBricks = new JLabel("Bricks needed:") ;
	    c.gridx = 10;
		c.gridy =7;
		//pane.add(ByggingBricks, c);
		Panel4.add(ByggingBricks);
		ByggingLumber = new JLabel("Lumber needed:") ;
	    c.gridx = 10;
		c.gridy =8;
		//pane.add(ByggingLumber, c);
		Panel4.add(ByggingLumber);
		ByggingTools = new JLabel("Tools needed:") ;
	    c.gridx = 10;
		c.gridy =9;
		//pane.add(ByggingTools, c);
		Panel4.add(ByggingTools);
		ByggingLand = new JLabel("Land type needed:") ;
	    c.gridx = 10;
		c.gridy =10;
		//pane.add(ByggingLand, c);
		Panel4.add(ByggingLand);
		ByggingProdukt = new JLabel("Resource produced:") ;
	    c.gridx = 10;
		c.gridy =11;
		//pane.add(ByggingProdukt, c);
		Panel4.add(ByggingProdukt);
		
		//pane.add(Panel4, c);
		pane.add(Panel4);
		TotalPanel.add(Panel4);
		
		//høyre side
		JPanel Panel5 = new JPanel(new GridLayout(0,2));
	    Panel5.setBorder(BorderFactory.createLineBorder(Color.black));
		
	    Tekst1 = new JLabel("Knapper til andre vinduer");
	    c.gridx = 12;
		c.gridy = 0;
		//pane.add(Tekst1, c);
		Panel5.add(Tekst1);
	    
	    Tekst1 = new JLabel("Info på game status her");
	    c.gridx = 12;
		c.gridy = 1;
		//pane.add(Tekst1, c);
		Panel5.add(Tekst1);
	    
	    Tekst1 = new JLabel("Meldinger om div her");
	    c.gridx = 12;
		c.gridy = 2;
		//pane.add(Tekst1, c);
		Panel5.add(Tekst1);
		
		//pane.add(Panel5, c);
		pane.add(Panel5);
		TotalPanel.add(Panel5);
		
		/*
		SpringUtilities.makeCompactGrid(pane, //parent
                3, 3, //rows, collumns
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
        */
		int x = 2;
		SpringUtilities.makeCompactGrid(TotalPanel, //parent
                1, 6, //rows, collumns
                x, x,  //initX, initY
                x, x); //xPad, yPad
		
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("SpringCompactGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TotalPanel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(TotalPanel);

        frame.pack();
        frame.setVisible(true);
		
	}
	
    public void actionPerformed(ActionEvent e) {
    	//System.out.println(e);
    	
	    for ( int x = 0 ; x < 24 ; x++ ) {
	    	if ( e.getActionCommand().equals(Array_ByggTyper[x].HentNavn()) ) {
	    		//System.out.println("pling: " + x + " " + Array_ByggTyper[x].HentNavn());
	    		BygningsNavn.setText(Array_ByggTyper[x].HentNavn());
	    		BygningsInfo.setText(Array_ByggTyper[x].HentInfo());
	    		int Level = (Array_Bygg[x].HentLevel());
	    		//Level =Level + 1;
	    		BygningsLevel.setText("Level: " + (Level+1));
	    		//ByggingsTid.setText("Buildingtime: " + 100*((1.5^(Level-1))));
	    		int Temp = 100;
	    		Temp = (int)(Temp * (Math.pow(1.5,(Level))));
	    		//System.out.println(Math.pow(2,3));
	    		ByggingsTid.setText("Buildingtime: " + Temp);
	    		Temp = (int)(25 * (Math.pow(1.5,(Level))));
	    		ByggingBricks.setText("Bricks needed: " + Temp);
	    		Temp = (int)(25 * (Math.pow(1.5,(Level))));
	    		ByggingLumber.setText("Lumber needed: " + Temp);
	    		Temp = (int)(25 * (Math.pow(1.5,(Level))));
	    		ByggingTools.setText("Tools needed: " + Temp);
	    		Temp = (int)(25 * (Math.pow(1.5,(Level))));
	    		ByggingLand.setText("Land type needed: " + Array_ByggTyper[x].HentLand().HentNavn() + " ("+(Level+1)+")");
	    		Temp = (int)(5 * (Math.pow(1.5,(Level))));
	    		ByggingProdukt.setText("resource produced: " + Array_ByggTyper[x].HentProdukt().HentNavn() + " ("+Temp+")");
	    		Temp = (int)(5 * (Math.pow(1.5,(Level))));
	    		if (Array_ByggTyper[x].HentRaavaren1() == null){
	    			ByggingsRaavare1.setText("");
	    			ByggingsRaavareTall1.setText("");
	    		} else {
	    			//ByggingsRaavare1.setText(Array_ByggTyper[x].HentRaavaren1().HentNavn());
	    			//ByggingsRaavareTall1.setText((5)+"");
	    			ByggingsRaavare1.setText(Array_ByggTyper[x].HentRaavaren1().HentNavn() + ": " + Temp);
	    		}
	    		if (Array_ByggTyper[x].HentRaavaren2() == null){
	    			ByggingsRaavare2.setText("");
	    			ByggingsRaavareTall2.setText("");
	    		} else {
	    			//ByggingsRaavare2.setText(Array_ByggTyper[x].HentRaavaren2().HentNavn());
	    			//ByggingsRaavareTall2.setText((5)+"");
	    			ByggingsRaavare2.setText(Array_ByggTyper[x].HentRaavaren2().HentNavn() + ": " + Temp);
	    		}
	    		//ByggingsRaavareTall;
	    	}
	    }
	    /*
    	if ( e.getActionCommand().equals("Action") ) {
        	if ( Action.getText().equals(RegBil) ) {
        		//RegistrerBil();
        	}
        } else if ( e.getActionCommand().equals(RegBil) ) {
        	/*
    		Action.setText(e.getActionCommand());
        	EierNavn.setVisible(true);
    	    EierAdresse.setVisible(true);
    	    EierNummer.setVisible(true);
    	    BilNummer.setVisible(true);
    	    BilMerkeType.setVisible(true);
    	    BilRegistrert.setVisible(true);
    	    Utskrift.setVisible(true);
    	    Action.setVisible(true);
    	    Line1.setVisible(true);
    	    Line2.setVisible(true);
    	    Line3.setVisible(true);
    	    Line4.setVisible(true);
    	    Line5.setVisible(true);
    	    EierNummeret.setVisible(true);
    	    Line6.setVisible(true);
    	    Line7.setVisible(true);
    	    Line8.setVisible(true);
    	    Utskrift.setText("");
    	    
    	}*/
    
    }

}
