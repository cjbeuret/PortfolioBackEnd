
package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUsuario extends JpaRepository <Usuario, Long>{
    
}
