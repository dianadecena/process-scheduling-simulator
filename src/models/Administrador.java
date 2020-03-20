
package models;

import java.util.LinkedList;
import java.util.Queue;
import views.ColasUI;

public class Administrador {
    private Carro carroAux;
    //cola para carros esperando
    public Queue<Carro> carrosEsperando; 
    //cola de para carros de prioridad 1
    public Queue<Carro> nivel1;
    //cola de para carros de prioridad 2
    public Queue<Carro> nivel2;
    //cola de para carros de prioridad 3
    public Queue<Carro> nivel3;

    public Administrador() {
        //creación de colas
        carrosEsperando = new LinkedList<>(); 
        nivel1 = new LinkedList<>();
        nivel2 = new LinkedList<>();
        nivel3 = new LinkedList<>(); 
    }
    
    //enviar carro al mecánico para su revisión
    public Carro enviarCarroListo() throws InterruptedException{
        //revisar las colas empezando por la de nivel 1 
            if(!(nivel1.isEmpty())){
                //se hace un poll muestra la cabeza de la cola y luego la elimina 
                carroAux = (Carro) nivel1.poll();
                ColasUI.actualizarNivel1 = true;
                return carroAux;
            } else if(!(nivel2.isEmpty())){
                //se hace un poll muestra la cabeza de la cola y luego la elimina 
                carroAux = (Carro) nivel2.poll();
                ColasUI.actualizarNivel2 = true;
                return carroAux;
            } else if(!(nivel3.isEmpty())){
                //se hace un poll muestra la cabeza de la cola y luego la elimina 
                carroAux = (Carro) nivel3.poll();
                ColasUI.actualizarNivel3 = true;
                return carroAux;
            }
        ColasUI.ID.setText(Integer.toString(0));
        return null;
    }
    
    //enviar carro de la cola de esperando para ver si sale o no de la cola 
    public Carro enviarCarroEspera(){
        if(!(carrosEsperando.isEmpty())){
            //se hace un peek lo que muestra la cabeza de la cola pero no la elimina
            carroAux = (Carro)carrosEsperando.peek();
            return carroAux;
        }
    return null;
    }

    //actualizar las colas de los niveles 
    public void reencolarListos(Carro carro) throws InterruptedException {
        if(carro != null){
            //si el estado del carro es igual a 1 sale del mercado 
            if(carro.getEstado() == 1){
                //revisar a que cola de prioridad pertenece el carro que salió 
                if(carro.getNivel() == 1){
                    //solo se actualiza la interfaz porque ya se hizo un poll anteriormente que eliminó al carro de la cola 
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    //solo se actualiza la interfaz porque ya se hizo un poll anteriormente que eliminó al carro de la cola 
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    //solo se actualiza la interfaz porque ya se hizo un poll anteriormente que eliminó al carro de la cola 
                    ColasUI.actualizarNivel3 = true;
                } 
            }
            //si el estado del carro es igual a 2 se va a la cola de esperando 
            if(carro.getEstado() == 2){
                //revisar a que cola de prioridad pertenece el carro 
                if(carro.getNivel() == 1){
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    ColasUI.actualizarNivel3 = true;
                }  
                //se agrega en la cola de esperando 
                carrosEsperando.add(carro);
                ColasUI.actualizarEsperando = true;
            }
            //si el estado del carro es igual a 3 se vuelve a encolar en la cola de su nivel 
            if(carro.getEstado() == 3){
                //revisar a que cola de prioridad pertenece el carro 
                if(carro.getNivel() == 1){
                    //se vuelve a encolar en su cola de nivel 
                    nivel1.add(carro);
                    ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                    //se vuelve a encolar en su cola de nivel 
                    nivel2.add(carro);
                    ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                    //se vuelve a encolar en su cola de nivel 
                    nivel3.add(carro);
                    ColasUI.actualizarNivel3 = true;
                }           
            }
            if(carro.getEstado() == 0){
                System.out.println("Algo malo paso");
            }
        }
    }

    //actualizar cola de carros esperando 
    public void reencolarEspera(Carro carro){
        if(carro != null){
            //si el estado del carro es igual a 4 vuelve a su cola de nivel 
            if(carro.getEstado() == 4){
              System.out.println("Vuelve a su cola el carro de id: "+carro.getId());
                //verificar a que cola pertenece el carro 
                if(carro.getNivel() == 1){
                  //se vuelve a encolar en su nivel el carro que salió de la cola de esperando 
                  nivel1.add(carrosEsperando.poll()); 
                  ColasUI.actualizarNivel1 = true;
                }
                if(carro.getNivel() == 2){
                   //se vuelve a encolar en su nivel el carro que salió de la cola de esperando 
                   nivel2.add(carrosEsperando.poll()); 
                   ColasUI.actualizarNivel2 = true;
                }
                if(carro.getNivel() == 3){
                   //se vuelve a encolar en su nivel el carro que salió de la cola de esperando 
                   nivel3.add(carrosEsperando.poll());  
                   ColasUI.actualizarNivel3 = true;
                }
        } else {
        System.out.println("sigues esperando chamito :(");
        }
        }
    }

    //se crea un carro nuevo 
    public Carro crearCarro(){
        carroAux = new Carro();
        return carroAux;
    }
    
    //agregar carros a las colas de prioridad 
    public void agregarCarroACola(Carro carro){
        if(carro != null){
            //si es de nivel 1 se encolan en la cola de nivel 1
            if(carro.getNivel() == 1){
                System.out.println("CARROS NIVEL 1: " +carro.getId());
                nivel1.add(carro);
                ColasUI.actualizarNivel1 = true;
            }
            if(carro.getNivel() == 2){
                //si es de nivel 2 se encolan en la cola de nivel 2
                System.out.println("CARROS NIVEL 2: " +carro.getId());
                nivel2.add(carro);
                ColasUI.actualizarNivel2 = true;
            } 
            if(carro.getNivel() == 3){
                //si es de nivel 3 se encolan en la cola de nivel 3
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
   