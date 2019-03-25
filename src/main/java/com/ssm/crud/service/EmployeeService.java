package com.ssm.crud.service;

import com.ssm.crud.entity.Employee;
import com.ssm.crud.entity.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;


/**
 * @author Ernest
 * @date 2018/4/4 13:27
 */
public interface EmployeeService {

    Result getAll(@Param(value = "pn")Integer pn);

    Result saveEmp(@Valid Employee employee, BindingResult result);

    Result checkName(@Param(value = "empName") String empName);

    Result getEmp(@Param(value = "empId") Integer empId);

    Result updateEmp(Employee employee);

    Result deleteEmp(@Param(value = "empId") Integer empId);

    Result deleteBatch(@Param(value = "empIds") String empIds);
}
