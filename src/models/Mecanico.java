
package models;

import java.util.Queue;
import views.ColasUI;

public class Mecanico {
    private int random;
    public static int carrosRevisados = 0; 

    public Mecanico() {
    }
    
    public Carro revisarCarro(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3) throws InterruptedException{
        if(carro != null){
            //entra un carro y el mecánico lo revisa 
            ColasUI.ID.setText(Integer.toString(carro.getId()));
            
            //se tarda 5 segundos revisando un carro
            Thread.sleep(5000);
            
            //se crea un número random entre 1 y 10 
            random = (int)(Math.random()*(10-1+1)+1); 
            
            //se le suma uno al contador de los carros que siguen en las colas
            //al hacer poll a la cola el carro en revisión ya no se encuentra en su cola de nivel 
            sumaCont(nivel1, nivel2, nivel3);
            
            //se pone el contador en cero del carro que se está revisando
            carro.setCont(0);
            
                if(random <= 3){
                    //tiene un probabilidad del 30% de salir al mercado (si el random es igual a 1, 2 o 3)
                    System.out.println("Está botado el carro de id " +carro.getId());
                    carrosRevisados++;
                    //se cambia el estado del carro a 1 lo que significa que saldrá al mercado 
                    carro.setEstado(1);
                    return carro;
                }
                if(random > 3 && random <= 5){
                    //tiene probabilidad del 20% de requerir alguna mejora es igual a 4 o 5 
                    System.out.println("Le toca esperar al carro de id " +carro.getId());
                    carrosRevisados++;
                    //se cambia el estado del carro a 2 lo que significa que va a la cola de esperando 
                    carro.setEstado(2);
                    return carro;
                }
                if(random > 5){
                    //tiene probabilidad del 50% de volver a encolarse porque necesita más tiempo de revisión (si el random es igual a 6, 7, 8, 9 o 10 
                    System.out.println("Vuelve a la cola el carro de id " +carro.getId());
                    carrosRevisados++;
                    //se cambia el estado del carro a 3 lo que significa que se vuelve a encolar en la cola de su nivel
                    carro.setEstado(3);
                    return carro;
                }
        }
    System.out.println("No se reviso ningún carro");
    carrosRevisados++;
    return null;
    }
    
    //función para ver si sale un carro que está en la cola de esperando 
    public Carro sacarCarroEspera(Carro carro){
        //se genera un número random entre 1 y 10
        random = (int)(Math.random()*(10-1+1)+1);
    
        //tiene 60% de probabilidades de salir de la cola (si random es 1, 2, 3, 4, 5 o 6
        if(random <=6){
            ColasUI.actualizarEsperando = true;
            //se cambia el estado del carro a 4 que significa que saldrá de la cola de esperando 
            carro.setEstado(4);
            return carro;
        } 
        return null;
    }
    
    public void sumaCont(Queue nivel1, Queue nivel2, Queue nivel3) throws InterruptedException{
        Carro carroAux;
        if(!(nivel1.isEmpty())){
            for(int i=1; i<=nivel1.size(); i++){
                carroAux = (Carro) nivel1.poll();
                //se le suma uno al contador del carro
                carroAux.setCont(carroAux.getCont()+1);
                nivel1.add(carroAux);
            }
        }
        if(!(nivel2.isEmpty())){
            for(int i=1; i<=nivel2.size(); i++){
                carroAux = (Carro) nivel2.poll();
                //se le suma uno al contador del carro
                carroAux.setCont(carroAux.getCont()+1);
                    //si el contador es igual a 10 sube al nivel 1
                    if(carroAux.getCont()==10){
                        System.out.println("Subio del nivel el carro de id: " +carroAux.getId());
                        carroAux.setCont(0);
                        ColasUI.actualizarNivel2 = true;
                        nivel1.add(carroAux);
                        carroAux.setNivel(1);
                        ColasUI.actualizarNivel1 = true;
                    }
                    else{nivel2.add(carroAux);}
            }
        }
        if(!(nivel3.isEmpty())){
            for(int i=1; i<=nivel3.size(); i++){
                carroAux = (Carro) nivel3.poll();
                //se le suma uno al contador del carro
                carroAux.setCont(carroAux.getCont()+1);
                    //si el contador es igual a 10 sube al nivel 2
                    if(carroAux.getCont()==10){
                        System.out.println("Subio del nivel el carro de id: " +carroAux.getId());
                        carroAux.setCont(0);
                        ColasUI.actualizarNivel3 = true;
                        nivel2.add(carroAux);
                        carroAux.setNivel(2);
                        ColasUI.actualizarNivel2 = true;
                    }
                    else{nivel3.add(carroAux);}
            }           
        }
    }
    
}
