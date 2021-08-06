package com.atm.locator.service.impl;

import com.atm.locator.dto.response.AtmLocatorResponse;
import com.atm.locator.exception.custom.MandatoryFieldException;
import com.atm.locator.service.AtmLocatorService;
import com.atm.locator.util.UtilValidate;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmLocatorServiceImpl implements AtmLocatorService {

    private final static String URL = "https://www.ing.nl/api/locator/atms/";
    private final static Integer TRIM_CHARS = 5;
    private final static Logger log = LoggerFactory.getLogger(AtmLocatorServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<AtmLocatorResponse> getAtmList() {

        AtmLocatorResponse[] responses = {};

        log.info("Executing getAtmList Method.");
        log.info("Fetching Data from remote URL.");
        String response = restTemplate.getForObject(URL, String.class);
        //remove first five characters )]}', as it is corrupting the json conversion, and convert it as AtmLocatorReponse array.
        if (UtilValidate.isNotEmpty(response)) {
            responses = new Gson().fromJson(response.substring(TRIM_CHARS).trim(), AtmLocatorResponse[].class);
        }
        log.info("Total number of records fetched: " + responses.length);

        return Arrays.asList(responses);
    }

    @Override
    public List<AtmLocatorResponse> getAtmListByCity(String cityName) throws MandatoryFieldException {

        log.info("Executing getAtmListByCity Method.");

        if (UtilValidate.isEmpty(cityName)) {   //validate cityName
            throw new MandatoryFieldException("City Name is Mandatory.");
        }

        List<AtmLocatorResponse> responseList = null;
        AtmLocatorResponse[] responses = {};

        log.info("Fetching Data from remote URL.");
        String response = restTemplate.getForObject(URL, String.class);
        if (UtilValidate.isNotEmpty(response)) {
            //remove first five characters )]}', as it is corrupting the json conversion, and convert it as AtmLocatorReponse array.
            //Fetch full list as we don't have the api support to fetch by city name
            responses = new Gson().fromJson(response.substring(TRIM_CHARS).trim(), AtmLocatorResponse[].class);
            log.info("Total number of records fetched: " + responses.length);
            if (UtilValidate.isNotEmpty(response)) {
                responseList = Arrays.asList(responses);
                //filter records based on city name.
                responseList = responseList.stream().filter(i -> i.getAddress().getCity().equals(cityName)).collect(Collectors.toList());
                if (UtilValidate.isNotEmpty(responseList)) {
                    log.info("Total number of records returned: " + responseList.size());
                }
            }
        }

        return responseList;
    }
}
