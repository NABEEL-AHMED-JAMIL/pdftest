package com.ballistic.token_test.service;

import com.ballistic.token_test.domain.model.Employee;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Nabeel on 12/2/2017.
 */
@Service
@Transactional
public class EmployeeService extends BaseEntityService<Employee> {

    // final
}
