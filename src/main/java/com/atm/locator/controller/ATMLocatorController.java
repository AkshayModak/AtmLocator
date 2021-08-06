package com.atm.locator.controller;

import com.atm.locator.dto.response.AtmLocatorResponse;
import com.atm.locator.service.AtmLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class ATMLocatorController implements Serializable {

    @Autowired
    AtmLocatorService atmLocatorService;

    @RequestMapping(value = "/getAtmLocatorList", method = RequestMethod.GET)
    public List<AtmLocatorResponse> getAtmList() {
        return atmLocatorService.getAtmList();
    }

    @RequestMapping(value = "/getAtmLocatorByCity/{cityName}", method = RequestMethod.GET)
    public List<AtmLocatorResponse> getAtmListByCity(@PathVariable String cityName) throws Exception {
        return atmLocatorService.getAtmListByCity(cityName);
    }
}
