package com.atm.locator.service;

import com.atm.locator.dto.response.AtmLocatorResponse;
import com.atm.locator.exception.custom.MandatoryFieldException;

import java.util.List;

public interface AtmLocatorService {

    List<AtmLocatorResponse> getAtmList();

    List<AtmLocatorResponse> getAtmListByCity(String cityName) throws MandatoryFieldException;

}
