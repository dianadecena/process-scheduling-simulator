
package controllers;

import models.Administrador;
import models.Carro;
import models.Mecanico;

/**
     * PROYECTO 2 
     * SISTEMAS OPERATIVOS
     * DIANA DECENA Y JOSE ALGUINDIGUE 
 **/

public class Simulacion {
    private Mecanico mecanico;
    public Carro carro1, carro2, carro3, carro4, carro5, carro6;
    private Administrador admin;
    public static int id = 1;
    
    public Simulacion(){
        this.inicializar();
    }
    
    public void inicializar(){
        admin = new Administrador();
        mecanico = new Mecanico();
        carro1 = new Carro();
        carro2 = new Carro();
        carro3 = new Carro(); 
        admin.agregarCarroACola(carro1);
        admin.agregarCarroACola(carro2);
        admin.agregarCarroACola(carro3);
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
        Thread.sleep(5000);
        admin.reencolarListos(mecanico.revisarCarro(admin.enviarCarroListo(), admin.getNivel1(), admin.getNivel2(), admin.getNivel3()));

        if(!(admin.getCarrosEsperando().isEmpty())) {
            admin.reencolarEspera(mecanico.sacarCarroEspera(admin.enviarCarroEspera()));
        }
        if(Mecanico.carrosRevisados == 2){
           admin.agregarCarroACola(admin.crearCarro());
       }
    }
    
}
