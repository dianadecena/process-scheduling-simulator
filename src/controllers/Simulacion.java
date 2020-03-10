
package controllers;

import models.Administrador;
import models.Carro;
import models.Mecanico;
import java.util.LinkedList; 
import java.util.Queue; 

public class Simulacion {
    private Mecanico mecanico;
    private Carro carro1, carro2, carro3;
    private Administrador admin;
    public Queue<Carro> carrosEsperando; //carros esperando ser reparados
    public Queue<Carro> carrosListos;
    public Queue<Carro> nivel1;
    public Queue<Carro> nivel2;
    public Queue<Carro> nivel3;
    private int id = 1;
    
    public Simulacion(){
        this.inicializar();
        admin.actualizarColaListos(carrosListos, nivel1, nivel2, nivel3);
        System.out.print("\nListos:");
        imprimirCola(carrosListos);
        System.out.print("\nN1:");
        imprimirCola(nivel1);
        System.out.print("\nN2:");
        imprimirCola(nivel2);
        System.out.print("\nN3:");
        imprimirCola(nivel3);
        admin.reencolar(mecanico.revisarCarro(admin.enviarCarro(carrosListos, nivel1, nivel2, nivel3)));
        
    }
    
    public void inicializar(){
        mecanico = new Mecanico();
        carro1 = new Carro(id++);
        //System.out.println(carro1.getNivel());
        carro2 = new Carro(id++);
        //System.out.println(carro2.getNivel());
        carro3 = new Carro(id++);
        //System.out.println(carro3.getNivel());
        admin = new Administrador();
        carrosEsperando = new LinkedList<>(); 
        carrosListos = new LinkedList<>();
        nivel1 = new LinkedList<>();
        nivel2 = new LinkedList<>();
        nivel3 = new LinkedList<>();   
        this.agregarCarroACola(carro1);
        this.agregarCarroACola(carro2);
        this.agregarCarroACola(carro3);
    }

    public void setColaNivel1(Carro carro) {
        nivel1.add(carro);
    }

    public void setColaNivel2(Carro carro) {
        nivel2.add(carro);
    }
     
    public void setColaNivel3(Carro carro) {
        nivel3.add(carro);
    }
    
    public void agregarCarroACola(Carro carro){
        if(carro.getNivel() == 1){
            setColaNivel1(carro);
        }
        if(carro.getNivel() == 2){
            setColaNivel2(carro);
        } 
        if(carro.getNivel() == 3){
            setColaNivel3(carro);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void imprimirCola(Queue Cola){
        Carro carroAux;
        System.out.print("[");
        if(!(Cola.isEmpty())){
                for(int i=1; i<=Cola.size(); i++){
                    carroAux = (Carro) Cola.poll();
                    System.out.print(carroAux.getId());
                    Cola.add(carroAux);
                    if(i<Cola.size())
                    System.out.print(", ");
                }
        }
        System.out.print("]");
    }
    
}
