package fr.ajaate.dora.service;


import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class StaffDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private StaffRepository staffRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Staff staff = staffRepository.findByUsername(username);
        if (staff == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            grantedAuthorities.add(new SimpleGrantedAuthority(staff.getRole().toString()));


        return new org.springframework.security.core.userdetails.User(staff.getUsername(), staff.getPassword(), grantedAuthorities);
    }
}
