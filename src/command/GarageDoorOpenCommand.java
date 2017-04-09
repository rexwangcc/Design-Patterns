package command;

public class GarageDoorOpenCommand implements Command{
	GarageDoor garagedoor;
	
	public GarageDoorOpenCommand(GarageDoor garagedoor){
		this.garagedoor = garagedoor;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garagedoor.up();
		garagedoor.stop();
		garagedoor.lightOn();
		garagedoor.down();
		garagedoor.lightOff();
	}
	
}
