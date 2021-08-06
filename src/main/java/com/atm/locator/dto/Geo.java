package com.atm.locator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Geo implements Serializable {

    public String lat;
    public String lng;
}
