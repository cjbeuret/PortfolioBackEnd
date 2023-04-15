package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter 
@Setter
//@NoArgsConstructor (se pueden usar esta anotations en lugar de incluir el código
//@AllArgsConstructor
//@Builder (se usa en lugar de los constructores)
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
    //private String altBanner; esto no sé si va
    @Column (length=1000)
    private String imagen;
    //@Basic
    //private String altImagen; //esto no sé si va
    @Basic
    private String telefono;
    @Basic
    private String email;
    //@Temporal(TemporalType.DATE)
    //@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    //private Date fecha_Nac;
    @Basic 
    private String fechaNac;

    //relaciones
       
    //@OneToMany (mappedBy="persona")
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER / )

    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Experiencia> listaExperiencias;
    
    
    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Educacion> listaEducacion;
    
    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Proyecto> listaProyectos;
    
    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Habilidad> listaHabilidades;
    
    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Idioma> listaIdiomas;
    
    @OneToMany(mappedBy="pers", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Red> listaRedes;
    
    //@OneToOne (mappedBy="pers",cascade = CascadeType.PERSIST)
    //private Usuario username para cuando cree el usuario p el loggin
    
            
    /*
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    Direccion direccion;
    @OneToOne(cascade={CascadeType.PERSIST})
    Login login;
    
    @OneToOne(cascade={CascadeType.REMOVE}, orphanRemoval=true)
    Direccion direccion;
    @OneToMany(cascade={CascadeType.REMOVE}, orphanRemoval=true)
    List&lt;Telefono&gt; telefonos;
    
    */
    

//alt + insert p constructor    

    public Persona() {
    }

    public Persona(String nombre, String apellido, String especialidad1, String especialidad2, String sobreMi, String banner, String altBanner, String imagen, String altImagen, String telefono, String email, String fechaNac, List<Experiencia> listaExperiencias, List<Educacion> listaEducacion, List<Proyecto> listaProyectos, List<Habilidad> listaHabilidades, List<Idioma> listaIdiomas, List<Red> listaRedes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad1 = especialidad1;
        this.especialidad2 = especialidad2;
        this.sobreMi = sobreMi;
        this.banner = banner;
        //this.altBanner = altBanner;
        this.imagen = imagen;
        //this.altImagen = altImagen;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.listaExperiencias = listaExperiencias;
        this.listaEducacion = listaEducacion;
        this.listaProyectos = listaProyectos;
        this.listaHabilidades = listaHabilidades;
        this.listaIdiomas = listaIdiomas;
        this.listaRedes = listaRedes;
    }
    
    
    
    


    
    
    
}
