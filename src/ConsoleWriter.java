public class ConsoleWriter {

    private int step;
    private final Building building;

    public ConsoleWriter(Building building) {
        this.building = building;
        this.step = 0;
    }

    void printBuilding() {
        System.out.printf("*** Step %d ***%n", ++step);
        for (int i = building.getFloors().size() - 1; i >= 0; i--) {
            Floor floor = building.getFloors().get(i);
            System.out.print(floor.getPassengersArrived() + "  | ");
            if (building.getElevator().getCurrentFloor() == floor.getFloor()) {
                if (building.getElevator().getDirection() == 1) {
                    String UP = "^";
                    System.out.print(UP + String.format(" %-11s", building.getElevator().formatPassengers()) + UP);
                } else {
                    String DOWN = "v";
                    System.out.print(DOWN + String.format(" %-11s", building.getElevator().formatPassengers()) + DOWN);
                }
            } else {
                System.out.print("              ");
            }
            System.out.print(" |  " + floor.getPassengersWaiting());
            System.out.println();
        }
        System.out.println();
    }
}
