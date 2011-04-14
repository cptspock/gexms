package tests;

public class NutritionFacts {

	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	
	static class Builder{
		//required params
		private final int servingSize;
		private final int servings;
		
		// optional params
		private int calories = 0;
		private int fat = 0;
		
		public Builder(int servingSize, int servings){
			System.out.println("Builder constructor executed");
			this.servingSize = servingSize;
			this.servings = servings;			
		}
		
		public Builder calories(int val){
			calories = val;
			return this;
		}
		
		public Builder fat(int val){
			fat = val;
			return this;
		}
		
		public NutritionFacts build(){
			System.out.println("build() method executed");
			return new NutritionFacts(this);
		}
	}
	
	public NutritionFacts(Builder builder){
		System.out.println("NutritionFacts constructor executed");
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;		
	}
	
	public static void main(String[] args) {	
		NutritionFacts something = new NutritionFacts.Builder(10, 2).fat(3).build(); // note how calories is optional since we're not setting its value
		System.out.println(something.fat);
	}
}
