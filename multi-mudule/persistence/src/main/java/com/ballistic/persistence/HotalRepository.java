package com.ballistic.persistence;

import com.ballistic.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by Nabeel on 12/25/2017.
 */
@Repository
public interface HotalRepository extends JpaRepository<Hotel, Long>{
}
