package API;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import GUI.frame_Main2;
import Model.Object_Building;
import Model.Object_BuildingType;
import Model.Object_Landtypes;
import Model.Object_Resource;

public class Brain_Main {
    Object_Resource[] Array_Resources = new Object_Resource[24];
    Object_Landtypes[] Array_Land = new Object_Landtypes[13];
    Object_BuildingType[] Array_ByggTyper = new Object_BuildingType[99];
    Object_Building[] Array_Bygg = new Object_Building[99];
    private frame_Main2 Class_GUI_Main2;
    @SuppressWarnings("unused")
    private Brain_Resources Class_Brain_Resources;
    int Population = 50;
    int Bygningsantall;
    public Brain_Main() {
	// System.out.println("hmz2");
	SettOppResursser();
	SettOppLand();
	SettOppByggTyper();
	SettOppBygninger();
	SettOppGUI();
	Class_Brain_Resources = new Brain_Resources();
	Timeren();
    }
    public void SettOppResursser() {
	Object_Resource Object_Stone = new Object_Resource("Stone", 0);
	Array_Resources[0] = Object_Stone;
	Object_Resource Object_Bricks = new Object_Resource("Bricks", 100);
	Array_Resources[1] = Object_Bricks;
	Object_Resource Object_Wood = new Object_Resource("Wood", 0);
	Array_Resources[2] = Object_Wood;
	Object_Resource Object_Lumber = new Object_Resource("Lumber", 100);
	Array_Resources[3] = Object_Lumber;
	Object_Resource Object_IronOre = new Object_Resource("Iron Ore", 0);
	Array_Resources[4] = Object_IronOre;
	Object_Resource Object_IronBars = new Object_Resource("Iron Bars", 0);
	Array_Resources[5] = Object_IronBars;
	Object_Resource Object_Coal = new Object_Resource("Coal", 0);
	Array_Resources[6] = Object_Coal;
	Object_Resource Object_Tools = new Object_Resource("Tools", 1000);
	Array_Resources[7] = Object_Tools;
	Object_Resource Object_Guns = new Object_Resource("Guns", 0);
	Array_Resources[8] = Object_Guns;
	Object_Resource Object_Copper = new Object_Resource("Copper", 0);
	Array_Resources[9] = Object_Copper;
	Object_Resource Object_Tin = new Object_Resource("Tin", 0);
	Array_Resources[10] = Object_Tin;
	Object_Resource Object_Bronze = new Object_Resource("Bronze", 0);
	Array_Resources[11] = Object_Bronze;
	Object_Resource Object_Wool = new Object_Resource("Wool", 0);
	Array_Resources[12] = Object_Wool;
	Object_Resource Object_Cloth = new Object_Resource("Cloth", 0);
	Array_Resources[13] = Object_Cloth;
	Object_Resource Object_Meat = new Object_Resource("Meat", 150);
	Array_Resources[14] = Object_Meat;
	Object_Resource Object_Fish = new Object_Resource("Fish", 150);
	Array_Resources[15] = Object_Fish;
	Object_Resource Object_Vegetables = new Object_Resource("Vegetables", 150);
	Array_Resources[16] = Object_Vegetables;
	Object_Resource Object_Horses = new Object_Resource("Horses", 0);
	Array_Resources[17] = Object_Horses;
	Object_Resource Object_Spices = new Object_Resource("Spices", 0);
	Array_Resources[18] = Object_Spices;
	Object_Resource Object_ExoticPets = new Object_Resource("Exotic Pets", 0);
	Array_Resources[19] = Object_ExoticPets;
	Object_Resource Object_Slaves = new Object_Resource("Slaves", 0);
	Array_Resources[20] = Object_Slaves;
	Object_Resource Object_Silver = new Object_Resource("Silver", 0);
	Array_Resources[21] = Object_Silver;
	Object_Resource Object_Gold = new Object_Resource("Gold", 0);
	Array_Resources[22] = Object_Gold;
	Object_Resource Object_Gem = new Object_Resource("Gem", 0);
	Array_Resources[23] = Object_Gem;
    }
    public void SettOppLand() {
	Object_Landtypes Object_Grassland = new Object_Landtypes("Grassland", 0);
	Array_Land[0] = Object_Grassland;
	Array_Land[0].LandStorage = 2;
	Object_Landtypes Object_Plain = new Object_Landtypes("Plain", 0);
	Array_Land[1] = Object_Plain;
	Object_Landtypes Object_Quarry = new Object_Landtypes("Quarry", 0);
	Array_Land[2] = Object_Quarry;
	Array_Land[2].LandStorage = 1;
	Object_Landtypes Object_Forest = new Object_Landtypes("Forest", 0);
	Array_Land[3] = Object_Forest;
	Array_Land[3].LandStorage = 1;
	Object_Landtypes Object_Shore = new Object_Landtypes("Shore", 0);
	Array_Land[4] = Object_Shore;
	Object_Landtypes Object_IronVein = new Object_Landtypes("Iron Vein", 0);
	Array_Land[5] = Object_IronVein;
	Object_Landtypes Object_CopperVein = new Object_Landtypes("Copper Vein", 0);
	Array_Land[6] = Object_CopperVein;
	Object_Landtypes Object_TinDeposit = new Object_Landtypes("Tin Deposit", 0);
	Array_Land[7] = Object_TinDeposit;
	Object_Landtypes Object_CoalDeposit = new Object_Landtypes("Coal Deposit", 0);
	Array_Land[8] = Object_CoalDeposit;
	Object_Landtypes Object_GoldVein = new Object_Landtypes("Gold Vein", 0);
	Array_Land[9] = Object_GoldVein;
	Object_Landtypes Object_SilverVein = new Object_Landtypes("Silver Vein", 0);
	Array_Land[10] = Object_SilverVein;
	Object_Landtypes Object_GemDeposit = new Object_Landtypes("Gem Deposit", 0);
	Array_Land[11] = Object_GemDeposit;
	Object_Landtypes Object_NativeCamp = new Object_Landtypes("Native Camp", 0);
	Array_Land[12] = Object_NativeCamp;
    }
    public void SettOppByggTyper() {
	Object_BuildingType Object_StoneCutter = new Object_BuildingType("Stone Cutter",
		"Here your workers can get stone for your settlement. Stone is needed for making bricks, which is needed for building any building. You NEED this building.",
		null, null, Array_Land[2], Array_Resources[0], 0.5);
	Array_ByggTyper[0] = Object_StoneCutter;
	Object_BuildingType Object_Quarry = new Object_BuildingType("Quarry",
		"Here you can get bricks for your settlement. Bricks are needed for building any building. You NEED this building.",
		Array_Resources[0], null, Array_Land[0], Array_Resources[1], 0.5);
	Array_ByggTyper[1] = Object_Quarry;
	Object_BuildingType Object_WoodCutter = new Object_BuildingType("Wood Cutter",
		"Here your workers can get wood for your settlement. Wood is needed for making lumber, which is needed for building any building. You NEED this building.",
		null, null, Array_Land[3], Array_Resources[2], 0.5);
	Array_ByggTyper[2] = Object_WoodCutter;
	Object_BuildingType Object_LumberMill = new Object_BuildingType("Lumber Mill",
		"Here you can get lumber for your settlement. Bricks are needed for building any building. You NEED this building.",
		Array_Resources[2], null, Array_Land[0], Array_Resources[3], 0.5);
	Array_ByggTyper[3] = Object_LumberMill;
	Object_BuildingType Object_Weaponry = new Object_BuildingType("Weaponry",
		"An armoursmith will make guns from ironbars, which can be used for defending and attacking or sold in Europe.",
		Array_Resources[5], Array_Resources[6], Array_Land[0], Array_Resources[8], 1);
	Array_ByggTyper[4] = Object_Weaponry;
	Object_BuildingType Object_ToolMaker = new Object_BuildingType("Tool Maker",
		"A toolmaker will turn iron into tools. Tools are needed for building any building, and with a toolmaker you dont have to buy all the tools from Europe.",
		Array_Resources[5], Array_Resources[6], Array_Land[0], Array_Resources[7], 1);
	Array_ByggTyper[5] = Object_ToolMaker;
	Object_BuildingType Object_CopperMine = new Object_BuildingType("Copper Mine",
		"Copper and tin can be used to make bronze, which you can sell in Europe", null, null, Array_Land[6], Array_Resources[9],
		1);
	Array_ByggTyper[6] = Object_CopperMine;
	Object_BuildingType Object_TinMine = new Object_BuildingType("Tin Mine",
		"Copper and tin can be used to make bronze, which you can sell in Europe", null, null, Array_Land[7], Array_Resources[10],
		1);
	Array_ByggTyper[7] = Object_TinMine;
	Object_BuildingType Object_BronzeWorks = new Object_BuildingType("Bronze Works",
		"With a supply of copper and tin, you can smelt them into bronze, which you can sell in Europe", Array_Resources[9],
		Array_Resources[10], Array_Land[0], Array_Resources[11], 1);
	Array_ByggTyper[8] = Object_BronzeWorks;
	Object_BuildingType Object_CoalMine = new Object_BuildingType("Coal Mine", "Coal and Iron is used to make weapons and tools", null,
		null, Array_Land[8], Array_Resources[6], 2);
	Array_ByggTyper[9] = Object_CoalMine;
	Object_BuildingType Object_IronMine = new Object_BuildingType("Iron Mine",
		"An iron mine is a good investment. Iron can be melted into tools, which you need to build any building. With an iron mine and a tool maker, you dont have to buy tools from Europe.",
		null, null, Array_Land[5], Array_Resources[4], 1);
	Array_ByggTyper[10] = Object_IronMine;
	Object_BuildingType Object_IronWorks = new Object_BuildingType("Iron Works",
		"With a supply of iron and coal, you can smelt them into iron bars, which you can make guns and tools from.",
		Array_Resources[4], Array_Resources[6], Array_Land[0], Array_Resources[5], 1);
	Array_ByggTyper[11] = Object_IronWorks;
	Object_BuildingType Object_SheepRanch = new Object_BuildingType("Sheep Ranch", "Wool is used to make cloth", null, null,
		Array_Land[0], Array_Resources[12], 1);
	Array_ByggTyper[12] = Object_SheepRanch;
	Object_BuildingType Object_WeaversHouse = new Object_BuildingType("Weaver's House",
		"Cloth is made from wool, and can be sold in Europe", Array_Resources[12], null, Array_Land[0], Array_Resources[13], 1);
	Array_ByggTyper[13] = Object_WeaversHouse;
	Object_BuildingType Object_HuntersLodge = new Object_BuildingType("Hunter's Lodge",
		"Meat can bea eaten by your population or sold in Europe", null, null, Array_Land[3], Array_Resources[14], 0.5);
	Array_ByggTyper[14] = Object_HuntersLodge;
	Object_BuildingType Object_Fisherhut = new Object_BuildingType("Fisherhut",
		"Fish can bea eaten by your population or sold in Europe", null, null, Array_Land[4], Array_Resources[15], 0.5);
	Array_ByggTyper[15] = Object_Fisherhut;
	Object_BuildingType Object_Farm = new Object_BuildingType("Farm", "Vegetables can bea eaten by your population or sold in Europe",
		null, null, Array_Land[0], Array_Resources[16], 0.5);
	Array_ByggTyper[16] = Object_Farm;
	Object_BuildingType Object_Stables = new Object_BuildingType("Stables",
		"Stables will make your horses reproduce at a slow rate. Horses can be sold or used by your soldiers to fight.", null, null,
		Array_Land[0], Array_Resources[17], 1);
	Array_ByggTyper[17] = Object_Stables;
	Object_BuildingType Object_PetHuntersLodge = new Object_BuildingType("Pet Hunter's Lodge",
		"The new world is filled with exotic animals, and the rich people in Europe are certain to want one of them.", null, null,
		Array_Land[3], Array_Resources[19], 0.6);
	Array_ByggTyper[18] = Object_PetHuntersLodge;
	Object_BuildingType Object_SlaveMarket = new Object_BuildingType("Slave Market", "Slaves can be sold in Europe", null, null,
		Array_Land[12], Array_Resources[20], 0.4);
	Array_ByggTyper[19] = Object_SlaveMarket;
	Object_BuildingType Object_SpicePlantation = new Object_BuildingType("Spice Plantation", "Spices can be sold in Europe", null, null,
		Array_Land[1], Array_Resources[18], 0.5);
	Array_ByggTyper[20] = Object_SpicePlantation;
	Object_BuildingType Object_SilverMine = new Object_BuildingType("Silver Mine", "Silver can be sold in Europe", null, null,
		Array_Land[10], Array_Resources[21], 0.3);
	Array_ByggTyper[21] = Object_SilverMine;
	Object_BuildingType Object_GoldMine = new Object_BuildingType("Gold Mine", "Gold can be sold in Europe", null, null, Array_Land[9],
		Array_Resources[22], 0.2);
	Array_ByggTyper[22] = Object_GoldMine;
	Object_BuildingType Object_GemMine = new Object_BuildingType("Gem Mine", "Gems can be sold in Europe", null, null, Array_Land[11],
		Array_Resources[23], 0.1);
	Array_ByggTyper[23] = Object_GemMine;
	Object_BuildingType Object_Warehouse = new Object_BuildingType("Warehouse", "Upgrade to increase your maximum resource count.",
		null, null, Array_Land[0], null, 0);
	Array_ByggTyper[24] = Object_Warehouse;
	Bygningsantall = 24;
    }
    public void SettOppBygninger() {
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    Object_Building Building1 = new Object_Building(Array_ByggTyper[x].HentNavn(), 0, Array_ByggTyper[x].Factor);
	    Array_Bygg[x] = Building1;
	    Array_Bygg[x].SettProdukt(Array_ByggTyper[x].HentProdukt());
	    Array_Bygg[x].Raw1 = Array_ByggTyper[x].ByggingsRaavare1;
	    Array_Bygg[x].Raw2 = Array_ByggTyper[x].ByggingsRaavare2;
	}
    }
    public Object_Resource[] HentResursser() {
	return Array_Resources;
    }
    public void SettOppGUI() {
	Class_GUI_Main2 = new frame_Main2();
	Class_GUI_Main2.SettOpp(Array_Resources, Array_Land, Array_ByggTyper, Array_Bygg, Bygningsantall);
	Class_GUI_Main2.setControl(this);

	Class_GUI_Main2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void RedrawGUI() {
	Class_GUI_Main2.pane.removeAll();
	Class_GUI_Main2.LagGUI();
    }
    public void LandGained() {
	int chances = 0;
	// 'gem deposits 1
	chances = 1;
	// 'gold veins 3
	chances = chances + 2;
	// 'silver veins 7
	chances = chances + 4;
	// 'iron veins 15
	chances = chances + 8;
	// 'coal deposits 31
	chances = chances + 16;
	// 'tin deposists 47
	chances = chances + 16;
	// 'plains 63
	chances = chances + 16;
	// 'copper veins 87
	chances = chances + 24;
	// 'natives 119
	chances = chances + 32;
	// 'quarries 151
	chances = chances + 32;
	// 'shores 183
	chances = chances + 32;
	// 'forests 231
	chances = chances + 48;
	// 'grasslands 347
	chances = (int) (chances * 1.5);
	int LandNumber = (0) + (int) (Math.random() * chances);
	// System.out.println(LandNumber);
	if (LandNumber == 1) {
	    Array_Land[11].SettStorage(Array_Land[11].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[11].HentNavn());
	} else if (LandNumber <= 3) {
	    Array_Land[9].SettStorage(Array_Land[9].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[9].HentNavn());
	} else if (LandNumber <= 7) {
	    Array_Land[10].SettStorage(Array_Land[10].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[10].HentNavn());
	} else if (LandNumber <= 15) {
	    Array_Land[5].SettStorage(Array_Land[5].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[5].HentNavn());
	} else if (LandNumber <= 31) {
	    Array_Land[8].SettStorage(Array_Land[8].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[8].HentNavn());
	} else if (LandNumber <= 47) {
	    Array_Land[7].SettStorage(Array_Land[7].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[7].HentNavn());
	} else if (LandNumber <= 63) {
	    Array_Land[1].SettStorage(Array_Land[1].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[1].HentNavn());
	} else if (LandNumber <= 87) {
	    Array_Land[6].SettStorage(Array_Land[6].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[6].HentNavn());
	} else if (LandNumber <= 119) {
	    Array_Land[12].SettStorage(Array_Land[12].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[12].HentNavn());
	} else if (LandNumber <= 151) {
	    Array_Land[2].SettStorage(Array_Land[2].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[2].HentNavn());
	} else if (LandNumber <= 183) {
	    Array_Land[4].SettStorage(Array_Land[4].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[4].HentNavn());
	} else if (LandNumber <= 231) {
	    Array_Land[3].SettStorage(Array_Land[3].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[3].HentNavn());
	} else if (LandNumber <= 347) {
	    Array_Land[0].SettStorage(Array_Land[0].HentStorage() + 1);
	    Class_GUI_Main2.ExpeditionTekst.setText("Expedition has found " + Array_Land[0].HentNavn());
	} else {}
	/*
	 * Searching = "Y " & year & " " & month & " : Your expedition team has returned. They have found " & sayland & "!"
	 * landexpedition.Enabled = False
	 */
	for (int x = 0; x < 13; x++) {
	    Class_GUI_Main2.LandTekster[x].setText(Array_Land[x].HentStorage() + "");
	}
    }
    public void ByggBygning() {
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    if (Array_Bygg[x].HentNavn() == Class_GUI_Main2.BygningsNavn.getText()) {
		Array_Bygg[x].SettLevel(Array_Bygg[x].HentLevel() + 1);
		Array_Bygg[x].RawIn1 = (int) (5 * (Math.pow(1.5, (Array_Bygg[x].Level - 1))));
		Array_Bygg[x].RawIn2 = (int) (5 * (Math.pow(1.5, (Array_Bygg[x].Level - 1))));
		Array_Bygg[x].Production = (int) (5 * (Math.pow(1.5, (Array_Bygg[x].Level - 1))));
		Class_GUI_Main2.BygningsKnapper[x].setText(Array_Bygg[x].HentNavn() + " (" + Array_Bygg[x].HentLevel() + ")");
	    }
	}
	for (int z = 0; z < 13; z++) {
	    Class_GUI_Main2.LandTekster[z].setText(Array_Land[z].HentStorage() + "");
	}
    }
    public void SettProduksjon() {
	int Arbeidsplasser = 0;
	int MaxProduction;
	double Factor;
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    Arbeidsplasser = Arbeidsplasser + Array_Bygg[x].Level;
	}
	for (int x = 0; x < Bygningsantall + 1; x++) {
	    if (Array_Bygg[x].Level > 0) {
		Factor = (Population / Arbeidsplasser) * Array_Bygg[x].Level;
		Array_Bygg[x].Production = (int) (5 * (Math.pow(1.5, (Array_Bygg[x].Level - 1))));
		MaxProduction = (int) ((Array_Bygg[x].Production + Array_Bygg[x].Level * 5) * Array_Bygg[x].Factor);
		if (((Array_Bygg[x].Production + Factor) * Array_Bygg[x].Factor) > MaxProduction) {
		    Array_Bygg[x].Production = MaxProduction;
		    Array_Bygg[x].RawIn1 = MaxProduction;
		    Array_Bygg[x].RawIn2 = MaxProduction;
		} else {
		    Array_Bygg[x].Production = (int) ((Array_Bygg[x].Production + Factor) * Array_Bygg[x].Factor);
		    Array_Bygg[x].RawIn1 = (int) ((Array_Bygg[x].Production + Factor) * Array_Bygg[x].Factor);
		    Array_Bygg[x].RawIn2 = (int) ((Array_Bygg[x].Production + Factor) * Array_Bygg[x].Factor);
		}

	    }
	}
	for (int z = 0; z < 13; z++) {
	    Class_GUI_Main2.LandTekster[z].setText(Array_Land[z].HentStorage() + "");
	}
    }
    public void GjørProduksjon() {
	int MaxProduce = 0;
	int MaxLager = 100 + (Array_Bygg[24].Level * 100);
	int NyttAntall;
	// System.out.println("1");
	for (int x = 0; x < Bygningsantall + 1; x++) { // går igjennom råvareproduksjon
	    // System.out.println("2");
	    if (Array_Bygg[x].HentLevel() > 0) {
		// System.out.println("3");
		if (Array_Bygg[x].Raw1 == null) {
		    // System.out.println("4");
		    if (Array_Bygg[x].Product != null) {
			// System.out.println("5");
			Array_Bygg[x].Product.Production = Array_Bygg[x].Production;
			NyttAntall = Array_Bygg[x].Product.ResourceStorage + Array_Bygg[x].Product.Production;
			// System.out.println(NyttAntall + " vs " + MaxLager);
			if (NyttAntall > MaxLager) {
			    NyttAntall = MaxLager;
			}
			Array_Bygg[x].Product.ResourceStorage = NyttAntall;
		    }
		}
	    }
	}
	for (int x = 0; x < Bygningsantall + 1; x++) { // går igjennom sluttproduksjon
	    if (Array_Bygg[x].HentLevel() > 0) {
		if (Array_Bygg[x].Product != null) {
		    if (Array_Bygg[x].Raw1 != null) {
			MaxProduce = 0;
			if (Array_Bygg[x].Raw2 == null) { // krever bare 1 råvare
			    if (Array_Bygg[x].Raw1.ResourceStorage >= Array_Bygg[x].Production) { // det er nok råvarer
				// System.out.println("nok råvarer " + Array_Bygg[x].Raw1.ResourceStorage + " " +
				// Array_Bygg[x].Raw1.ResourceName);
				Array_Bygg[x].Raw1.ResourceStorage = Array_Bygg[x].Raw1.ResourceStorage - Array_Bygg[x].Production;
				Array_Bygg[x].Raw1.Production = Array_Bygg[x].Raw1.Production - Array_Bygg[x].Production;
				NyttAntall = Array_Bygg[x].Product.ResourceStorage + Array_Bygg[x].Production;
				// System.out.println(NyttAntall + " vs " + MaxLager);
				if (NyttAntall > MaxLager) {
				    NyttAntall = MaxLager;
				}
				// Array_Bygg[x].Product.ResourceStorage = NyttAntall;
				Array_Bygg[x].Product.ResourceStorage = NyttAntall;
				// Array_Bygg[x].Product.ResourceStorage = Array_Bygg[x].Product.ResourceStorage +Array_Bygg[x].Production;
				Array_Bygg[x].Product.Production = Array_Bygg[x].Production;
				// System.out.println(Array_Bygg[x].Product.ResourceName + " " + Array_Bygg[x].Product.Production);
			    } else { // for få råvarer tilgjengelig
				MaxProduce = Array_Bygg[x].Raw1.ResourceStorage;
				Array_Bygg[x].Raw1.ResourceStorage = Array_Bygg[x].Raw1.ResourceStorage - MaxProduce;
				Array_Bygg[x].Raw1.Production = Array_Bygg[x].Raw1.Production - MaxProduce;
				NyttAntall = Array_Bygg[x].Product.ResourceStorage + MaxProduce;
				// System.out.println(NyttAntall + " vs " + MaxLager);
				if (NyttAntall > MaxLager) {
				    NyttAntall = MaxLager;
				}
				Array_Bygg[x].Product.ResourceStorage = NyttAntall;
				// Array_Bygg[x].Product.ResourceStorage = Array_Bygg[x].Product.ResourceStorage +MaxProduce;
				Array_Bygg[x].Product.Production = MaxProduce;
				// System.out.println(Array_Bygg[x].Product.ResourceName + " " + Array_Bygg[x].Product.Production + " " +
				// MaxProduce + " " + Array_Bygg[x].Raw1.ResourceStorage);
			    }
			} else { // krever 2 råvarer
				 // System.out.println("Not calculated yet");
			    if (Array_Bygg[x].Raw1.ResourceStorage >= Array_Bygg[x].Production) { // det er nok råvarer
				MaxProduce = Array_Bygg[x].Production;
			    } else {
				MaxProduce = Array_Bygg[x].Raw1.ResourceStorage;
			    }
			    if (Array_Bygg[x].Raw2.ResourceStorage >= MaxProduce) { // det er nok råvarer
				// MaxProduce = Array_Bygg[x].Production;
				// System.out.println("moo");
			    } else {
				MaxProduce = Array_Bygg[x].Raw2.ResourceStorage;
			    }
			    Array_Bygg[x].Raw1.ResourceStorage = Array_Bygg[x].Raw1.ResourceStorage - MaxProduce;
			    Array_Bygg[x].Raw1.Production = Array_Bygg[x].Raw1.Production - MaxProduce;
			    Array_Bygg[x].Raw2.ResourceStorage = Array_Bygg[x].Raw2.ResourceStorage - MaxProduce;
			    Array_Bygg[x].Raw2.Production = Array_Bygg[x].Raw2.Production - MaxProduce;
			    NyttAntall = Array_Bygg[x].Product.ResourceStorage + MaxProduce;
			    // System.out.println(NyttAntall + " vs " + MaxLager);
			    if (NyttAntall > MaxLager) {
				NyttAntall = MaxLager;
			    }
			    Array_Bygg[x].Product.ResourceStorage = NyttAntall;
			    // Array_Bygg[x].Product.ResourceStorage = Array_Bygg[x].Product.ResourceStorage +MaxProduce;
			    Array_Bygg[x].Product.Production = MaxProduce;
			    // System.out.println("Produserer " + Array_Bygg[x].Product.ResourceName + " fra " +
			    // Array_Bygg[x].Raw1.ResourceName + " og " + Array_Bygg[x].Raw2.ResourceName);
			}
		    }
		}
	    }
	}
	for (int x = 0; x < 24; x++) {
	    // System.out.println(x + " = " + Array_Bygg[x].Product.ResourceName);
	    Class_GUI_Main2.ResurssTekster[x].setText(Array_Resources[x].ResourceStorage + "");
	    Class_GUI_Main2.ResurssProduksjon[x].setText(Array_Resources[x].Production + "");
	}
    }
    public void Befolkningsvekst() {
	int Rasjon = (int) (Population / 20);
	if (Rasjon == 0) {
	    Rasjon = 1;
	}
	int MatTilgjengelig = Array_Resources[14].ResourceStorage + Array_Resources[15].ResourceStorage
		+ Array_Resources[16].ResourceStorage;
	int MatProduksjon = Array_Resources[14].Production + Array_Resources[15].Production + Array_Resources[16].Production;
	int NyBefolkning = Population;
	// System.out.println("MatTilgjengelig="+MatTilgjengelig + " MatProduksjon="+MatProduksjon + " Rasjon="+Rasjon);
	if (MatTilgjengelig > Rasjon) {
	    NyBefolkning = NyBefolkning + ((MatTilgjengelig - Rasjon) / 5) + 1;
	    if (NyBefolkning > (Population * 1.1)) {
		NyBefolkning = (int) (Population * 1.05);
	    }
	    for (int x = 0; x < (Rasjon); x++) {
		if (Array_Resources[14].ResourceStorage > 0) {
		    Array_Resources[14].ResourceStorage = Array_Resources[14].ResourceStorage - 1;
		} else if (Array_Resources[15].ResourceStorage > 0) {
		    Array_Resources[15].ResourceStorage = Array_Resources[15].ResourceStorage - 1;
		} else {
		    Array_Resources[16].ResourceStorage = Array_Resources[16].ResourceStorage - 1;
		}
	    }
	    // System.out.println("a");
	    Class_GUI_Main2.PopulationTekst.setText("Befolkningen øker med " + (NyBefolkning - Population));
	} else if (MatTilgjengelig == Rasjon) {
	    Array_Resources[14].ResourceStorage = 0;
	    Array_Resources[15].ResourceStorage = 0;
	    Array_Resources[16].ResourceStorage = 0;
	    // System.out.println("5");
	    Class_GUI_Main2.PopulationTekst.setText("");
	} else {
	    NyBefolkning = NyBefolkning + ((MatTilgjengelig - Rasjon) / 2) - 1;
	    Array_Resources[14].ResourceStorage = 0;
	    Array_Resources[15].ResourceStorage = 0;
	    Array_Resources[16].ResourceStorage = 0;
	    // System.out.println("c");
	    Class_GUI_Main2.PopulationTekst.setText("Befolkningen synker med " + (NyBefolkning - Population));
	}

	if (NyBefolkning >= 1000) {
	    // System.out.println("You win the game");
	    JOptionPane.showMessageDialog(Class_GUI_Main2, "You win the game! :)");
	    System.exit(0);
	    // Class_GUI_Main2.PopulationTekst.setText("You win the game");
	} else if (NyBefolkning < 10) {
	    JOptionPane.showMessageDialog(Class_GUI_Main2, "You lose the game! :(");
	    System.exit(0);
	}
	Population = NyBefolkning;
	Class_GUI_Main2.PopulationSizeTekst.setText("Population: " + Population);
    }
    public void Timeren() {
	int delay = 1; // milliseconds
	ActionListener taskPerformer = new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
		int Add = 10;
		// System.out.println(Class_GUI_Main2.ExpeditionBar.getValue());
		if (Class_GUI_Main2.ExpeditionBar.getValue() != Class_GUI_Main2.ExpeditionBar.getMaximum()) {
		    Class_GUI_Main2.ExpeditionBar.setValue(Class_GUI_Main2.ExpeditionBar.getValue() + Add);
		    // System.out.println("erm");
		} else if (Class_GUI_Main2.ExpeditionGoing == true) { // expedition er nettopp ferdig
		    // System.out.println("Expd ferdig");
		    LandGained();
		    Class_GUI_Main2.ExpeditionGoing = false;
		} else {
		    // System.out.println("hmm");
		}
		if (Class_GUI_Main2.BuildingBar.getValue() != Class_GUI_Main2.BuildingBar.getMaximum()) {
		    Class_GUI_Main2.BuildingBar.setValue(Class_GUI_Main2.BuildingBar.getValue() + Add);
		} else if (Class_GUI_Main2.BuildingGoing == true) { // expedition er nettopp ferdig
		    // System.out.println("Expd ferdig");
		    ByggBygning();
		    SettProduksjon();
		    Class_GUI_Main2.BuildingGoing = false;
		} else {
		    // System.out.println("hmm");
		}
		if (Class_GUI_Main2.ResourceBar.getValue() != Class_GUI_Main2.ResourceBar.getMaximum()) {
		    Class_GUI_Main2.ResourceBar.setValue(Class_GUI_Main2.ResourceBar.getValue() + Add);
		} else {
		    Class_GUI_Main2.ResourceBar.setValue(0);
		    SettProduksjon();
		    GjørProduksjon();
		    Befolkningsvekst();
		    // DelUtResursser();
		}
		if (Class_GUI_Main2.MonthBar.getValue() != Class_GUI_Main2.MonthBar.getMaximum()) {
		    Class_GUI_Main2.MonthBar.setValue(Class_GUI_Main2.MonthBar.getValue() + Add);
		} else {
		    Class_GUI_Main2.MonthBar.setValue(0);
		    if (Class_GUI_Main2.Month.getText().equals("January")) {
			Class_GUI_Main2.Month.setText("February");
		    } else if (Class_GUI_Main2.Month.getText().equals("February")) {
			Class_GUI_Main2.Month.setText("March");
		    } else if (Class_GUI_Main2.Month.getText().equals("March")) {
			Class_GUI_Main2.Month.setText("April");
		    } else if (Class_GUI_Main2.Month.getText().equals("April")) {
			Class_GUI_Main2.Month.setText("May");
		    } else if (Class_GUI_Main2.Month.getText().equals("May")) {
			Class_GUI_Main2.Month.setText("June");
		    } else if (Class_GUI_Main2.Month.getText().equals("June")) {
			Class_GUI_Main2.Month.setText("July");
		    } else if (Class_GUI_Main2.Month.getText().equals("July")) {
			Class_GUI_Main2.Month.setText("August");
		    } else if (Class_GUI_Main2.Month.getText().equals("August")) {
			Class_GUI_Main2.Month.setText("September");
		    } else if (Class_GUI_Main2.Month.getText().equals("September")) {
			Class_GUI_Main2.Month.setText("October");
		    } else if (Class_GUI_Main2.Month.getText().equals("October")) {
			Class_GUI_Main2.Month.setText("November");
		    } else if (Class_GUI_Main2.Month.getText().equals("November")) {
			Class_GUI_Main2.Month.setText("December");
		    } else if (Class_GUI_Main2.Month.getText().equals("December")) {
			Class_GUI_Main2.Month.setText("January");
		    }
		}
	    }
	};
	new Timer(delay, taskPerformer).start();
    }
}