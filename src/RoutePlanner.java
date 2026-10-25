public class RoutePlanner {
    private RouteStrategy strategy;

    public RoutePlanner(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public double estimateTravelTimeMinutes(double distanceKm) {
        return strategy.calculateTimeMinutes(distanceKm);
    }

    public String getStrategyName() {
        return strategy.getName();
    }
}
