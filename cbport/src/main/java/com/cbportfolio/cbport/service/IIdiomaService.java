
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Idioma;
import java.util.List;


public interface IIdiomaService {
    
    public List<Idioma> verIdiomas();
    public Idioma buscarIdioma(Long id);
    public void crearIdioma(Idioma idiom);
    public void borrarIdioma(Long id);
    public void editarIdioma(Idioma idiom);
}
