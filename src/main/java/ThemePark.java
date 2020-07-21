import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(){
        this.attractions = new ArrayList<Attraction>();
        this.stalls = new ArrayList<Stall>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> result = new ArrayList<IReviewed>();
        for (Attraction attraction : attractions){
            result.add(attraction);
        }
        for (Stall stall : stalls){
            result.add(stall);
        }
        return result;
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.visited();
        visitor.visitAttraction(attraction);
    }

    public HashMap<String, Integer> getReviews(){
        HashMap<String, Integer> allReviews = new HashMap<String, Integer>();
        for (IReviewed review : getAllReviewed()){
            allReviews.put(review.getName(), review.getRating());
        }
        return allReviews;
    }
}
