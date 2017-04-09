package command;

public class StereoOffWithCDCommand implements Command{
	Stereo stereo;
	
	public StereoOffWithCDCommand(Stereo stereo){
		this.stereo = stereo;
	}
	
	public void execute(){
		stereo.setVolume(0);
		stereo.off();
	}
}
