package com.example.livemusicnowapp;

public class Event {
    private int eventID;
    private String bandName;
    private String bandLink;
    private String genre;
    private String description;
    private String date;
    private String time;
    private String venue;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String venueLink;
    private String ticketPrice;
    private String ticketLink;
    private String logoLink;
    public Event(){
        eventID = -1;
    }

    public int getEventID() {
        return eventID;
    }
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getBandName() {
        return bandName;
    }
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandLink() {
        return bandLink;
    }
    public void setBandLink(String bandLink) {
        this.bandLink = bandLink;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.date = time;
    }

    public String getVenue(){
        return venue;
    }
    public void setVenue(String venue){
        this.venue = venue;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState(){
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getVenueLink(){
        return venueLink;
    }
    public void setVenueLink (String venueLink) {
        this.venueLink = venueLink;
    }

    public String getTicketPrice(){
        return ticketPrice;
    }
    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketLink(){
        return ticketLink;
    }
    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }

    public String getLogoLink(){
        return logoLink;
    }
    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }
}
