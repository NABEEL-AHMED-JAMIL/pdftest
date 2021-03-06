package com.ballistic.web.controller;

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
    private HotalRepository hotalRepository;

    @RequestMapping("/hotel/api/1")
    public List<Hotel> getHotelList() {
        return hotalRepository.findAll();
    }

}
