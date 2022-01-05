package com.briup.smartcity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.briup.smartcity.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    public void TokenTest(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsImV4cCI6MTY0MTI1ODcwNCwiaW5mbyI6eyJyZWFsTmFtZSI6IuWImOS6muiTiSIsInVzZXJuYW1lIjoiYWRtaW4ifX0.UQmrE-k2NDTL11xgTwpc04XdOfbmV-0rJz2PHrTVAJs";

        String userId = JwtUtil.getUserId(token);
        System.out.println(userId);
    }

}
