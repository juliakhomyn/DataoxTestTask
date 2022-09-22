import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {
    private int maxFloor;
    private Elevator elevator;
    private List<Floor> floors = new ArrayList<>();

    public Building() {
        this.elevator = new Elevator(this);
        this.maxFloor = generateMaxFloor();
        for (int i = 0; i < maxFloor; i++) {
            floors.add(new Floor((i + 1), generatePassengers(i + 1)));
        }
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    private int generateMaxFloor() {
        Random random = new Random();
        return random.nextInt(16) + 5;
    }

    private List<Integer> generatePassengers(int floor) {
        Random random = new Random();
        List<Integer> passengers = new ArrayList<>();
        int maxNeededFloor = elevator.getMaxNeededFloor();
        int passengersNumber = random.nextInt(11);
        while (passengers.size() < passengersNumber) {
            int passenger = random.nextInt(maxFloor) + 1;
            if (floor != passenger) {
                passengers.add(passenger);
                if (passenger > maxNeededFloor) {
                    elevator.setMaxNeededFloor(passenger);
                }
            }
        }
        return passengers;
    }

    public boolean stillWaiting() {
        for (int i = 0; i < elevator.getMaxNeededFloor(); i++) {
            if (!floors.get(i).getPassengersWaiting().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
