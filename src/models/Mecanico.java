
package models;

public class Mecanico {
    private int random;
    private boolean revisando;
    private int carrosRevisados = 0;

    public Mecanico() {
    }
    
    
    public Carro revisarCarro(Carro carro){
        random = (int)(Math.random()*(10-1+1)+1);
        if(random <=3){
            carrosRevisados++;
            carro.setEstado(1);
            return carro;
        }
        if(random >3 && random<=5){
            carro.setEstado(2);
            return carro;
        }
        if(random > 5){
            carro.setEstado(3);
            return carro;
        }
    return carro;
    }
}
