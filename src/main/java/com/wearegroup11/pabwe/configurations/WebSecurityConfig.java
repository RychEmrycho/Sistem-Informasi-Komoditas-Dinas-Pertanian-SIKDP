package com.wearegroup11.pabwe.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private DataSource dataSource;

    @Autowired
    void injectDependency(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //.antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest()
        //.authenticated().and().csrf().disable()
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/signup").permitAll()
                .antMatchers("/resources/**", "/css/**", "/styles/**", "/js/**", "/img/**").permitAll()

                .antMatchers("/berita/post-comment-for-berita/{id}").authenticated()

                .antMatchers("/pengumuman/create", "/pengumuman/save", "/pengumuman/edit/**", "/pengumuman/hapus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/laporan-kelompok/accept", "/laporan-kelompok/reject").hasAnyAuthority("ADMIN")
                .antMatchers("/kelompok-tani/accept", "/kelompok-tani/reject").hasAnyAuthority("ADMIN")
                .antMatchers("/komoditi/create", "/komoditi/save", "/komoditi/edit/**", "/komoditi/hapus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/kelurahan/**").hasAnyAuthority("ADMIN")
                .antMatchers("/kecamatan/**").hasAnyAuthority("ADMIN")
                .antMatchers("/harga-komoditi/create", "/harga-komoditi/save", "/harga-komoditi/edit/**", "/harga-komoditi/hapus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/bantuan/accept", "/bantuan/reject").hasAnyAuthority("ADMIN")
                .antMatchers("/berita/create", "/berita/save", "/berita/edit/**", "/berita/hapus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/auth/accept", "/auth/reject").hasAnyAuthority("ADMIN")

                .antMatchers("/kelompok-tani/create", "/kelompok-tani/edit/**", "/kelompok-tani/hapus/**").hasAnyAuthority("KETUA")
                .antMatchers("/hasil-pertanian/create", "/hasil-pertanian/save", "/hasil-pertanian/edit/**", "/hasil-pertanian/hapus/**").hasAnyAuthority("KETUA")
                .antMatchers("/laporan-kelompok/create", "/laporan-kelompok/edit/**", "/laporan-kelompok/hapus/**").hasAnyAuthority("KETUA")
                .antMatchers("/bantuan/create", "/bantuan/edit/**", "/bantuan/hapus/**").hasAnyAuthority("KETUA")

                .and()

                .formLogin().loginPage("/auth/login").failureUrl("/auth/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")

                .and()

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .logoutSuccessUrl("/")

                .and()

                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60 * 60)

                .and()

                .exceptionHandling().accessDeniedPage("/auth/access_denied");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String USERS_QUERY = "select email, password, active from user where email=?";
        String ROLES_QUERY = "select u.email, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";
        auth.jdbcAuthentication()
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(ROLES_QUERY)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}