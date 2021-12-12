package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishes = new ArrayList<>();
    public static final int CAPACITY = 20;
    private static final int FISH_LIVING_SPACE = 5;

    public void addFish(Fish fish) {
        if (isFreeSpace()) {
            fishes.add(fish);
        } else {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
    }

    public void feed() {
        for (Fish actual : fishes) {
            actual.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> removeFishes = new ArrayList<>();
        for (Fish actual : fishes) {
            if (actual.getWeight() > maxWeight) {
                removeFishes.add(actual);
            }
        }
        fishes.removeAll(removeFishes);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish actual : fishes) {
            result.add(actual.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int result = 0;
        for (Fish actual : fishes) {
            if (actual.hasMemoryLoss()) {
                result++;
            }

        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish actual : fishes) {
            if (color.equals(actual.getColor())) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish smallest = fishes.get(0);
        for (Fish actual : fishes) {
            if (actual.getWeight() < smallest.getWeight()) {
                smallest = actual;
            }
        }
    return smallest;
    }

    private boolean isFreeSpace() {
        return fishes.size() * FISH_LIVING_SPACE < CAPACITY;
    }
}
