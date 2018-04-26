package com.ballistic.configuration;


import com.ballistic.component.HotelBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean(name = "hotelbean")
    public HotelBean getHotelBean() {
        return new HotelBean();
    }

}
