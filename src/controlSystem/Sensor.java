package controlSystem;

public class Sensor {
	private int ID;
	private String name;
	private String type;
	private float value;
	
	public Sensor () {
		
	}
	
	
	public void setValue (float value) {
		this.value = value;
	}
	
	
	public int getID () {
		return ID;
	}
	
	public String getName () {
		return name;
	}
	
	public String getType () {
		return type;
	}
	
	public float getValue () {
		return value;
	}
	
}
