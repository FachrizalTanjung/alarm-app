/*
 * package com.alarm.app.error;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.security.access.AccessDeniedException; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.web.access.AccessDeniedHandler; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class MyAccessDeniedHandler implements AccessDeniedHandler
 * {
 * 
 * private static Logger logger =
 * LoggerFactory.getLogger(MyAccessDeniedHandler.class);
 * 
 * @Override public void handle(HttpServletRequest httpRequest,
 * HttpServletResponse httpResponse, AccessDeniedException ex) throws
 * IOException, ServletException {
 * 
 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 * 
 * if(auth != null) { logger.info("User '" + auth.getName() +
 * "' attempted to access the protected URL: " + httpRequest.getRequestURI()); }
 * 
 * httpResponse.sendRedirect(httpRequest.getContextPath() + "/403");
 * 
 * }
 * 
 * }
 */