package tests;

/**
 * purest form of a singleton, no reflection issues nor thread safety issues.
 * @author E15662
 *
 */

public enum Elvis {
	INSTANCE;
	
	private int age;
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int val){
		age = val;
	}
	
	// this needs to be added for normal singleton to prevent instances from deserialization from having a different instance of the singleton.
	// not required for enum singleton. just added to show it is done.
	/*private Object readResolve(){
		return INSTANCE;
	}*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elvis.INSTANCE.setAge(10);
		System.out.println(Elvis.INSTANCE.getAge());
		Elvis.INSTANCE.setAge(20);
		System.out.println(Elvis.INSTANCE.getAge());

		
	}

}
