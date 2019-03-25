package com.ssm.crud.controller;

import com.ssm.crud.entity.Result;
import com.ssm.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ernest
 * @date 2018/4/7 9:23
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/depts", method = {RequestMethod.GET})
    @ResponseBody
    public Result getDept(){
        return departmentService.getDepts();
    }
}
