package com.kedu.xingzhuan.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * controller方法异步开始执行时就开始执行这个方法，而postHandle需要等到controller异步执行完成后再执行。
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	}

	/**
	 * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//String url = request.getRequestURI();
		//System.out.println("拦截器LoginInterceptor："+url);
		/*if (!url.contains("login") && !url.contains("/code") 
				&& !url.contains("/js")&& !url.contains("/jsp")&& !url.contains("/css")) {//放过资源文件加载
			Object object = request.getSession().getAttribute(CommonConstants.USERINFO);
			if (object == null) {
				//response.sendRedirect("/tologin");
				//return false;
			}
		}*/
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Max-Age", "86400");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		
		System.out.println("========Origin:"+request.getHeader("Origin"));
		return true;//立即返回
	}

	/**
	 * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
