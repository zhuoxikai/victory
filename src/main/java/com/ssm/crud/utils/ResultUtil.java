package com.ssm.crud.utils;

import com.ssm.crud.entity.Result;
import com.ssm.crud.enums.ResultEnums;

/**
 * @author Ernest
 * @date 2018/4/4 13:33
 */
public class ResultUtil {

    public static Result success(ResultEnums resultEnum, Object object){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setExtend(object);
        return result;
    }

    public static Result success(ResultEnums resultEnum){
        return success(resultEnum, null);
    }

    public static Result error(ResultEnums resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}

