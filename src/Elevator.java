import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private final int capacity = 5;
    private int direction;      // 1 - up; 0 - down
    private int maxNeededFloor;
    private List<Integer> passengers = new ArrayList<>();
    private Building building;

    public Elevator(Building building) {
        this.building = building;
        this.direction = 1;
        this.currentFloor = 0;
        this.maxNeededFloor = 0;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public List<Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Integer> passengers) {
        this.passengers = passengers;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void moveOneFloor() {
        if (direction == 1) {
            currentFloor++;
        } else {
            currentFloor--;
        }
        direction = changeDirection(direction);
        List<Integer> releasedPassengers = passengers.stream()
                .filter(passenger -> passenger == currentFloor)
                .toList();
        for (Integer i : releasedPassengers) {
            passengerOut(i);
        }
        List<Integer> passengersToBoard = building.getFloors().get(currentFloor - 1)
                .getPassengersWaiting().stream()
                .filter(passenger -> direction == 1 ? passenger > currentFloor : passenger < currentFloor)
                .toList();
        for (Integer i : passengersToBoard) {
            passengerIn(i);
        }
    }

    private void passengerIn(Integer passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            building.getFloors().get(currentFloor - 1).getPassengersWaiting().remove(passenger);
        }
    }

    private void passengerOut(Integer passenger) {
        if (passenger == currentFloor) {
            passengers.remove(passenger);
            building.getFloors().get(currentFloor - 1).passengerArrived();
        }
    }

    private int changeDirection(int direction) {
        return currentFloor == maxNeededFloor ? 0 :
               currentFloor == 1 ? 1 : direction;
    }

    public int getMaxNeededFloor() {
        return maxNeededFloor;
    }

    public void setMaxNeededFloor(int maxNeededFloor) {
        this.maxNeededFloor = maxNeededFloor;
    }

    public String formatPassengers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < passengers.size(); i++) {
            stringBuilder.append(passengers.get(i)).append(i < passengers.size() - 1 ? " " : "");
        }
        return stringBuilder.toString();
    }
}
