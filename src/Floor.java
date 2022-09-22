import java.util.List;

public class Floor {
    private int floor;
    private List<Integer> passengersWaiting;
    private int passengersArrived;

    public Floor(int floor, List<Integer> passengersWaiting) {
        this.floor = floor;
        this.passengersWaiting = passengersWaiting;
        this.passengersArrived = 0;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<Integer> getPassengersWaiting() {
        return passengersWaiting;
    }

    public void setPassengersWaiting(List<Integer> passengersWaiting) {
        this.passengersWaiting = passengersWaiting;
    }

    public int getPassengersArrived() {
        return passengersArrived;
    }

    public void setPassengersArrived(int passengersArrived) {
        this.passengersArrived = passengersArrived;
    }

    public void passengerArrived() {
        passengersArrived++;
    }

    @Override
    public String toString() {
        return "Floor = " + floor + "; " +
                "arrived - " + passengersArrived + "; " +
                "waiting - " + passengersWaiting.toString() + ";";
    }
}
