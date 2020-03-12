
package models;

import java.util.Queue;
import views.ColasUI;

public class Mecanico {
    private int random;
    private boolean revisando;
    public static int carrosRevisados = 0;

    public Mecanico() {
    }
    
    
    public Carro revisarCarro(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3){
        random = (int)(Math.random()*(10-1+1)+1);
        sumaCont(carro, nivel1, nivel2, nivel3);
        carro.setCont(0);
        if(random <= 3){
            System.out.println("Está botado el carro de id " +carro.getId());
            ColasUI.idRevision = carro.getId();
            carrosRevisados++;
            carro.setEstado(1);
            return carro;
        }
        if(random > 3 && random <= 5){
            System.out.println("Le toca esperar al carro de id " +carro.getId());
            ColasUI.idRevision = carro.getId();
            carro.setEstado(2);
            carrosRevisados++;
            return carro;
        }
        if(random > 5){
            System.out.println("Vuelve a la cola el carro de id " +carro.getId());
            ColasUI.idRevision = carro.getId();
            carro.setEstado(3);
            carrosRevisados++;
            return carro;
        }
    return carro;
    }
    
    public Carro sacarCarroEspera(Carro carro){
    random = (int)(Math.random()*(10-1+1)+1);
    
    if (random <=6){
        carro.setEstado(4);
        carrosRevisados++;
        return carro;
    }
    else {
        return carro;
    }
    }
    
    public void sumaCont(Carro carro, Queue nivel1, Queue nivel2, Queue nivel3){
        Carro carroAux;
        if(!(nivel1.isEmpty())){
            for(int i=1; i<=nivel1.size(); i++){
                
                carroAux = (Carro) nivel1.poll();
                carroAux.setCont(carroAux.getCont()+1);
                nivel1.add(carroAux);
                }
    }
        if(!(nivel2.isEmpty())){
            for(int i=1; i<=nivel2.size(); i++){
                carroAux = (Carro) nivel2.poll();
                carroAux.setCont(carroAux.getCont()+1);
                if(carroAux.getCont()==10){
                nivel1.add(carroAux);
                carroAux.setNivel(1);
                }
                else{nivel2.add(carroAux);}
                }
    }
        if(!(nivel3.isEmpty())){
            for(int i=1; i<=nivel3.size(); i++){
                carroAux = (Carro) nivel3.poll();
                carroAux.setCont(carroAux.getCont()+1);
                if(carroAux.getCont()==10){
                    nivel2.add(carroAux);
                    carroAux.setNivel(2);
                }
                    else{nivel3.add(carroAux);}
                }
                
                
    }
}
}
