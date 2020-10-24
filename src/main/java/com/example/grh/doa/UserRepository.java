package com.example.grh.doa;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grh.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query( "select c from User c where c.nom like :x or  c.prenom like :x " )
    public Page<User> listeUserParMC( @Param( "x" ) String mc, Pageable pageable );
    
    
    
    @Query( "select c from User c where c.nom like :x or  c.prenom like :x " )
    public List<User> listUserParMC( @Param( "x" ) String mc);
}
