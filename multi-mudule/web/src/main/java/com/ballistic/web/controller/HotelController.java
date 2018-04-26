package com.ballistic.web.controller;

import com.ballistic.configuration.PropertiesConfig;
import com.ballistic.domain.Hotel;
import com.ballistic.persistence.HotalRepository;
import com.ballistic.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Created by Nabeel on 12/25/2017.
 */
@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotel")
    public Hotel getHotel() {
        return hotelService.getHotel();
    }

}
