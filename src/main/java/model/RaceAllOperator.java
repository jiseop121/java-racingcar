package model;

import model.domain.Car;
import model.domain.Cars;
import model.domain.RaceCount;

public class RaceAllOperator {
    private final RaceOnceOperator raceOnceOperator;

    public RaceAllOperator(RaceOnceOperator raceOnceOperator) {
        this.raceOnceOperator = raceOnceOperator;
    }


    public String raceAll(Cars cars,RaceCount raceCount){
        StringBuilder totalResultSb = new StringBuilder();
        while(!isEnd(cars,raceCount)){
            raceOnceOperator.race(cars,raceCount);
            totalResultSb.append(raceOnceOperator.generateRaceOnceStatus(cars));
        }
        return totalResultSb.toString();
    }

    public boolean isEnd(Cars cars,RaceCount raceCount){
        for (Car car : cars.playCars()) {
            if(isReachEndDistance(car,raceCount)){
                return true;
            }
        }
        return false;
    }

    private boolean isReachEndDistance(Car car,RaceCount raceCount) {
        return raceCount.value() <= car.raceDistance().getValue();
    }
}
