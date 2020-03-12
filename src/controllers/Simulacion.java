
package controllers;

import models.Administrador;
import models.Carro;
import models.Mecanico;
import java.util.LinkedList; 
import java.util.Queue; 

/**
     * PROYECTO 2 
     * SISTEMAS OPERATIVOS
     * DIANA DECENA Y JOSE ALGUINDIGUE 
 **/

public class Simulacion {
    private Mecanico mecanico;
    private Carro carro1, carro2, carro3, carro4, carro5, carro6;
    private Administrador admin;
    public Queue<Carro> carrosEsperando; //carros esperando ser reparados
    public Queue<Carro> carrosListos;
    public Queue<Carro> nivel1;
    public Queue<Carro> nivel2;
    public Queue<Carro> nivel3;
    public static int id = 1;
    
    public Simulacion(){
        this.inicializar();
        /*System.out.print("\nListos:");
        imprimirCola(carrosListos);
        System.out.print("\nN1:");
        imprimirCola(nivel1);
        System.out.print("\nN2:");
        imprimirCola(nivel2);
        System.out.print("\nN3:");
        imprimirCola(nivel3);*/
        
    }
    
    public void inicializar(){
        mecanico = new Mecanico();
        carro1 = new Carro();
        //System.out.println(carro1.getNivel());
        carro2 = new Carro();
        //System.out.println(carro2.getNivel());
        carro3 = new Carro();
        carro4 = new Carro();
        carro5 = new Carro();
        carro6 = new Carro();
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
        this.agregarCarroACola(carro4);
        this.agregarCarroACola(carro5);
        this.agregarCarroACola(carro6);
    }

    public void setColaNivel1(Carro carro) {
        nivel1.add(carro);
    }

    public Queue<Carro> getColaNivel1() {
        return nivel1;
    }
    
    public Queue<Carro> getColaNivel2() {
        return nivel2;
    }
    
    public Queue<Carro> getColaNivel3() {
        return nivel3;
    }
    
    public void setColaNivel2(Carro carro) {
        nivel2.add(carro);
    }
     
    public void setColaNivel3(Carro carro) {
        nivel3.add(carro);
    }
    
    public void agregarCarroACola(Carro carro){
        if(carro.getNivel() == 1){
            System.out.println("CARROS NIVEL 1: " +carro.getId());
            setColaNivel1(carro);
        }
        if(carro.getNivel() == 2){
            System.out.println("CARROS NIVEL 2: " +carro.getId());
            setColaNivel2(carro);
        } 
        if(carro.getNivel() == 3){
            System.out.println("CARROS NIVEL 3: " +carro.getId());
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
    
    public void iniciarSimulacion() throws InterruptedException{
        Thread.sleep(5000);
        admin.reencolarListos(mecanico.revisarCarro(admin.enviarCarroListo(nivel1, nivel2, nivel3), nivel1,nivel2,nivel3), nivel1,nivel2,nivel3,carrosEsperando);
        
        
       /* if(!(carrosEsperando.isEmpty())) {
            Thread.sleep(1000);
            admin.reencolarEspera(mecanico.sacarCarroEspera(admin.enviarCarroEspera(carrosEsperando)), nivel1, nivel2, nivel3, nivel1);
        }
       if(Mecanico.carrosRevisados == 2){
           Thread.sleep(2000);
           admin.crearCarro();
       }*/
    }
    
}
