package es.urjc.code.dad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/realizarconsultas").permitAll();
        http.authorizeRequests().antMatchers("/areaprivada").permitAll();
        http.authorizeRequests().antMatchers("/registrousuario").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();        
        http.authorizeRequests().antMatchers("/consultarjugador/nombreJugador").permitAll();
        http.authorizeRequests().antMatchers("/consultarequipo/nombreEquipo").permitAll();
        http.authorizeRequests().antMatchers("/consultaredadjugadores/edad").permitAll();
        http.authorizeRequests().antMatchers("/consultarpaisjugadores/nacionalidadJugador").permitAll();        
        http.authorizeRequests().antMatchers("/consultarpalmares/nombreLiga").permitAll();
        http.authorizeRequests().antMatchers("/consultartorneo/nombreLiga").permitAll();
        http.authorizeRequests().antMatchers("/manager/nuevo").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("user");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/areagestionmanager");
        http.formLogin().failureUrl("/areaprivada");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/areaprivada");
        
//        // Disable CSRF at the moment
//        http.csrf().disable();
    }

	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
	}
}
