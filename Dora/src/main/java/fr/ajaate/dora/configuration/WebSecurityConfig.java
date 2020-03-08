package fr.ajaate.dora.configuration;



import fr.ajaate.dora.security.EntryPointWithToken;
import fr.ajaate.dora.security.TokenFilter;
import fr.ajaate.dora.services.implementation.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    UserDetailsServiceImpl userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;
	@Bean
	public InMemoryTokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Primary
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private EntryPointWithToken unauthorizedHandler;

	@Bean
	public TokenFilter authenticationJwtTokenFilter() {
		return new TokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
				/*
				.antMatchers(HttpMethod.GET,"/api/staff/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/DMP/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/hospitalization/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/affectations/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/act/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/document/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/profil/**").permitAll()
				 */
				.anyRequest().authenticated()
		;

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
