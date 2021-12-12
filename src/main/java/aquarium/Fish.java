package aquarium;

public abstract class Fish {
    private String name;
    private int weight;
    private String color;
    private boolean shortTermMemoryLoss;


    public Fish(String name, int weight, String color, boolean shortTermMemoryLoss) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.shortTermMemoryLoss = shortTermMemoryLoss;
    }

    public abstract void feed();

    public void increaseWeight(int weight) {
        this.weight += weight;
    }

    public boolean hasMemoryLoss() {
        return shortTermMemoryLoss;
    }

    public String getStatus() {
        return name + ", weight: " + weight
                + ", color: " + color
                + ", short-term memory loss: " + hasMemoryLoss();
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
