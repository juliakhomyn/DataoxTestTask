public class Main {
    public static void main(String[] args) {

        Building building = new Building();
        Elevator elevator = building.getElevator();
        ConsoleWriter writer = new ConsoleWriter(building);

        while (building.stillWaiting() || !elevator.getPassengers().isEmpty()) {
            writer.printBuilding();
            elevator.moveOneFloor();
        }
    }
}
