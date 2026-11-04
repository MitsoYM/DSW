package com.cifpcesarmanrique.HolaMundo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.springframework.web.bind.annotation.GetMapping;

public class Animal {
    private Integer id;
    private String nombre;
    private int vidaMedia;
    private boolean extinto;

    public Animal()
    {

    }
    //Constructores
    public Animal(Integer id, String nombre, int vidaMedia, boolean extinto) {
        this.id = id;
        this.nombre = nombre;
        this.vidaMedia = vidaMedia;
        this.extinto = extinto;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMedia() {
        return vidaMedia;
    }
    public void setVidaMedia(int vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    public boolean isExtinto() {
        return extinto;
    }
    public void setExtinto(boolean extinto) {
        this.extinto = extinto;
    }
}
