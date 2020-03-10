
package models;

import java.util.Queue;

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
    
    public void actualizarColaListos(Queue carrosListos, Queue nivel1, Queue nivel2, Queue nivel3){
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
    }
    
    public Carro enviarCarro(Queue carrosListos, Queue nivel1, Queue nivel2, Queue nivel3){
        carroAux = (Carro) carrosListos.poll();
        if(nivel1.peek() == carroAux)
            nivel1.remove();     
        if(nivel2.peek() == carroAux)
            nivel2.remove(); 
        if(nivel3.peek() == carroAux)
            nivel3.remove(); 
       return carroAux; 
    }

    public void reencolar(Carro carro) {
        if(carro.getEstado()==1){
        //se puede poner un print de un carro salio al mercado
        }
        if(carro.getEstado()==2){
        
        }
        if(carro.getEstado()==3){
        
        }
        if(carro.getEstado()==0){
            System.out.println("Halgo malo paso");
        }
        
    }
}
