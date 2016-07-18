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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Main extends JFrame implements ActionListener {
	
	private JLabel Tekst1;
	private JTextField Tekst2;
	Object_Resource [] Array_Resources = new Object_Resource[24];
	Object_Landtypes [] Array_Land = new Object_Landtypes[13];
	Object_BuildingType [] Array_ByggTyper = new Object_BuildingType[24];

	public GUI_Main(){
	    super( "Registrering av biler og eiere" );

	}
	
	public void SettOpp(Object_Resource Array_Resources2[], Object_Landtypes Array_Land2[], Object_BuildingType Array_ByggTyper2[]){
		Array_Resources = Array_Resources2;
		Array_Land = Array_Land2;
		Array_ByggTyper = Array_ByggTyper2;
		Container c = getContentPane();

        JPanel MainPanel = new JPanel(new GridBagLayout());
        
        //LEFT PANEL
        JPanel LeftPanel = new JPanel(new GridLayout(0, 1));
        
        JPanel TempSpot = new JPanel(new GridLayout(0, 1));
	    Tekst1 = new JLabel("Ledig plass");
	    TempSpot.add(Tekst1);
	    LeftPanel.add( TempSpot );
	    //MainPanel.add( TempSpot );
	    
	    JPanel ResourcePanel = new JPanel(new GridLayout(0, 1));
	    for ( int x = 0 ; x < 23 ; x++ ) {
	    	JPanel Temp = new JPanel(new GridLayout(0, 2));
	    	//System.out.println(x);
		    Tekst1 = new JLabel(Array_Resources[x].HentNavn());
		    Tekst2 = new JTextField( 3 );
		    Temp.add(Tekst1);
		    Temp.add(Tekst2);
		    ResourcePanel.add( Temp );
	    }
	    LeftPanel.add( ResourcePanel );
	    //MainPanel.add( ResourcePanel );
	    
	    MainPanel.add( LeftPanel );
	    
	    //MIDDLE PANEL
	    JPanel MiddlePanel = new JPanel(new GridLayout(0, 1));
	    
	    JPanel LandPanel = new JPanel(new GridLayout(0, 1));
	    for ( int x = 0 ; x < 12 ; x++ ) {
	    	JPanel Temp = new JPanel(new GridLayout(0, 2));
	    	//System.out.println(x);
		    Tekst1 = new JLabel(Array_Land[x].HentNavn());
		    Tekst2 = new JTextField( 3 );
		    Temp.add(Tekst1);
		    Temp.add(Tekst2);
		    LandPanel.add( Temp );
	    }
	    MiddlePanel.add( LandPanel );
	    //MainPanel.add( LandPanel );
	    
	    JPanel BuildingSpots = new JPanel(new GridLayout(0, 1));
	    for ( int x = 0 ; x < 23 ; x++ ) {
	    	JPanel Temp = new JPanel(new GridLayout(0, 2));
	    	//System.out.println(x);
		    Tekst1 = new JLabel(Array_ByggTyper[x].HentNavn());
		    Tekst2 = new JTextField( 3 );
		    Temp.add(Tekst1);
		    Temp.add(Tekst2);
		    BuildingSpots.add( Temp );
	    }
	    MiddlePanel.add( BuildingSpots );
	    //MainPanel.add( BuildingSpots );
	    
	    JPanel BuildingInfo = new JPanel(new GridLayout(0, 1));
	    Tekst1 = new JLabel("Info om bygning som bygges her");
	    BuildingInfo.add(Tekst1);
	    MiddlePanel.add( BuildingInfo );
	    //MainPanel.add( BuildingInfo );
	    
	    MainPanel.add( MiddlePanel );
	    
	    //RIGHT PANEL
	    JPanel RightPanel = new JPanel(new GridLayout(0, 1));
	    
	    JPanel Overview = new JPanel(new GridLayout(0, 1));
	    Tekst1 = new JLabel("Knapper til andre vinduer");
	    Overview.add(Tekst1);
	    RightPanel.add( Overview );
	    //MainPanel.add( Overview );
	    
	    JPanel Status = new JPanel(new GridLayout(0, 1));
	    Tekst1 = new JLabel("Info på game status her");
	    Status.add(Tekst1);
	    RightPanel.add( Status );
	    //MainPanel.add( Status );
	    
	    JPanel Messages = new JPanel(new GridLayout(0, 1));
	    Tekst1 = new JLabel("Meldinger om div her");
	    Messages.add(Tekst1);
	    RightPanel.add( Messages );
	    //MainPanel.add( Messages );
	    
	    MainPanel.add( RightPanel );
	    
	    c.add( MainPanel );
	    
	    
	    GridBagConstraints Gridbag = new GridBagConstraints();
		Container Innhold = getContentPane();
		Innhold.setLayout(new GridBagLayout());
		
		Innhold.add(MainPanel, Gridbag);
		
		
	    setSize( 600, 900 );
	    setVisible( true );
	}
	
    public void actionPerformed(ActionEvent e) {
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
    	    */
    	}
    }

    
}
