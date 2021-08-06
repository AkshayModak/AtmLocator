package com.atm.locator.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpeningHours {

    public Integer dayOfWeek;
    List<Hours> hours;

}
