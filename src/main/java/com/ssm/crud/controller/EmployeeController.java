package com.ssm.crud.controller;

import com.ssm.crud.entity.Employee;
import com.ssm.crud.entity.Result;
import com.ssm.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Ernest
 * @date 2018/4/4 13:25
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     *
     * @param pn
     * @return
     */
    @RequestMapping(value = "/emps", method = {RequestMethod.GET})
    @ResponseBody
    public Result getEmps(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
        return employeeService.getAll(pn);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public Result saveEmp(@Valid Employee employee, BindingResult result){
        return employeeService.saveEmp(employee,result);
    }

    /**
     *
     * @param empName
     * @return
     */
    @RequestMapping(value = "/checkName", method = {RequestMethod.POST})
    @ResponseBody
    public Result checkName(@RequestParam("empName") String empName){
        return employeeService.checkName(empName);
    }

    /**
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "/emp/{empId}", method = {RequestMethod.GET})
    @ResponseBody
    public Result getEmp(@PathVariable("empId") Integer empId){
        return employeeService.getEmp(empId);
    }

    /**
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp/{empId}", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    /**
     *
     * @param empIds
     * @return
     */
    @RequestMapping(value = "/emp/{empIds}", method = {RequestMethod.DELETE})
    @ResponseBody
    public Result deleteEmpById(@PathVariable("empIds") String empIds){
        if(empIds.contains("-")){
            return employeeService.deleteBatch(empIds);
        }else {
            Integer empId = Integer.parseInt(empIds);
            return employeeService.deleteEmp(empId);
        }
    }
}
