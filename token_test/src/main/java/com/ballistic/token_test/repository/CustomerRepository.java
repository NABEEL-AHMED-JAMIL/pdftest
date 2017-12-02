package com.ballistic.token_test.repository;

import com.ballistic.token_test.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 12/1/2017.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
