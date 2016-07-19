package Model;
public class Object_BuildingType {
    String BygningsNavn;
    String BygningsInfo;
    public Object_Resource ByggingsRaavare1;
    public Object_Resource ByggingsRaavare2;
    Object_Resource ProdusertVare;
    public Object_Landtypes BuildSpot;
    int BaseRawMaterialsNeeded = 5;
    int BaseBuildingTime = 100;
    int BaseBricksNeeded = 25;
    int BaseLumberNeeded = 25;
    int BaseToolsNeeded = 25;
    double RawMaterialsIncrement = 50;
    double BuildingTimeIncrement = 50;
    double BricksNeededIncrement = 50;
    double LumberNeededIncrement = 50;
    double ToolsNeededIncrement = 50;
    public double Factor;
    public Object_BuildingType(String A, String B, Object_Resource C, Object_Resource D, Object_Landtypes E, Object_Resource F, double G) {
	BygningsNavn = A;
	BygningsInfo = B;
	ByggingsRaavare1 = C;
	ByggingsRaavare2 = D;
	BuildSpot = E;
	ProdusertVare = F;
	Factor = G;
    }
    public String HentNavn() {
	return BygningsNavn;
    }
    public String HentInfo() {
	return BygningsInfo;
    }
    public Object_Resource HentRaavaren1() {
	return ByggingsRaavare1;
    }
    public Object_Resource HentRaavaren2() {
	return ByggingsRaavare2;
    }
    public Object_Landtypes HentLand() {
	return BuildSpot;
    }
    public Object_Resource HentProdukt() {
	return ProdusertVare;
    }
}
