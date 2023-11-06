import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<IReviewed> places;
    private String name;



    public ThemePark(String name) {
        this.places = new ArrayList<IReviewed>();
        this.name = name;
    }
    public ArrayList<IReviewed> getPlaces() {
        return places;
    }

    public String getName() {
        return name;
    }
    public int placesCount(){
        return places.size();
    }
    public void addPlace(IReviewed place){
        places.add(place);
    }
    public void emptyPlaceList(){
        places.clear();
    }
    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> reviewedList = new ArrayList<>();
        for(Object place : places) {
            reviewedList.add((IReviewed) place);
        }
        return reviewedList;
    }
    public void visit(Visitor visitor, Attraction attraction){
        visitor.addVisitedAttraction(attraction);
        attraction.visitAttraction();
    }
    public HashMap<String, Integer> getAllReviews(){
        HashMap<String, Integer> allReviews = new HashMap<>();
        for(Object place : places){
            Attraction attraction = (Attraction) place;
            allReviews.put(attraction.getName(), attraction.getRating());
        }
        return allReviews;
    }
    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allowedAttractionsList = new ArrayList<>();
        for(Object place : places){
            Attraction attraction = (Attraction) place;
            if(visitor.getAge() >= attraction.getMinAge() && visitor.getHeight() >= attraction.getMinHeight()){
                allowedAttractionsList.add(attraction);
            }
        }
        return allowedAttractionsList;
    }
}


//    ThemePark has a method that can return a new HashMap<String, Integer>
//    with all reviews. The HashMap will have a key of the name
//    and value of review.
//        ThemePark has a method getAllAllowedFor(Visitor) which takes a Visitor and returns an ArrayList of IReviewed
//        that the visitor is allowed to go on.
