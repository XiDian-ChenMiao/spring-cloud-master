package com.topscomm.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件描述：Zuul提供的路由过滤器
 * 创建作者：陈苗
 * 创建时间：2017/8/3 10:49
 */
@Component
public class RouteFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(RouteFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型
     * 在Zuul提供了四中不同生命周期的过滤器类型：
     * pre： 路由之前
     * routing： 路由之时
     * post： 路由之后
     * error： 发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑，可以很复杂，包括查询SQL判断权限等
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {

            }
            return null;
        }
        logger.info("OK");
        return null;
    }
}
