package com.osom.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Member_tbl;
import com.osom.service.Member_tblService;



@SpringBootTest
class CreateMemberTests {

    @Autowired
    Member_tblService service;

    @Test
    void contextLoads() {

		Member_tbl obj = new Member_tbl("dddddddd", "djkd", "111111", "dsf111@naver.com", "enft", "dkseshl");

        try {
            service.register(obj);
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("FAILED");
            e.printStackTrace();
        }
    }

}