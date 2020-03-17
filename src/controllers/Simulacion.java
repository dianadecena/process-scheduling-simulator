
package controllers;

import models.Administrador;
import models.Carro;
import models.Mecanico;
import views.ColasUI;

/**
     * PROYECTO 2 
     * SISTEMAS OPERATIVOS
     * DIANA DECENA Y JOSE ALGUINDIGUE 
 **/

public class Simulacion {
    private Mecanico mecanico;
    public Carro carro;
    public Administrador admin;
    public static int id = 1;
    
    public Simulacion(){
        this.inicializar();
    }
    
    public void inicializar(){
        admin = new Administrador();
        mecanico = new Mecanico();
        carro = new Carro();
        admin.agregarCarroACola(carro);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administrador getAdmin() {
        return admin;
    }
    
    public void iniciarSimulacion() throws InterruptedException{
        //RevisarSiCrearCarro();
        System.out.println("Durmiendo");
        Thread.sleep(5000);
        admin.reencolarListos(mecanico.revisarCarro(admin.enviarCarroListo(), admin.getNivel1(), admin.getNivel2(), admin.getNivel3()));
        
        //RevisarSiCrearCarro();

        /*if(!(admin.getCarrosEsperando().isEmpty())) {
            //Thread.sleep(2500);  
            admin.reencolarEspera(mecanico.sacarCarroEspera(admin.enviarCarroEspera()));
        }*/
    }
    
    public void RevisarSiCrearCarro() throws InterruptedException{
        if(Mecanico.carrosRevisados%2 == 0 && Mecanico.carrosRevisados !=0){
            Thread.sleep(2000);
            admin.agregarCarroACola(admin.crearCarro());
        }
    }
    
    public void sacarCarroEsperando() throws InterruptedException{
        if(!(admin.getCarrosEsperando().isEmpty())) {
            Thread.sleep(2000);  
            admin.reencolarEspera(mecanico.sacarCarroEspera(admin.enviarCarroEspera()));
            //Thread.sleep(2500); 
        }
    }
}
