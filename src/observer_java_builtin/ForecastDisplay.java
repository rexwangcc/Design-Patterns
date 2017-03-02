package observer_java_builtin;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements DisplayElement, Observer{
	private float currentPressure = 29.92f;
	private float lastPressure;
	Observable observable;
	
	public ForecastDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		if (observable instanceof WeatherData){
			WeatherData weatherData = (WeatherData)observable;
			this.lastPressure = this.currentPressure;
			this.currentPressure = weatherData.getPressure();
			this.display();
		}
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Last Pressure: " + lastPressure +'\n'
				+ "CurrentPressure: " + currentPressure);
	}

}
