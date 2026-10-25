# Route Planner: Strategy Pattern (Assignment #5)

**Course:** Software Design Patterns
**Pattern:** Strategy (behavioral)
**Topic:** Estimating travel time for a route. The way of travelling (car, bike, walking) is an interchangeable algorithm chosen at runtime.

## Problem

Travel time depends on the mode of transport. Without the pattern, the planner would contain a chain of `if/else` on the mode, and every new mode would require editing that chain.

## Solution

Each mode is a separate class that implements `RouteStrategy`. `RoutePlanner` (the context) holds one strategy and delegates the calculation to it. The client chooses the strategy and can switch it at runtime with `setStrategy(...)`.

## Structure

```
Client (Main) ──► RoutePlanner (Context) ──► RouteStrategy (interface)
                                                  ▲
                              ┌───────────────────┼───────────────────┐
                          CarRoute            BikeRoute          WalkingRoute
```

| Component | Class |
|---|---|
| Strategy interface | `RouteStrategy` |
| Concrete strategies | `CarRoute`, `BikeRoute`, `WalkingRoute` |
| Context | `RoutePlanner` |
| Client | `Main` |

## How to run

1. Open the project in IntelliJ IDEA (JDK 11 or newer).
2. Run `Main.main()`.

Expected output:

```
Car: 10.0 min for 10.0 km
Bike: 40.0 min for 10.0 km
Walking: 120.0 min for 10.0 km
```

## Clean Code principles

### 1. Polymorphism instead of conditional logic
`RoutePlanner` contains no `if` or `switch` on the type of strategy. The variation is expressed by different classes behind one interface.

### 2. Meaningful, intention-revealing names
`CarRoute`, `BikeRoute`, `WalkingRoute`, `calculateTimeMinutes`, `estimateTravelTimeMinutes`. The name of the method also states the unit, so there is no ambiguity.

### 3. Single Responsibility Principle
Each strategy implements exactly one algorithm (travel time for one mode) and nothing else. The context only holds a strategy and delegates.

### 4. The context is algorithm-agnostic
`RoutePlanner` depends only on the `RouteStrategy` interface and knows nothing about concrete strategies or their speeds.

### 5. Easy extensibility (Open/Closed Principle)
To add a new mode, for example `ScooterRoute`, a new class that implements `RouteStrategy` is enough. No existing class (`RoutePlanner`, `CarRoute`, ...) is changed.

### Additional: no magic numbers
Speeds and the number of minutes in an hour are named constants (`AVERAGE_SPEED_KMH`, `MINUTES_IN_HOUR`).
