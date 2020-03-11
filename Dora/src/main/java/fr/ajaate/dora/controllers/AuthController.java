package fr.ajaate.dora.controllers;



import fr.ajaate.dora.EnvoyerEmail;
import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;

import fr.ajaate.dora.Exchange.LoginRequest;
import fr.ajaate.dora.Exchange.TokenResponse;
import fr.ajaate.dora.security.TokenFilter;
import fr.ajaate.dora.security.TokenTools;
import fr.ajaate.dora.services.implementation.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	StaffRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	TokenTools tokenTools;

	@Autowired
	TokenFilter tokenFilter;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenTools.generateJwtToken(authentication);
		System.out.println("*************************** token ************"+jwt);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new TokenResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(),
												 roles,userDetails.getFirstname(),userDetails.getLastname()));
	}


	@GetMapping("/logout/{id}")
	public String logoutUser(@PathVariable("id") Long id) {
		System.out.println("it's okay");
		tokenTools.invalidateToken(id);
		return "logged out  ";
	}

	@GetMapping("/pwdForget/{mail}/{cle}")
	public String pwdForget(@PathVariable("mail") String mail, @PathVariable("cle") String cle){
			EnvoyerEmail test = new EnvoyerEmail();
			test.envoyer(mail, cle);
			return "send";
	}


}
