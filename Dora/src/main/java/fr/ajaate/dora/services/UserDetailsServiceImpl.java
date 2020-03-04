package fr.ajaate.dora.services;



import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	StaffRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Staff user = userRepository.findByemail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

		return UserDetailsImpl.build(user);
	}

}
