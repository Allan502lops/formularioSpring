/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehiculos;

/**
 *
 * @author alanl
 */
public class Vehiculo {

    private String placa;
    private String modelo;
    private String color;
    private int puertas;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String modelo, String color, int puertas) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.puertas = puertas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
}
