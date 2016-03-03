
public class sampleSubClass implements Interface2,Interface1{
	public static void main(String args[]){
		sampleSubClass t = new sampleSubClass();
		t.sampleMethod1();
	}
	@Override
	public void sampleMethod1(){
		System.out.println("sample Method 1");
	}
	@Override
	public void sampleMethod2(){
		System.out.println("sample Method 2");
	}
	
	public void sampleMethod3(){
		
	}
}
