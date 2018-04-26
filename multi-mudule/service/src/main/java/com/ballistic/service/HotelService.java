package com.ballistic.service;


import com.ballistic.component.HotelBean;
import com.ballistic.configuration.PropertiesConfig;
import com.ballistic.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {


    @Autowired
    private HotelBean hotelbean;

    public Hotel getHotel() {
        Hotel hotel = new Hotel();
        hotel.setId(hotelbean.getId());
        hotel.setName(hotelbean.getName());
        hotel.setOpen(hotelbean.getOpen());
        hotel.setClassification(hotelbean.getClassification());
        return hotel;
    }
}
