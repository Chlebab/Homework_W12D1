package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;

public abstract class Attraction implements IReviewed {
    private String name;
    private int rating;
    private int visitCount;
    private int minAge;
    private double minHeight;

    public Attraction(String name, int rating, int minAge, double minHeight) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
        this.minAge = minAge;
        this.minHeight = minHeight;
    }

    public int getMinAge() {
        return minAge;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }
    public void visitAttraction(){
        visitCount += 1;
    }


}
