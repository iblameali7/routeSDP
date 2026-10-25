public class BikeRoute implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 15;
    private static final double MINUTES_IN_HOUR = 60;

    @Override
    public double calculateTimeMinutes(double distanceKm) {
        return distanceKm / AVERAGE_SPEED_KMH * MINUTES_IN_HOUR;
    }

    @Override
    public String getName() {
        return "Bike";
    }
}
