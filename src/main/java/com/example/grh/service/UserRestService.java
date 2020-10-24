package com.example.grh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grh.doa.UserRepository;
import com.example.grh.entity.User;

@RestController
@CrossOrigin( "*" )
public class UserRestService {
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 @RequestMapping( value = "/usersList", method = RequestMethod.GET )
	    public List<User> usersList(){
	        return userRepository.findAll() ;
	    }
	 
	 
	 @RequestMapping( value = "/users", method = RequestMethod.GET )
	    public Page<User> users(
	            @RequestParam( name = "page", defaultValue = "0" ) int page,
	            @RequestParam( name = "size", defaultValue = "6" ) int size ) {
	        return userRepository.findAll( PageRequest.of( page, size ) );
	    }
	     
	 @RequestMapping( value = "/chercherUsers", method = RequestMethod.GET )
	    public List<User> usersParMC( @RequestParam( name = "mc", defaultValue = "" ) String mc ) {
	        return userRepository.listUserParMC( "%" + mc + "%" );
	    }
	 
	 
	 

	    @RequestMapping( value = "/chercherUser", method = RequestMethod.GET )
	    public Page<User> userParMC( @RequestParam( name = "mc", defaultValue = "" ) String mc,
	            @RequestParam( name = "page", defaultValue = "0" ) int p,
	            @RequestParam( name = "size", defaultValue = "6" ) int s ) {
	        return userRepository.listeUserParMC( "%" + mc + "%", PageRequest.of( p, s ) );
	    }

	    @RequestMapping( value = "/user/{id}", method = RequestMethod.GET )
	    public User user( @PathVariable Long id ) {
	        Optional<User> c = userRepository.findById( id );
	        return c.get();
	    }

	    @RequestMapping( value = "/user/{id}", method = RequestMethod.DELETE )
	    public boolean delete( @PathVariable Long id ) {
	        userRepository.deleteById( id );
	        return true;
	    }

	    @RequestMapping( value = "/users", method = RequestMethod.POST )
	    public User saveUser( @RequestBody User c ) {
	        return userRepository.save( c );

	    }

	    @RequestMapping( value = "/users/{id}", method = RequestMethod.PUT )
	    public User updateUser( @PathVariable Long id, @RequestBody User c ) {
	       
	    	c.setId(id);
	        return userRepository.save( c ); 

	    }

}
