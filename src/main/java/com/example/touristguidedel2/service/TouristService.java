package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    TouristRepository touristRepository;

    public TouristService(){
        this.touristRepository = new TouristRepository();
    }
    public List<TouristAttraction> getAttractions(){
        touristRepository.getTouristAttractions();
        List<TouristAttraction> touristAttractions = touristRepository.getTouristAttractions();
        return touristAttractions;
    }

    public List<TouristAttraction> getAll(){
        return touristRepository.getAll();
    }

    public TouristAttraction findByID(int ID){
        return touristRepository.findById(ID);
    }

    public void updateAttraction(TouristAttraction attraction){
        touristRepository.updateAttraction(attraction);
    }

    public TouristAttraction addNewAttraction(TouristAttraction attraction){
        return touristRepository.addAttractions(attraction);
    }

    public void deleteAttraction(int ID){
        touristRepository.deleteAttraction(ID);
    }
}
