package com.briup.smartcity.web.interceptor;

import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        //1.如果接受到请求 预检请求 解决跨域问题  浏览器发送
        if (method.equals("OPTIONS")){
            System.out.println("放行预检请求");
            return true;
        }
        String token = request.getHeader("Authorization");

        if (token == null){
            throw  new ServiceException("用户未登录");
        }
        try {
            JwtUtil.checkSign(token);
        }catch (Exception e){
            throw new ServiceException("token无效");
        }


        return true;
    }
}
