package com.ssm.crud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.crud.dao.EmployeeMapper;
import com.ssm.crud.entity.Employee;
import com.ssm.crud.entity.EmployeeExample;
import com.ssm.crud.entity.Result;
import com.ssm.crud.enums.ResultEnums;
import com.ssm.crud.service.EmployeeService;
import com.ssm.crud.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ernest
 * @date 2018/4/4 13:28
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Result getAll(Integer pn) {
        PageHelper.startPage(pn,10);
        List<Employee> emps = employeeMapper.selectByExampleWithDept(null);
        PageInfo page = new PageInfo(emps, 5);
        return ResultUtil.success(ResultEnums.SUCCESS, page);
    }

    public Result saveEmp(@Valid Employee employee, BindingResult result) {
        if(result.hasErrors()){
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ResultUtil.success(ResultEnums.FAIL, map);
        }else {
            employeeMapper.insertSelective(employee);
            return ResultUtil.success(ResultEnums.SUCCESS);
        }
    }

    public Result checkName(String empName) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);

        String regx = "(^[a-zA-Z0-9_-]{5,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return ResultUtil.success(ResultEnums.FAIL,"用户名必须是2-5位中文或者5-16位英文和数字的组合");
        };

        long count = employeeMapper.countByExample(employeeExample);
        if(count == 0){
            return ResultUtil.success(ResultEnums.SUCCESS,"用户名可用");
        }else{
            return ResultUtil.success(ResultEnums.FAIL,"用户名已存在");
        }
    }

    public Result getEmp(Integer empId) {
        Employee employee = employeeMapper.selectByPrimaryKey(empId);
        return ResultUtil.success(ResultEnums.SUCCESS, employee);
    }

    public Result updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
        return ResultUtil.success(ResultEnums.SUCCESS);
    }

    public Result deleteEmp(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
        return ResultUtil.success(ResultEnums.SUCCESS);
    }

    public Result deleteBatch(String empIds) {
        List<Integer> delEmpIds = new ArrayList<>();
        String[] strEmpIds = empIds.split("-");
        for (String string : strEmpIds){
            delEmpIds.add(Integer.parseInt(string));
        }
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(delEmpIds);
        employeeMapper.deleteByExample(employeeExample);
        return ResultUtil.success(ResultEnums.SUCCESS);
    }
}
