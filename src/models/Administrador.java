
package models;

import java.util.Queue;
import views.ColasUI;

public class Administrador {
    private int random;
    private int nivel;
    private Carro carroAux;

    public Administrador() {
    }
    
    public void revisandoCiclo(){
        random = (int)(Math.random()*(10-1+1)+1);
        nivel = (int)(Math.random()*(3-1+1)+1);
    }
    
    public Carro enviarCarroListo(Queue nivel1, Queue nivel2, Queue nivel3){
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
                carroAux = (Carro) CEspera.poll();
                return carroAux;}
                    
                return null;
    }


    public void reencolarListos(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3, Queue CEspera) {
        if(carro.getEstado()==1){
        //se puede poner un print de un carro salio al mercado
            System.out.println("Salio al mercado el carro con id: "+carro.getId());
        }
        if(carro.getEstado()==2){
        CEspera.add(carro);
        }
        if(carro.getEstado()==3){
        //neesita revision el carro
        if (carro.getNivel() == 1)
            nivel1.add(carro);
            ColasUI.actualizarNivel1 = true;
                if (carro.getNivel() == 2)
                    nivel2.add(carro);
                    ColasUI.actualizarNivel2 = true;
                        if (carro.getNivel() == 3)
                            nivel3.add(carro);
                            ColasUI.actualizarNivel3 = true;
                    
        }
        if(carro.getEstado()==0){
            System.out.println("Algo malo paso");
        }
        
    }


    public void reencolarEspera(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3, Queue CEspera){
    
    if (carro.getEstado() ==4 ){
        if(carro.getNivel() == 1){
        nivel1.add(CEspera.poll());         
        }
        if(carro.getNivel() == 2){
        nivel2.add(CEspera.poll());         
        }
        if(carro.getNivel() == 3){
        nivel3.add(CEspera.poll());         
        }
    }
    else {
        System.out.println("sigues esperando chamito :(");
    }
    
    }


    public void crearCarro(){
      if(Mecanico.carrosRevisados == 2){
      carroAux = new Carro();
      Mecanico.carrosRevisados=0;
      System.out.println("El admin creo un carro");
      }
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
