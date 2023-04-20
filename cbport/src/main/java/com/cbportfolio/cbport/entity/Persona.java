package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

//import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter
//alt + insert p constructor  
@NoArgsConstructor
@AllArgsConstructor
@Builder //(se usa en lugar de los constructores)
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String especialidad1;
    @Basic
    private String especialidad2;
    @Column (length=1000)
    private String sobreMi;
    @Column (length=1000)
    private String banner;
    //@Basic
    @Column (length=1000)
    private String imagen;
    @Basic
    private String telefono;
    @Basic
    private String email;
    /*@Temporal(TemporalType.DATE)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fecha_Nac;*/
    @Basic 
    private String fechaNac;

    //relaciones
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Domicilio> listaDomicilios;
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Experiencia> listaExperiencias;
        
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Educacion> listaEducacion;
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Proyecto> listaProyectos;
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Habilidad> listaHabilidades;
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Idioma> listaIdiomas;
    
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Red> listaRedes;
    
    @OneToOne (mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id") 
    private Usuario usuario;
    

}
