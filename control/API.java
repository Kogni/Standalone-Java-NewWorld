package control;
import GUI.GUI_Controller;

public class API {
    Brain_Main Class_Brain_Main = new Brain_Main(this);
    GUI_Controller gui_Controller = new GUI_Controller(this);
    public void GUI_Start() {
	gui_Controller.SettOppGUI();
    }
    
    public void GUI_LabelUpdate_Expedition(String tekst){
	gui_Controller. LabelUpdate_Expedition(tekst);
    }
}
