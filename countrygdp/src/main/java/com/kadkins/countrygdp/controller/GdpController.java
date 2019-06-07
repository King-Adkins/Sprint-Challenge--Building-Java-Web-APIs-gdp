package com.kadkins.countrygdp.controller;

import com.kadkins.countrygdp.CountrygdpApplication;
import com.kadkins.countrygdp.exceptions.NotFound;
import com.kadkins.countrygdp.model.GDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class GdpController
{
    private static final Logger logger = LoggerFactory.getLogger(GDP.class);

    @GetMapping(value = "/gdp")
    public ResponseEntity<?> getAllGDPs() {
        logger.info("All the GDPs");
        return new ResponseEntity<>(CountrygdpApplication.ourGdpList.gdpList, HttpStatus.OK);
    }

    @GetMapping(value = "/gdp/{id}")
    public ResponseEntity<?> getGDPDetail(@PathVariable long id) {
        GDP rtnGDP;
        logger.info("Your looking at gdp - " + id + " you crazy person");

        if ((CountrygdpApplication.ourGdpList.findGDP(e -> (e.getId()) == id)) == null) {
            throw new NotFound(id + "no gdps");
        } else {
            rtnGDP = CountrygdpApplication.ourGdpList.findGDP(e -> (e.getId() == id));
        }
        return new ResponseEntity<>(rtnGDP, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ModelAndView displayGDPTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("gdps");
        mav.addObject("gdpList", CountrygdpApplication.ourGdpList.gdpList);
        return mav;
    }

    @GetMapping(value = "/gdp/economy")
    public ResponseEntity<?> getGDPSLowtoHigh(@PathVariable String economy) {
        ArrayList<GDP> gdps = CountrygdpApplication.ourGdpList.findGDP(e -> (e.getGdp() == economy));
        return new ResponseEntity<>(gdps, HttpStatus.OK);
    }
}
