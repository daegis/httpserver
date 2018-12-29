package com.guazi.component.http.interceptor;

import com.alibaba.fastjson.JSON;
import com.guazi.component.http.vo.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018-12-29 11:30
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("preHandler");
        HandlerMethod method = (HandlerMethod) handler;
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("请求参数：{}", JSON.toJSONString(parameterMap));
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            ResponseEntity<Object> fail = ResponseEntity.fail(403, "访问未授权");
            doHttpResponse(response, fail);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // after the handler method returning
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing here
    }

    private void doHttpResponse(HttpServletResponse response, ResponseEntity entity) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(entity));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
