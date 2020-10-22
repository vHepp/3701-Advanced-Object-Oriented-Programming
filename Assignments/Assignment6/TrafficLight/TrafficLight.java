public enum TrafficLight{
	RED(50),
	YELLOW(5),
	GREEN(40);
	
	
	private final int duration;
	
	TrafficLight(int durationSeconds) {
		duration = durationSeconds;
		
	}
	
	public int getDuration()
	{
		return duration;
	}
}