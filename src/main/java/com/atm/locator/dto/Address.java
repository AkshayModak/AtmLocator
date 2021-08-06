package com.atm.locator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    public String street;
    public String housenumber;
    public String postalcode;
    public String city;
    public Geo geoLocation;

}
