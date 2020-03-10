
package models;

public class Carro {
    
    private int id;
    private int nivel = 0;
    private int cont = 0;
    private int estado=0;

    public Carro(int id) {
        this.id = id;
        System.out.println(this.id);
        this.nivel = (int)(Math.random()*(3-1+1)+1);
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
