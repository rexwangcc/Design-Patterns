package command;

public class RemoteControlTest {
	/**
	public static void main(String[] args){
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		// Lights test
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		
		remote.setCommand(lightOff);
		remote.buttonWasPressed();
		
		// Garage test
		GarageDoor garagedoor = new GarageDoor();
		GarageDoorOpenCommand garagedoorOpen = new GarageDoorOpenCommand(garagedoor);
		
		remote.setCommand(garagedoorOpen);
		garagedoorOpen.execute();
	}
	**/
}
