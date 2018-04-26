package com.ballistic.controller;


import com.ballistic.domain.Hotel;
import com.ballistic.persistence.HotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ServiceController {

    @Autowired
    private HotalRepository hotalRepository;

    @RequestMapping("/hotel/api/2")
    public List<Hotel> getHotelList() {
        return hotalRepository.findAll();
    }

}
