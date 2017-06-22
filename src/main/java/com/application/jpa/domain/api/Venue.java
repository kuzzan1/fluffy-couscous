package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by jonas on 2017-06-22.
 */
public class Venue {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String surface;
    @JsonProperty
    private String address;
    @JsonProperty
    private String city;
    @JsonProperty
    private Integer capacity;
    @JsonProperty
    private String image_path;

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.surface = (String)data.get("surface");
        this.address = (String)data.get("address");
        this.city = (String)data.get("city");
        this.image_path = (String)data.get("image_path");
        this.capacity = (Integer)data.get("capacity");
    }


    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface( String surface ) {
        this.surface = surface;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity( Integer capacity ) {
        this.capacity = capacity;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path( String image_path ) {
        this.image_path = image_path;
    }
}
