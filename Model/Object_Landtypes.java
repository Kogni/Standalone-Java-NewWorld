package Model;
public class Object_Landtypes {
    private String LandName;
    public int LandStorage;
    public Object_Landtypes(String A, int B) {
	LandName = A;
	LandStorage = B;
    }
    public String HentNavn() {
	return LandName;
    }
    public int HentStorage() {
	return LandStorage;
    }
    public void SettStorage(int B) {
	LandStorage = B;
    }
}
