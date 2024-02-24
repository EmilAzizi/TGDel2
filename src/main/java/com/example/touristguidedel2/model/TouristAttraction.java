package com.example.touristguidedel2.model;

public class TouristAttraction {
    private String name;
    private String description;
    private int ID;

    public TouristAttraction(String name, String description){
        this.name = name;
        this.description = description;
    }

    public TouristAttraction() {
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
}
