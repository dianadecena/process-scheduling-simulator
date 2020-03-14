
package models;

import java.util.LinkedList;
import java.util.Queue;
import views.ColasUI;

public class Administrador {
    private Carro carroAux;
    public Queue<Carro> carrosEsperando; 
    public Queue<Carro> nivel1;
    public Queue<Carro> nivel2;
    public Queue<Carro> nivel3;

    public Administrador() {
        carrosEsperando = new LinkedList<>(); 
        nivel1 = new LinkedList<>();
        nivel2 = new LinkedList<>();
        nivel3 = new LinkedList<>(); 
    }
    
    public Carro enviarCarroListo() throws InterruptedException{
            if(!(nivel1.isEmpty())){
                System.out.println("enviar carro nivel 1");
                carroAux = (Carro) nivel1.peek();
                ColasUI.idRevision = carroAux.getId();
                ColasUI.actualizarNivel1 = true;
                return carroAux;
            } else if(!(nivel2.isEmpty())){
                carroAux = (Carro) nivel2.poll();
                ColasUI.idRevision = carroAux.getId();
                ColasUI.actualizarNivel2 = true;
                return carroAux;
            } else if(!(nivel3.isEmpty())){
                carroAux = (Carro) nivel3.poll();
                ColasUI.idRevision = carroAux.getId();
                ColasUI.actualizarNivel3 = true;
                return carroAux;
            }
        return null;
    }
    
    public Carro enviarCarroEspera(){
        if(!(carrosEsperando.isEmpty())){
            carroAux = (Carro)carrosEsperando.peek();
            return carroAux;
        }
    return null;
    }


    public void reencolarListos(Carro carro) throws InterruptedException {
        if(carro != null){
            if(carro.getEstado() == 1){
            //se puede poner un print de un carro salio al mercado
                System.out.println("Salio al mercado el carro con id: "+carro.getId());
                if(carro.getNivel() == 1){
                    nivel1.poll();
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    nivel2.poll();
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    nivel3.poll();
                    ColasUI.actualizarNivel3 = true;
                } 
            }
            if(carro.getEstado() == 2){
                if(carro.getNivel() == 1){
                    nivel1.poll();
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    nivel2.poll();
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    nivel3.poll();
                    ColasUI.actualizarNivel3 = true;
                }  
                carrosEsperando.add(carro);
                ColasUI.actualizarEsperando = true;
            }
            if(carro.getEstado() == 3){
                if(carro.getNivel() == 1){
                    nivel1.poll();
                    nivel1.add(carro);
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    nivel2.poll();
                    nivel2.add(carro);
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    nivel3.poll();
                    nivel3.add(carro);
                    ColasUI.actualizarNivel3 = true;
                }           
            }
            if(carro.getEstado() == 0){
                System.out.println("Algo malo paso");
            }
        }
    }


    public void reencolarEspera(Carro carro){
        if(carro != null){
            if(carro.getEstado() == 4){
              System.out.println("Vuelve a su cola el carro de id: "+carro.getId());
                if(carro.getNivel() == 1){
                  nivel1.add(carrosEsperando.poll()); 
                  ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                   nivel2.add(carrosEsperando.poll()); 
                   ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                   nivel3.add(carrosEsperando.poll());  
                   ColasUI.actualizarNivel3 = true;
                }
        } else {
        System.out.println("sigues esperando chamito :(");
        }
        }
    }


    public Carro crearCarro(){
      if(Mecanico.carrosRevisados == 2){
        carroAux = new Carro();
        Mecanico.carrosRevisados = 0;
        System.out.println("El admin creo un carro");
        return carroAux;
      }
    return null;
    }
    
    
    public void agregarCarroACola(Carro carro){
        if(carro != null){
            if(carro.getNivel() == 1){
            System.out.println("CARROS NIVEL 1: " +carro.getId());
            nivel1.add(carro);
            ColasUI.actualizarNivel1 = true;
            }
            if(carro.getNivel() == 2){
                System.out.println("CARROS NIVEL 2: " +carro.getId());
                nivel2.add(carro);
                ColasUI.actualizarNivel2 = true;
            } 
            if(carro.getNivel() == 3){
                System.out.println("CARROS NIVEL 3: " +carro.getId());
                nivel3.add(carro);
                ColasUI.actualizarNivel3 = true;
            }
        }
    }

    public Queue<Carro> getCarrosEsperando() {
        return carrosEsperando;
    }

    public void setCarrosEsperando(Carro carro) {
        carrosEsperando.add(carro);
    }

    public Queue<Carro> getNivel1() {
        return nivel1;
    }

    public void setNivel1(Carro carro) {
        nivel1.add(carro);
    }

    public Queue<Carro> getNivel2() {
        return nivel2;
    }

    public void setNivel2(Carro carro) {
        nivel2.add(carro);
    }

    public Queue<Carro> getNivel3() {
        return nivel3;
    }

    public void setNivel3(Carro carro) {
        nivel3.add(carro);
    }
   

}
   /* public void actualizarColaListos(Queue nivel1, Queue nivel2, Queue nivel3){
        if(carrosListos.isEmpty()){
            if(!(nivel1.isEmpty())){
                carrosListos.add(nivel1.peek());
            } else if(nivel1.isEmpty()) {
                carrosListos.add(nivel2.peek());
            } else {
                carrosListos.add(nivel3.peek());
            }
        }
        if(!(carrosListos.isEmpty())){
            carrosListos.clear();
            if(!(nivel1.isEmpty())){
                for(int i=1; i<=nivel1.size(); i++){
                    carroAux = (Carro) nivel1.poll();
                    nivel1.add(carroAux);
                    carrosListos.add(carroAux);
                }
            }
            if(!(nivel2.isEmpty())){
                for(int i=1; i<=nivel2.size(); i++){
                    carroAux = (Carro) nivel2.poll();
                    nivel2.add(carroAux);
                    carrosListos.add(carroAux);
                }
            }
            if(!(nivel3.isEmpty())){
                for(int i=1; i<=nivel3.size(); i++){
                    carroAux = (Carro) nivel3.poll();
                    nivel3.add(carroAux);
                    carrosListos.add(carroAux);
                }
            }
        }
    }*/
