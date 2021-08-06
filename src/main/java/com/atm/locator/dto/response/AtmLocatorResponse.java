package com.atm.locator.dto.response;

import com.atm.locator.dto.Address;
import com.atm.locator.dto.OpeningHours;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AtmLocatorResponse implements Serializable {

    public Address address;
    Integer distance;
    List<OpeningHours> openingHours;

}
