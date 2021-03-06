package com.ballistic.token_test.repository;

import com.ballistic.token_test.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 12/1/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
