package observer_java_builtin;

public class WeatherStation {
	public static void main(String[] args){
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 92, 29.2f);
		
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		weatherData.setMeasurements(100, 75, 30.4f);
		weatherData.setMeasurements(100, 85, 31.4f);
		weatherData.setMeasurements(100, 65, 32.4f);
	}
}
