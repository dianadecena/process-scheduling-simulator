
package models;

import java.util.Queue;
import views.ColasUI;

public class Administrador {
    private Carro carroAux;

    public Administrador() {
    }
    
    public Carro enviarCarroListo(Queue nivel1, Queue nivel2, Queue nivel3) throws InterruptedException{
            if(!(nivel1.isEmpty())){
                carroAux = (Carro) nivel1.poll();
                ColasUI.actualizarNivel1 = true;
                return carroAux;
            }
            if(!(nivel2.isEmpty())){
                carroAux = (Carro) nivel2.poll();
                ColasUI.actualizarNivel2 = true;
                return carroAux;
            }
            if(!(nivel3.isEmpty())){
                carroAux = (Carro) nivel3.poll();
                ColasUI.actualizarNivel3 = true;
                return carroAux;
            }
        return carroAux;
    }
    
    public Carro enviarCarroEspera(Queue CEspera){
        if(!(CEspera.isEmpty())){
            carroAux = (Carro) CEspera.peek();
            return carroAux;
        }
    return null;
    }


    public void reencolarListos(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3, Queue CEspera) throws InterruptedException {
        if(carro != null){
            if(carro.getEstado() == 1){
            //se puede poner un print de un carro salio al mercado
                System.out.println("Salio al mercado el carro con id: "+carro.getId());
            }
            if(carro.getEstado() == 2){
                CEspera.add(carro);
                ColasUI.actualizarEsperando = true;
            }
            if(carro.getEstado() == 3){
            //necesita revision el carro
                if (carro.getNivel() == 1){
                    nivel1.add(carro);
                    //Thread.sleep(5000);
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    nivel2.add(carro);
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    nivel3.add(carro);
                    ColasUI.actualizarNivel3 = true;
                }           
            }
            if(carro.getEstado() == 0){
                System.out.println("Algo malo paso");
            }
        }
    }


    public void reencolarEspera(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3, Queue CEspera){
        if(carro != null){
            if(carro.getEstado() == 4){
              System.out.println("Vuelve a su cola el carro de id: "+carro.getId());
                if(carro.getNivel() == 1){
                  nivel1.add(CEspera.poll()); 
                  System.out.println("El tamano de la cola es: "+nivel1.size());
                  ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                   nivel2.add(CEspera.poll()); 
                   System.out.println(nivel2.size());
                   ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                   nivel3.add(CEspera.poll());  
                   System.out.println(nivel3.size());
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
