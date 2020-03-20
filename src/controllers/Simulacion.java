
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
        //se crea el carro inicial del sistema 
        carro = new Carro();
        //se agregar el carro a la cola de su nivel correspondiente 
        admin.agregarCarroACola(carro);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        Simulacion.id = id;
    }

    public Administrador getAdmin() {
        return admin;
    }
    
    public void iniciarSimulacion() throws InterruptedException{
        //se envia un carro al mecánico para que lo revise
        admin.reencolarListos(mecanico.revisarCarro(admin.enviarCarroListo(), admin.getNivel1(), admin.getNivel2(), admin.getNivel3()));
        
        //se revisar si pasaron dos ciclos para crear un carro 
        RevisarSiCrearCarro();
        
        //se verifica si se debe sacar un carro de la cola de esperando 
        sacarCarroEsperando();
    }
    
    public void RevisarSiCrearCarro() throws InterruptedException{
        if(Mecanico.carrosRevisados%2 == 0 && Mecanico.carrosRevisados !=0){
            Thread.sleep(2000);
            //el admin crea un carro y lo agrega a la cola de su nivel 
            admin.agregarCarroACola(admin.crearCarro());
        }
    }
    
    public void sacarCarroEsperando() throws InterruptedException{
        if(!(admin.getCarrosEsperando().isEmpty())) {
            Thread.sleep(2000);  
            //se verifica si saldrá un carro de la cola de esperando 
            admin.reencolarEspera(mecanico.sacarCarroEspera(admin.enviarCarroEspera()));
        }
    }
}
