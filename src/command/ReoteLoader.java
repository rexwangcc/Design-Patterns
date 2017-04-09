package command;

public class ReoteLoader {
	public static void main(String[] args){
		RemoteControl remoteControl = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		
		Stereo stereo = new Stereo("LivingRoom");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOff = new StereoOffWithCDCommand(stereo);
		
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
		
		System.out.println(remoteControl);
		
		remoteControl.onButtionWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtionWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtionWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtionWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		
	}
}
