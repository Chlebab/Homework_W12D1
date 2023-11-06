package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ITicketed, ISecurity {

    public RollerCoaster(String name, int rating, int minAge, double minHeight) {
        super(name, rating,  minAge,  minHeight);
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getHeight() < 2.0) {
            return 8.40;
        } else return 16.8;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getHeight() > 1.45 && visitor.getAge() > 12;
    }
}
