package com.sejong.project.capstone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import javax.sql.DataSource;


@Configuration("SecurityConfig")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
    }
        첫번째 authorizeRequest() 아래는 각 경로에 따른 권한을 지정할 수 있다.
        두 번째, hasRole은 말 그대로 괄호 안의 권한을 가진 유저만 해당 경로에 접근할 수 있도록 설정하는 것이다.
        formLogin() 아래는 .loginPage(), .defaultSuccessPage() 등으로 내가 직접 구현한 로그인 폼, 로그인 성공 시 이동할 경로를 설정할 수 있다. 이때 로그인 폼의 아이디, 패스워드 부분 아이디는 username, password로 일치시켜주어야 한다.
         */
        http.authorizeRequests()
                    .antMatchers("/", "/signup","/api/**","/api/lecturers","/api/requests","/lecturerlist","/login","/service","/create", "/AddMember", "/createAdmin", "/static/**", "/css/**", "/js/**", "/images/**", "/font-awesome/fonts/**", "/fonts/**", "/img/**","/vendor/**").permitAll()
                    .antMatchers().hasRole("USER")
                    .antMatchers("/building").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/sign-in")
                    .defaultSuccessUrl("/index")
                    .failureUrl("/login?error")
                    .usernameParameter("username")
                    .passwordParameter("pass")
                //.permitAll()
                    .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        /*
                    .and()
                .httpBasic();

         */

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select id, password, isEnabled "+
                "from Member where id=?")
                .authoritiesByUsernameQuery("select username, authority_name from Authority where username=?");

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
    /*
    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        User.UserBuilder commonUser = User.withUsername("commonUser");
        User.UserBuilder havi = User.withUsername("havi");

        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(commonUser.password("{noop}common").roles("USER").build());
        userDetailsList.add(havi.password("{noop}test").roles("USER", "ADMIN").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        http.httpBasic()
                .and().authorizeRequests()
                //.antMatchers(HttpMethod.POST, "/Boards/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and().cors().configurationSource(source)
                .and().csrf().disable();
    }

    */

/*
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll();
    }

}
*/
}
