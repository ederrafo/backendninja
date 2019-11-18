package com.ederrafo.component;


/*
 * Interceptor in MVC Spring,
 * this class will work in the class where it implement,
 * this class work for each request
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptorComponent")
public class RequestTimeInterceptorComponent extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptorComponent.class);

    @Override
    // This method will execute before of the method custom execution
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return super.preHandle(request, response, handler);
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    // This method will execute before the render view in method class.
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //super.afterCompletion(request, response, handler, ex);
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        String time = " ' | Total time:' " + (System.currentTimeMillis() - startTime) + " ms";
        LOG.info("Request URL:" + url + " " + time);
    }
}
