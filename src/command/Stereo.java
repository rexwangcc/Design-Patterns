package command;

public class Stereo {
	String name = "Stereo";
	public Stereo(){
		
	}
	
	public Stereo(String name){
		this.name = name;
	}
	
	public void on(){
		System.out.println(name+ " Stereo ON");
	}
	
	public void off(){
		System.out.println(name+ " Stereo OFF");
	}
	
	public void setCd(){
		System.out.println(name+ " Stereo Set--CD-- ");
	}
	
	public void setDvd(){
		System.out.println(name+ " Stereo Set--DVD-- ");
	}

	public void setRadio(){
		System.out.println(name+ " Stereo Set--Radio-- ");
	}
	
	public void setVolume(int volume){
		System.out.println(name+ " Stereo Set--Volume-- to " + volume);
	}
}
