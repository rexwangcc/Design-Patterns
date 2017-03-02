package observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer{
	private float temperature;
	private float humidity;
	//private float pressure;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		// It would be handy if we have a reference to the Subject here to the Subject for unregistering
		this.weatherData = weatherData;
		//Magic of Observer Registration Below!!
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temperature;
		this.humidity = humidity;
		//this.pressure = pressure;
		display();
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("CurrentConditions: " + temperature + "F degress and " + humidity + "% humidity");
	}

}
