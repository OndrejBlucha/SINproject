package controlSystem;

import java.util.ArrayList;
import java.util.List;

public class ControlSystem {
	//private String name;
	private Room[] rooms ;
	private Sensor[] sensors;
	private PowerStation[] powerStations;
	private Robot[] robots;
	
	private List<Room> roomsInQueue = new ArrayList<Room>();
	
	
	public ControlSystem () {
	
	
	}
	
	

	
	/*
	 * Select the closest free robot to room
	 */
	public double selectTheClosestRobot (int roomID) {
		double theClosestLenghtOfWay = 0;
		int theClosestRobots;
		
		for (int i = 0; i < robots.length; i++)
		{
			if (robots[i].getStatus() != RobotStatus.CLEANING || robots[i].getStatus() != RobotStatus.GO_CLEANING) {
				
			}
		}
		
		return 0;
	}
	
	
	/*
	 * Cleaning all not cleaned rooms without people
	 */
	public void bigCleaning () {
		for (int i = 0; i < rooms.length; i++) 
		{
			if (rooms[i].isEmpty() && rooms[i].getStatus() == RoomStatus.DIRTY /*&& (currentTime - rooms[i].getLastCleaning() > minTimeNextCleaning)*/) 
			{
				selectTheClosestRobot (rooms[i].getID());
				
			}
		}
	}
	
	
	/*
	 * Compute length from robot to room
	 */
	public double computeWay (Robot robot, Room room) {
		
		
		return 0;
	}
	
	
	/*
	 * Compute consumption of path plus cleaning consumption
	 */
	public double computeConsumption (double pathLength, Room cleaningRoom) {
		
		
		return pathLength * Constants.movingConsumptionPerMetr + cleaningRoom.getArea() * Constants.cleaningConsumptionPerSquareMetr;
	}
	
	/*
	 * Select the closets power station for robot
	 */
	public double selectTheClosetsPowerStation (Robot robot) {
		return 0;
	}
	
	/*
	 * Select the closest free PowerStation for robot
	 */
	public void goRecharge (int robotID) {
		
	}
	
	/*
	 * Start robot recharge
	 */
	public void startRecharge (int robotID, int powerStationID) {
		robots[getRoboti(robotID)].setStatus(RobotStatus.RECHARGING);
		powerStations[getPowerStationi(powerStationID)].startRechargeRobot();
	}
	
	
	/*
	 * Stop robot recharge
	 */
	public void stopRecharge (int robotID, int powerStationID) {
		robots[getRoboti(robotID)].setStatus(RobotStatus.SLEEPING);
		powerStations[getPowerStationi(powerStationID)].stopRechargeRobot();
	}
	
	/*
	 * Person move from room IDRoomFrom to room IDRoomTo
	 */
	public void movePerson (int roomFromID, int roomToID) {
		rooms[getRoomi(roomFromID)].downPersonsInside();
		rooms[getRoomi(roomToID)].upPersonsInside();
	}
	
	
	/*
	 * Robot robotID move to room roomToID
	 */
	public void moveRobot (int robotID, int roomToID) {	
		robots[getRoboti(robotID)].setCurrentRoomID(roomToID);
	}
	
	/*
	 * when robot start cleaning room
	 */
	public void robotStartCleaning (int robotID, int roomID) {
		robots[getRoboti(robotID)].setStatus(RobotStatus.CLEANING);
		rooms[getRoomi(roomID)].setStatus(RoomStatus.CLEANING);
		
	}
	
	/*
	 * when robot stop cleaning
	 */
	public void robotStopCleaning (int robotID, int roomID) {
		rooms[getRoomi(roomID)].cleaned(0 /* change to time*/);
		if (roomsInQueue.size() == 0)
		{
			goRecharge(robots[getRoboti(robotID)].getID());
			robots[getRoboti(robotID)].setStatus(RobotStatus.MOVING);
		}
		else
		{
			computeWay(robots[getRoboti(robotID)], roomsInQueue.get(0));
			rooms[getRoomi(roomsInQueue.get(0).getID())].setStatus(RoomStatus.WAITING_FOR_CLEANING);
			roomsInQueue.remove(0);
			robots[getRoboti(robotID)].setStatus(RobotStatus.GO_CLEANING);
		}

	}
	
	
	/*
	 * Get i for room for roomID
	 */
	public int getRoomi (int roomID) {
		for (int i = 0; i < rooms.length; i++)
		{
			if (rooms[i].getID() == roomID)
			{
				return i;
			}
		}	
		System.err.println("Bad room ID");
		return 0;
	}
	
	/*
	 * Get i for robot for robotID
	 */
	public int getRoboti (int robotID) {
		for (int i = 0; i < robots.length; i++)
		{
			if (robots[i].getID() == robotID)
			{
				return i;
			}
		}	
		System.err.println("Bad robot ID");
		return 0;
	}
	
	
	/*
	 * Get i for power station for powerStationID
	 */
	public int getPowerStationi (int powerStationID) {
		for (int i = 0; i < powerStations.length; i++)
		{
			if (powerStations[i].getID() == powerStationID)
			{
				return i;
			}
		}
		System.err.println("Bad power station ID");
		return 0;
	}

}
