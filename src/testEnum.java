
public enum testEnum {
	adi(3),ana(6);
	private testEnum(final int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	public int id; 
	public int getId(){
		return id;
	}
	public static boolean contains(int id){
		for(testEnum t : testEnum.values()){
			if(t.getId()==id)
				return true;
		}
		return false;
	}
}
