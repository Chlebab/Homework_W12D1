package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating, int minAge, double minHeight) {
        super(name, rating, minAge, minHeight);
    }

    @Override
    public double defaultPrice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getAge() < 12) {
            return 2.25;
        } else return 4.5;
    }

}
