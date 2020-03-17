
package models;

import controllers.Simulacion;

public class Carro {
    
    private int id;
    private int nivel = 0;
    private int cont = 0;
    private int estado = 0;

    public Carro() {
        this.id = Simulacion.id++; //se le asigna un id único al carro 
        this.nivel = (int)(Math.random()*(3-1+1)+1); //se le asigna un nivel random que puede ser 1, 2 o 3
    }

    public int getId() {
        return id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
