public class Cat {
    public double originWeight;
    private double weight;

    private final double minWeight = 1000.0;
    private final double maxWeight = 9000.0;
    private boolean isAlive = false; //без этого можно было кошку сперва замяукать досмерти, но потом покормить, и она как бы снова живая. Мне не очень нравится идея воскрешения кошек

    private double eatenFood;
    private double drunkWater;

    private static int count;
    private final int ayeCount = 4;

    private CatColor colour;


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        isAlive = true;
        count++;
        colour = CatColor.fromOrdinal((int)(5*Math.random()));
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        originWeight = weight;
    }

    public Cat(Cat cat) {             //Урок 7
            weight = cat.weight;
            originWeight = cat.originWeight;
            isAlive = cat.isAlive;
            eatenFood = cat.eatenFood;
            drunkWater = cat.drunkWater;
            colour = cat.colour;
            count++;
    }

    public void meow() {
        if (checkAlive("mew")) {
            weight--;
            System.out.println("Meow");
            checkWeight();
        }
    }

    public void feed(Double amount) {
        if (checkAlive("eat")) {
            weight += amount;

            eatenFood += amount;
            checkWeight();
        }
    }

    public void drink(Double amount) {
        if (checkAlive("drink")) {
            weight += amount;
            drunkWater += amount;
            checkWeight();
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (!isAlive) {
            return "Dead";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public static void feedAllCats(Cat[] cats) {

        for (Cat cat : cats
        ) {
            cat.feed(100.0);
        }
    }

    public static void printAllCatsWeight(Cat[] cats) {
        int totalWeight = 0;
        System.out.println();
        System.out.print("Cats' weight: ");
        for (Cat cat : cats
        ) {
            System.out.print(cat.getWeight() + ", ");
            totalWeight += cat.getWeight();
            cat.checkWeight();
        }
        System.out.println("total cats' weight = " + totalWeight);
    }

    private boolean checkWeight() {
        if (weight < minWeight) {
            System.out.println("Your cat just died. Sorry");
            death();
            return false;
        } else if (weight > maxWeight) {
            System.out.println("Your cat has exploded. It's gone.");
            death();
            return false;
        } else {
            return true;
        }
    }

    public boolean getAlive() {
        return isAlive;
    }

    public double getEatenFood() {     // к уроку 2
        return eatenFood;
    }

    public void toilet() {
        if (checkAlive("go to the toilet")) {
            if (drunkWater == 0 && eatenFood == 0) {
                System.out.println("The cat doesn't want to go to toilet");
            } else if (drunkWater >= eatenFood) {
                System.out.println("Hide your slippers...");
                weight -= drunkWater;
                drunkWater = 0;
            } else {
                System.out.println("Digging noise from the toilet...");
                weight -= eatenFood;
                eatenFood = 0;
            }
        }
    }

    private boolean checkAlive(String actionName) {
        if (!isAlive) {
            System.out.println("Dead cat can't " + actionName);
            return false;
        } else {
            return true;

        }
    }

    private void death() {
        isAlive = false;
        weight = 0;
        eatenFood = 0;
        drunkWater = 0;
        count--;
    }

    public static int getCount() {
        return count;
    }

    public void setColour(CatColor colour){
        this.colour = colour;
    }

    public void setColour(int n){
        colour = CatColor.fromOrdinal(n);
    }

    public CatColor getColour(){
        return colour;
    }


}