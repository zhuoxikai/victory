package com.ssm.crud.daoTest;

import com.ssm.crud.dao.DepartmentMapper;
import com.ssm.crud.dao.EmployeeMapper;
import com.ssm.crud.entity.Department;
import com.ssm.crud.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author Ernest
 * @date 2018/4/4 2:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);

        //departmentMapper.insertSelective(new Department(null, "开发部"));
        //departmentMapper.insertSelective(new Department(null, "测试部"));

        //employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@sicau.edu.com", 1));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0; i < 1000; i++){
           String uuid =  UUID.randomUUID().toString().substring(0,5)+i;
            //employeeMapper.insertSelective(new Employee(null, uuid, "M", uuid+"@sicau.edu.com", 1));
        }
        System.out.println("批量插入完成");
    }
}
