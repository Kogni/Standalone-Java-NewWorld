package Model;
public class Object_Resource {
    public String ResourceName;
    public int ResourceStorage;
    public int Production;
    int Forbruk;
    public Object_Resource(String A, int B) {
	ResourceName = A;
	ResourceStorage = B;
	Production = 0;
    }
    public String HentNavn() {
	return ResourceName;
    }
    public int HentStorage() {
	return ResourceStorage;
    }
    public void SetProduction(int C) {
	Production = C;
    }
}
