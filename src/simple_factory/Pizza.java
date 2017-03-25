package simple_factory;

public abstract class Pizza {
	String description;
	
	public Pizza(){
		description = "Pizza";
	}
	
	void prepare(){
		System.out.println("Preparing...");
		this.description += ", prepared";
	}
	
	void bake(){
		System.out.println("Baking...");
		this.description += ", baked";
	}
	
	void cut(){
		System.out.println("Cutting the pizza into slices...");
		this.description += ", cut";
	}
	
	void box(){
		System.out.println("Placing into official Pizza Box...");
		this.description += ", with box now";
	}
	
}
