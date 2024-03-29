/*
 * package com.alarm.app.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.web.access.AccessDeniedHandler; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 * 
 * @Configuration public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private AccessDeniedHandler accessDeniedHandler;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable() .authorizeRequests() .antMatchers("/", "/index",
 * "/rest/**").permitAll() .antMatchers("/**").permitAll()
 * .antMatchers("/admin/**").hasAnyRole("ADMIN")
 * .antMatchers("/user/**").hasAnyRole("USER") .anyRequest().authenticated()
 * .and() .formLogin() //.loginPage("/login").permitAll() .and()
 * .logout().permitAll() .and()
 * .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
 * 
 * }
 * 
 * @Autowired protected void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception {
 * 
 * auth.inMemoryAuthentication()
 * .withUser("user").password("user").roles("USER") .and()
 * .withUser("admin").password("admin").roles("ADMIN"); }
 * 
 * @Bean public WebMvcConfigurer webMvcConfigurer() { return new
 * WebMvcConfigurerAdapter() {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) { registry
 * .addMapping("/**") .allowedOrigins("http://localhost:8100")
 * .allowedMethods("POST","GET"); }
 * 
 * }; }
 * 
 * }
 */