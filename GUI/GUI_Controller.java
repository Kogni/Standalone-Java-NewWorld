/**
 * @author bls
 *
 */
package GUI;
import javax.swing.JFrame;
import control.API;

public class GUI_Controller {
    API api;
    private Frame_Main Class_GUI_Main2;
    public GUI_Controller(API api) {
	this.api = api;
    }
    public void SettOppGUI() {
	Class_GUI_Main2 = new Frame_Main(api);
	Class_GUI_Main2.SettOpp(Array_Resources, Array_Land, Array_ByggTyper, Array_Bygg, Bygningsantall);
	Class_GUI_Main2.setControl(this);
	Class_GUI_Main2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void RedrawGUI() {
	Class_GUI_Main2.pane.removeAll();
	Class_GUI_Main2.LagGUI();
    }
    public void LabelUpdate_Expedition(String tekst) {
	Class_GUI_Main2.ExpeditionTekst.setText(tekst);
    }
}
