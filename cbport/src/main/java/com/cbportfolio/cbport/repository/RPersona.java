package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository <Persona, Long>{
    public List<Persona> findByEmailAndPassword(String email, String password);
    
}
