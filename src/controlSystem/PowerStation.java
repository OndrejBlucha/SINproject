package controlSystem;

public class PowerStation {
	private int ID;
	private String name;
	//private Boolean available = true;
	private float coordinateX;
	private float coordinateY;
	private int room;
	private int capacity;
	private int numberOfUsers;
	private int numberOfComeInRobots;

	
	public PowerStation () {
		
	}
	
	
	public void setCoordinate (float coordinateX, float coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public void goRechargeRobot () {
		numberOfComeInRobots++;
	}
	

	
	public void startRechargeRobot () {
		if (numberOfComeInRobots > 0) {
			numberOfComeInRobots--;
		}
		numberOfUsers++;
	}
	
	public void stopRechargeRobot () {
		if (numberOfUsers > 0) {
			numberOfUsers--;
		}
	}
	
	
	public int getID () {
		return ID;
	}
	
	public String getName () {
		return name;
	}
	
	public float getCoordinateX () {
		return coordinateX;
	}
	
	public float getCoordinateY () {
		return coordinateY;
	}
	
	public int getRoom () {
		return room;
	}
	
	public int getCapacity () {
		return capacity;
	}
	
	public int getNumberOfUsers () {
		return numberOfUsers;
	}
	
	public int getNumberOfComeInRobots () {
		return numberOfComeInRobots;
	}
	
	public int getNumberOfAssignRobots () {
		return numberOfUsers + numberOfComeInRobots;
	}
	
	public boolean isFull () {
		if (getNumberOfAssignRobots() < capacity) {
			return false;
		}
		else  {
			return true;
		}
	}
}
