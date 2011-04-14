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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elvis.INSTANCE.setAge(10);
		System.out.println(Elvis.INSTANCE.getAge());

	}

}
