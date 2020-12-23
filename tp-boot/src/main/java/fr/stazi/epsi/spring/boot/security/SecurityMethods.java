package fr.stazi.epsi.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.stazi.epsi.spring.boot.entity.Cell;
import fr.stazi.epsi.spring.boot.entity.user.User;
import fr.stazi.epsi.spring.boot.repository.UserRepository;

@Service
public class SecurityMethods {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean canManage(Long cellId, UserDetails connectedUser ) {
		
		User user = userRepository.findByUsername(connectedUser.getUsername()).orElse(null);
		
		for (Cell cell : user.getCells()) {
			if (cell.getId() == cellId) return true;
		}
		
		return false;
		
	}
	
	

}
