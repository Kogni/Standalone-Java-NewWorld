public class Object_Resource {

	  String ResourceName;
	  int ResourceStorage;
	  int Production;
	  int Forbruk;
	  
	  public Object_Resource( String A, int B ){
		  ResourceName = A;
		  ResourceStorage = B;
		  Production = 0;
	  }

	  public String HentNavn(){
		  return ResourceName;
	  }
	  
	  public int HentStorage(){
		  return ResourceStorage;
	  }
	  
	  public void SetProduction(int C){
		  Production = C;
	  }
}
