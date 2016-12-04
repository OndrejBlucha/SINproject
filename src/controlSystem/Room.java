package controlSystem;

public class Room {
	private int ID;
	private String name;
	//private Shape shape;
	private double area;  // in square metr
	//private String status;
	//private Sensor[] sensors;
	private double lastCleaning;
	private int personsInside;
//	private boolean cleaned;
	private RoomStatus status;
	
	
	public Room () {
		
	}
	
	
	public void cleaned (double time) {
		lastCleaning = time;
		status = RoomStatus.CLEANED;
	}
	
	public void upPersonsInside () {
		personsInside++; 
		if (status == RoomStatus.CLEANED)
		{
			status = RoomStatus.DIRTY;
		}
	}
	
	public void downPersonsInside () {
		if (personsInside > 0) {
			personsInside--;
		}
	}
	
	public void setStatus (RoomStatus status){
		this.status = status;
	}
	
	
	public int getID () {
		return ID;
	}
	
	public String getName () {
		return name;
	}
	
	public double getArea () {
		return area;
	}
	
	public double getLastCleaning () {
		return lastCleaning;
	}
	
	public int getPersonsInside () {
		return personsInside;
	}
	
	
	public boolean isEmpty () {
		if (personsInside == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public RoomStatus getStatus(){
		return status;
	}
	
/*	public boolean isCleaned () {
		return cleaned;
	}*/
	
}
