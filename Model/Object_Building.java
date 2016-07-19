package Model;
public class Object_Building {
    String BygningsNavn;
    Object_BuildingType type;
    public Object_Resource Product;
    public int RawIn1 = 0;
    public Object_Resource Raw1;
    public int RawIn2 = 0;
    public Object_Resource Raw2;
    public int Production = 0;
    int Net = 0;
    public int Level;
    public double Factor;
    public Object_Building(String A, int B, double D) {
	BygningsNavn = A;
	Level = B;
	Factor = D;
    }
    public void SettProdukt(Object_Resource C) {
	Product = C;
    }
    public String HentNavn() {
	return BygningsNavn;
    }
    public int HentLevel() {
	return Level;
    }
    public void SettLevel(int B) {
	Level = B;
    }
}
