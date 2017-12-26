package com.ballistic.persistence;

import com.ballistic.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Nabeel on 12/25/2017.
 */
@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private HotalRepository hotalRepository;

    @Override
    public void run(String... strings) throws Exception {

        Hotel marriot = new Hotel("Marriot", 5, true);
        Hotel ibis = new Hotel("Ibis", 3, false);
        Hotel goldenTulip = new Hotel("Golden Tulip", 4, true);

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(marriot);
        hotels.add(ibis);
        hotels.add(goldenTulip);

        this.hotalRepository.save(hotels);
    }
}
