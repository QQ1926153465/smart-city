package com.briup.smartcity.aop;

import com.briup.smartcity.bean.BaseLog;
import com.briup.smartcity.mapper.BaseLogMapper;
import com.briup.smartcity.utils.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 切面类
 * 添加依赖
 */
@Aspect//当前类是一个切面类
@Component//当前类被IOC容器创建对象
public class LogAspect {

    @Autowired
    private BaseLog baseLog;

    @Autowired
    private BaseLogMapper mapper;
    /**
     * 连接点：所有的方法
     * 切入点：部分连接点
     */

//execution(* com.briup.smartcity.web.controller..*.*(..)) &&

    @Pointcut("@annotation(Logging)")//使用注解编写哪些方法需要提供日志记录功能
    public void LogCupPoint(){
        //定义切入点规则
        //规则==方法

    }


//    @Before("LogCupPoint()")//在方法执行前执行此代码
//    public void before(){
//        System.out.println("前置通知");
//        //浏览器——》请求报文——》tomcat——》Request对象
//        //1.获取到浏览器访问系统的请求信息
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes  servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        //2.将请求信息封装到日志对象中
//        baseLog.setLogRequestMethod(request.getMethod());//获取请求方式
//        baseLog.setLogRequestUri(request.getServletPath());//获取请求的url
//        baseLog.setLogTime(new Date());//生成请求的时间
//        String token = request.getHeader("Authorization");
//        String username = JwtUtil.getUserId(token);
//        Map<String, Object> map = JwtUtil.getInfo(token);
//        baseLog.setLogUsername(username);
//        baseLog.setLogRealname((String) map.get("realName"));
//        //使用mapper将信息存储在数据库中
//        mapper.insertSelective(baseLog);
//    }

//    @After("LogCupPoint()")//在方法执行后执行此代码
//    public void after(){
//        System.out.println("后置通知");
//        //浏览器——》请求报文——》tomcat——》Request对象
//        //1.获取到浏览器访问系统的请求信息
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes  servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        //2.将请求信息封装到日志对象中
//        baseLog.setLogRequestMethod(request.getMethod());//获取请求方式
//        baseLog.setLogRequestUri(request.getServletPath());//获取请求的url
//        baseLog.setLogTime(new Date());//生成请求的时间
//        String token = request.getHeader("Authorization");
//        String username = JwtUtil.getUserId(token);
//        Map<String, Object> map = JwtUtil.getInfo(token);
//        baseLog.setLogUsername(username);
//        baseLog.setLogRealname((String) map.get("realName"));
//        //使用mapper将信息存储在数据库中
//        mapper.insertSelective(baseLog);
//    }



    @Around("LogCupPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("开始环绕通知");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        baseLog.setLogRequestMethod(request.getMethod());
        baseLog.setLogRequestUri(request.getRequestURI());
        baseLog.setLogTime(new Date());
        String token = request.getHeader("Authorization");
        String username = JwtUtil.getUserId(token);
        baseLog.setLogUsername(username);
        Map<String, Object> info = JwtUtil.getInfo(token);
        baseLog.setLogRealname((String)info.get("realName"));

        mapper.insertSelective(baseLog);

        return proceed;
    }

}


































































