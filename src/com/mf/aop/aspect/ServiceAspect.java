package com.mf.aop.aspect;

import java.util.UUID;






import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mf.aop.entity.AopSysLog;
import com.mf.aop.service.AopModuleService;
import com.mf.aop.service.AopSysLogService;
import com.mf.util.Common;

/**
 * 系统服务组件Aspect切面Bean
 * @author wangzhi
 * @date 2013-5-28
 */
//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
@Controller
public class ServiceAspect {

	private final static Log log = LogFactory.getLog(ServiceAspect.class);
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AopModuleService aopModuleService;
	@Autowired
	private AopSysLogService aopSysLogService;
	//配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.mf.aop.service..*(..))")
	public void aspect(){	}
	
	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 * 同时接受JoinPoint切入点对象,可以没有该参数
	 */
/*	@Before("aspect()")
	public void before(JoinPoint joinPoint){
		if(log.isInfoEnabled()){
			log.info("before " + joinPoint);
			System.out.println("before " + joinPoint);
		}
	}*/
	
	//配置后置通知,使用在方法aspect()上注册的切入点
	@After("aspect()")
	public void after(JoinPoint joinPoint){
        String methname =(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
        //System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));	      
        String opname = (String)request.getSession().getAttribute("opname");
      //获取用户请求方法的参数字符串  
        //*========数据库日志=========*// 
        AopSysLog aopSysLog = new AopSysLog();
        String params = "";    
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
             for ( int i = 0; i < joinPoint.getArgs().length; i++) { 
                params += joinPoint.getArgs()[i] + ";"; 
            }    
        }    
        aopSysLog.setCode(UUID.randomUUID().toString());
        aopSysLog.setOpnm(opname);
        aopSysLog.setOptime(Common.fromDateH());
        aopSysLog.setMethodName(methname);
        aopSysLog.setMethodParamValue(params);
        aopSysLog.setMethodParamNm(joinPoint.getArgs().length);
        aopSysLog.setStatus(1);
        aopSysLog.setOpresult("1");//成功
       String method2 = "com.mf.aop.service.impl.AopSysLogServiceImpl.add()";
        //保存数据库    
       if (aopSysLog!=null && opname!=null && opname!="" && !methname.equals(method2)) {
              	 aopSysLogService.add(aopSysLog);
		}
	}
	
	//配置环绕通知,使用在方法aspect()上注册的切入点
	/*@Around("aspect()")
	public void around(JoinPoint joinPoint){
		long start = System.currentTimeMillis();
		try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
			if(log.isInfoEnabled()){
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
				System.out.println("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			}
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if(log.isInfoEnabled()){
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
				System.out.println("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
			}
		}
	}*/
	
	//配置后置返回通知,使用在方法aspect()上注册的切入点
	/*@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint){
		if(log.isInfoEnabled()){
			log.info("afterReturn " + joinPoint);
			System.out.println("afterReturn " + joinPoint);
		}
	}*/
	
	//配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut="aspect()", throwing="ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex){
		 String methname =(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
         String opname = (String)request.getSession().getAttribute("opname");
       //获取用户请求方法的参数字符串    
         //*========数据库日志=========*// 
         AopSysLog aopSysLog = new AopSysLog();
         String params = "";    
          if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
              for ( int i = 0; i < joinPoint.getArgs().length; i++) { 
                 params += joinPoint.getArgs()[i] + ";"; 
             }    
         }    
         aopSysLog.setCode(UUID.randomUUID().toString());
         aopSysLog.setOpnm(opname);
         aopSysLog.setOptime(Common.fromDateH());
         aopSysLog.setMethodName(methname);
         aopSysLog.setMethodParamValue(params);
         aopSysLog.setMethodParamNm(joinPoint.getArgs().length);
         aopSysLog.setStatus(2);
         aopSysLog.setOpresult(ex.getMessage());
        String method2 = "com.mf.aop.service.impl.AopSysLogServiceImpl.add()";
         //保存数据库    
        if (aopSysLog!=null && opname!=null && opname!="" && !methname.equals(method2)) {
               aopSysLogService.add(aopSysLog);
 		}
	}
	
	/**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
 /*    public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) { 
                    description = method.getAnnotation(SystemServiceLog.class).description();   
                     break;    
                }    
            }    
        }    
         return description;    
    }  */     
	
}