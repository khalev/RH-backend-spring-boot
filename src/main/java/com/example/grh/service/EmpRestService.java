package com.example.grh.service;

import com.example.grh.doa.EmplRepository;
import com.example.grh.doa.UserRepository;

import com.example.grh.entity.Employe;
import com.example.grh.entity.User;


import java.util.Calendar;
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




@RestController
@CrossOrigin( "*" )

public class EmpRestService {

	 @Autowired
	    private EmplRepository emplRepository;
	 
	 
	 @RequestMapping( value = "/employes", method = RequestMethod.GET )
	    public Page<Employe> employes(
	            @RequestParam( name = "page", defaultValue = "0" ) int page,
	            @RequestParam( name = "size", defaultValue = "6" ) int size ) {
	        return emplRepository.findAll( PageRequest.of( page, size ) );
	    }

	    @RequestMapping( value = "/chercherEmploye", method = RequestMethod.GET )
	    public Page<Employe> employeParMC( @RequestParam( name = "mc", defaultValue = "" ) String mc,
	            @RequestParam( name = "page", defaultValue = "0" ) int p,
	            @RequestParam( name = "size", defaultValue = "6" ) int s ) {
	        return emplRepository.listeEmployeParMC( "%" + mc + "%", PageRequest.of( p, s ) );
	    }

	    @RequestMapping( value = "/employe/{id}", method = RequestMethod.GET )
	    public Employe employe( @PathVariable Long id ) {
	        Optional<Employe> c = emplRepository.findById( id );
	        return c.get();
	    }

	    @RequestMapping( value = "/employe/{id}", method = RequestMethod.DELETE )
	    public boolean delete( @PathVariable Long id ) {
	        emplRepository.deleteById( id );
	        return true;
	    }

	    @RequestMapping( value = "/employes", method = RequestMethod.POST )
	    public Employe saveEmploye( @RequestBody Employe c ) {
	    	emplRepository.save( c );
	    	c.setNote(10);
	    	c.setHeureAbs(0);
	    	emplRepository.save( c );
	        return c;

	    }

	    @RequestMapping( value = "/employes/{id}", method = RequestMethod.PUT )
	    public Employe updateEmploye( @PathVariable Long id, @RequestBody Employe c ) {
	       
	    	c.setId(id);
	       if( (c.getHeureAbs()>=5) || (c.getHeureAbs()<=20 )) {c.setNote(0); }
	    	
	       if( c.getHeureAbs()>20) {c.setNote(-10); }
	       
	       if( c.getHeureAbs()<5) {c.setNote(10); }
	    	
	    	emplRepository.save( c );
	    	 
	        return c; 

	    }

	 
	 
	
	
}
