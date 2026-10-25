public class Main {
    public static void main(String[] args) {
        double distanceKm = 10;

        RoutePlanner planner = new RoutePlanner(new CarRoute());
        printEstimate(planner, distanceKm);

        planner.setStrategy(new BikeRoute());
        printEstimate(planner, distanceKm);

        planner.setStrategy(new WalkingRoute());
        printEstimate(planner, distanceKm);
    }

    private static void printEstimate(RoutePlanner planner, double distanceKm) {
        double minutes = planner.estimateTravelTimeMinutes(distanceKm);
        System.out.println(planner.getStrategyName() + ": " + minutes + " min for " + distanceKm + " km");
    }
}
