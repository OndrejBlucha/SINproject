package controlSystem;

public class Robot {
	private int ID;
	private String name;
	private int power = 100;
	private RobotStatus status;
	private int currentRoomID;
	private float coordinateX;
	private float coordinateY;
	
	
	public Robot () {
		
	}
	
	

	public void setPower (int power) {
		this.power = power;
	}
	
	public void setStatus (RobotStatus status) {
		this.status = status;
	}
	
	
	public void setCurrentRoomID (int currentRoom) {
		this.currentRoomID = currentRoom;
	}
	
	public void setCoordinate (float coordinateX, float coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public int getID () {
		return ID;
	}
	
	public String getName () {
		return name;
	}
	
	public int getPower () {
		return power;
	}
	
	public RobotStatus getStatus () {
		return status;
	}
	
	public int getCurrentRoom () {
		return currentRoomID;
	}
	
	public float getCoordinateX () {
		return coordinateX;
	}
	
	public float getCoordinateY () {
		return coordinateY;
	}
}
