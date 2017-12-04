package com.ballistic.pdftest.mapper;


import com.ballistic.pdftest.dto.DivisionDTO;
import com.ballistic.pdftest.dto.EmployeeDTO;
import com.ballistic.pdftest.entity.Division;
import com.ballistic.pdftest.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * Created by Nabeel on 11/29/2017.
 */
@Mapper
public interface EmployeeMapper {

    @Mappings({ @Mapping(target = "employeeId", source = "entity.id"),
            @Mapping(target = "employeeName", source = "entity.name"),
            @Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")})
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mappings({ @Mapping(target = "id", source = "dto.employeeId"),
            @Mapping(target = "name", source = "dto.employeeName"),
            @Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss") })
    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    DivisionDTO divisionToDivisionDTO(Division entity);

    Division divisionDTOtoDivision(DivisionDTO dto);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list);

    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);
}
