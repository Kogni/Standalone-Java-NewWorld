
public class Object_Building {
	String BygningsNavn;
	Object_Resource Product;
	int RawIn1 = 0;
	Object_Resource Raw1;
	int RawIn2 = 0;
	Object_Resource Raw2;
	int Production = 0;
	int Net = 0;
	int Level;
	double Factor;
	
	public Object_Building( String A, int B, double D){
		BygningsNavn = A;
		Level = B;
		Factor = D;
	}
	
	public void SettProdukt(Object_Resource C){
		Product = C;
	}
	
	public String HentNavn(){
		return BygningsNavn;
	}
	
	public int HentLevel(){
		return Level;
	}
	
	public void SettLevel(int B){
		Level =B;
	}
}
