package com.lawyer.controllers;

public class Persona {
  public String nombre;
  public String edad;

  public String getNombreCompleto() {
    return this.nombre + this.edad;
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}