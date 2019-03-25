package com.ssm.crud.service.impl;

import com.ssm.crud.dao.DepartmentMapper;
import com.ssm.crud.entity.Department;
import com.ssm.crud.entity.Result;
import com.ssm.crud.enums.ResultEnums;
import com.ssm.crud.service.DepartmentService;
import com.ssm.crud.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ernest
 * @date 2018/4/7 9:27
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Result getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return ResultUtil.success(ResultEnums.SUCCESS, list);
    }
}
