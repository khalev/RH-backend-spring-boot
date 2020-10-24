package com.example.grh.doa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grh.entity.Employe;


public interface EmplRepository extends JpaRepository<Employe, Long> {
    @Query( "select c from Employe c where c.nom like :x or  c.prenom like :x " )
    public Page<Employe> listeEmployeParMC( @Param( "x" ) String mc, Pageable pageable );
}
