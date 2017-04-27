package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook{

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("Brewing your Coffee...");
	}

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Sugar and Milk...");
	}
	
	public boolean customerWantsCondiments(){
		String answer = getUserInput();
		if(answer.toLowerCase().startsWith("y")){
			return true;
		}else{
			return false;
		}
	}
	
	private String getUserInput(){
		String answer = null;
		
 		System.out.println("Would you like milk and sugar with your coffee [y/n]?");
 		
 		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 		
 		try{
 			answer = input.readLine();
 		}catch(IOException ioerror){
 			System.err.println("IO error trying to read your answer");
 		}
 		
 		if(answer == null){
 			return "No";
 		}
 		return answer;
	}

}
