package com.infoshareacademy.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceProvider {
    private int ID;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;
    private Location location;
    private ServiceType serviceType;
    private Availability availability;
    private boolean isActive;
    private List<Rating> ratingList;
    private double averageRating;

    static int id = 1;

    public ServiceProvider() {
        ratingList = new ArrayList<>();
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public double getAverageRating() {
        double sum = 0;
        for (Rating rating : ratingList) {
            sum += rating.getRating();
        }
        if (ratingList.size() > 0) {
            return sum / ratingList.size();
        } else {
            return -1.0; //returns -1 if no rating has been done so far
        }
    }

    public void addRating(int rating, String comment) {
        ratingList.add(new Rating(rating, comment));
    }

    public void addRating(int rating) {
        ratingList.add(new Rating(rating));
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = id++;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    /*public List<Date> getAvailability() {
        return availability;
    }*/

    /* public void setAvailability(List<Date> availability) {
         this.availability = availability;
     }
 */
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "ServiceProvider{" +
                "ID=" + ID +
                ", companyName='" + companyName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", websiteAddress='" + websiteAddress + '\'' +
                ", location=" + location +
                ", serviceType=" + serviceType +
                ", availability=" + availability +
                ", isActive=" + isActive +
                ", ratingList=" + ratingList +
                ", averageRating=" + averageRating +
                '}';
    }
}
