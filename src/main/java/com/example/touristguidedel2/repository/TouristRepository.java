package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> touristAttractions;

    public TouristRepository(){
        touristAttractions = new ArrayList<>();
        TouristAttraction touristAttraction = new TouristAttraction("Tivoli Tårnet", "Et højt tårn med en verticalt drop");
        TouristAttraction touristAttraction2 = new TouristAttraction("Djævlen", "En rutschebane der indeholder loop og drops");

        touristAttractions.add(touristAttraction);
        touristAttractions.add(touristAttraction2);
        setIDToAttractions();
    }

    public List<TouristAttraction> getAll(){
        return touristAttractions;
    }

    public TouristAttraction addAttractions(TouristAttraction touristAttraction){
        touristAttractions.add(touristAttraction);
        setIDToAttractions();
        return touristAttraction;
    }

    public List<TouristAttraction> getTouristAttractions(){
        return touristAttractions;
    }

    public TouristAttraction getTouristAttraction(int id){
        return touristAttractions.get(id);
    }

    public TouristAttraction findById(int id) {
        TouristAttraction attractionToFind = null;
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getID() == id)
                attractionToFind = attraction;


        }
        if (attractionToFind != null)
            return attractionToFind;
        else
            return null;
    }

    public void updateAttraction(TouristAttraction attractionToUpdate) {
        for(TouristAttraction attraction : touristAttractions){
            if(attraction.getID() == attractionToUpdate.getID()){
                touristAttractions.set(attraction.getID(), attractionToUpdate);
            }
        }
        setIDToAttractions();
    }

    public void setIDToAttractions(){
        int i = 0;
        for(TouristAttraction attraction : touristAttractions){
            attraction.setID(i);
            i++;
        }
    }

    public void deleteAttraction(int ID){
        TouristAttraction attractionToBeRemoved = null;
        if(!touristAttractions.isEmpty()){
            for(TouristAttraction attraction : touristAttractions){
                if(attraction.getID() == ID){
                    attractionToBeRemoved = attraction;
                }
            }
        } else{

        }
        if(!attractionToBeRemoved.equals(null)){
            touristAttractions.remove(attractionToBeRemoved);
        }
        setIDToAttractions();
    }
}
