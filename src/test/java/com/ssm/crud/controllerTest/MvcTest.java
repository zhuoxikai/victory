package com.ssm.crud.controllerTest;

import com.github.pagehelper.PageInfo;
import com.ssm.crud.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author Ernest
 * @date 2018/4/6 14:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springMvc.xml"})
public class MvcTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    @Test
    public void initMocMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", String.valueOf(1))).andReturn();


        MockHttpServletRequest request = result.getRequest();

        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");

        System.out.println(pi.getPageNum()+pi.getPages()+pi.getTotal());

        List<Employee> list = pi.getList();

        System.out.println(list);
    }
}
