
package views;

import controllers.Simulacion;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import models.*;


public class ColasUI extends javax.swing.JFrame {

    private Simulacion simulacion;
    private int cont1, cont2, cont3, cont4;
    public static boolean actualizarNivel1 = false;
    public static boolean actualizarNivel2 = false;
    public static boolean actualizarNivel3 = false;
    public static boolean actualizarEsperando = false;
    public static int idRevision = 0;

    public ColasUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        simulacion = new Simulacion();
        
        //COLA NIVEL 1
        nivel11.setVisible(false);
        nivel12.setVisible(false);
        nivel13.setVisible(false);
        nivel14.setVisible(false);
        nivel15.setVisible(false);
        nivel16.setVisible(false);
        nivel17.setVisible(false);
        nivel18.setVisible(false);
        nivel19.setVisible(false);
        nivel110.setVisible(false);
        nivel111.setVisible(false);
        nivel112.setVisible(false);
        nivel113.setVisible(false);
        
        
        //COLA NIVEL 2 
        nivel21.setVisible(false);
        nivel22.setVisible(false);
        nivel23.setVisible(false);
        nivel24.setVisible(false);
        nivel25.setVisible(false);
        nivel26.setVisible(false);
        nivel27.setVisible(false);
        nivel28.setVisible(false);
        nivel29.setVisible(false);
        nivel210.setVisible(false);
        nivel211.setVisible(false);
        nivel212.setVisible(false);
        nivel213.setVisible(false);
        
        //COLA NIVEL 3
        nivel31.setVisible(false);
        nivel32.setVisible(false);
        nivel33.setVisible(false);
        nivel34.setVisible(false);
        nivel35.setVisible(false);
        nivel36.setVisible(false);
        nivel37.setVisible(false);
        nivel38.setVisible(false);
        nivel39.setVisible(false);
        nivel310.setVisible(false);
        nivel311.setVisible(false);
        nivel312.setVisible(false);
        nivel313.setVisible(false);
        
        //COLA CARROS ESPERANDO
        e2.setVisible(false);
        e1.setVisible(false);
        e3.setVisible(false);
        e4.setVisible(false);
        e5.setVisible(false);
        e6.setVisible(false);
        e7.setVisible(false);
        e8.setVisible(false);
        e9.setVisible(false);
        e10.setVisible(false);
        e11.setVisible(false);

            
        Timer timer = new Timer(1, (ActionEvent ae) -> { 
            try {
                simulacion.iniciarSimulacion();
            } catch (InterruptedException ex) {
                Logger.getLogger(ColasUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            if(actualizarNivel1){
                //obtener el tamano de la cola 
                cont1 = simulacion.getAdmin().getNivel1().size();
                nivel11.setVisible(false);
                nivel12.setVisible(false);
                nivel13.setVisible(false);
                nivel14.setVisible(false);
                nivel15.setVisible(false);
                nivel16.setVisible(false);
                nivel17.setVisible(false);
                nivel18.setVisible(false);
                nivel19.setVisible(false);
                nivel110.setVisible(false);
                nivel111.setVisible(false);
                nivel112.setVisible(false);
                nivel113.setVisible(false);
                //actualizar cola de nivel 1
                this.encolarCarrosNivel1();
            }
            if(actualizarNivel2){
                //obtener el tamano de la cola
                cont2 = simulacion.getAdmin().getNivel2().size();
                nivel21.setVisible(false);
                nivel22.setVisible(false);
                nivel23.setVisible(false);
                nivel24.setVisible(false);
                nivel25.setVisible(false);
                nivel26.setVisible(false);
                nivel27.setVisible(false);
                nivel28.setVisible(false);
                nivel29.setVisible(false);
                nivel210.setVisible(false);
                nivel211.setVisible(false);
                nivel212.setVisible(false);
                nivel213.setVisible(false);
                //actualizar cola de nivel 2
                this.encolarCarrosNivel2();
            }
            if(actualizarNivel3){
                //obtener el tamano de la cola
                cont3 = simulacion.getAdmin().getNivel3().size();
                nivel31.setVisible(false);
                nivel32.setVisible(false);
                nivel33.setVisible(false);
                nivel34.setVisible(false);
                nivel35.setVisible(false);
                nivel36.setVisible(false);
                nivel37.setVisible(false);
                nivel38.setVisible(false);
                nivel39.setVisible(false);
                nivel310.setVisible(false);
                nivel311.setVisible(false);
                nivel312.setVisible(false);
                nivel313.setVisible(false);
                //actualizar cola de nivel 3
                this.encolarCarrosNivel3();
            }
            if(actualizarEsperando){
                //obtener el tamano de la cola
                cont4 = simulacion.getAdmin().getCarrosEsperando().size();
                e2.setVisible(false);
                e1.setVisible(false);
                e3.setVisible(false);
                e4.setVisible(false);
                e5.setVisible(false);
                e6.setVisible(false);
                e7.setVisible(false);
                e8.setVisible(false);
                e9.setVisible(false);
                e10.setVisible(false);
                e11.setVisible(false);
                //actualizar cola de carros esperando
                this.encolarCarrosEsperando();
            }
        });
        
        timer.start();
    }
    
    public void encolarCarrosNivel1(){
          if(!(simulacion.getAdmin().getNivel1().isEmpty())){
                if(cont1==simulacion.getAdmin().getNivel1().size()){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        if(carroAux != null){
                            nivel11.setVisible(true);
                            elem11.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel1(carroAux);
                            cont1--;
                        }
                }
                if((cont1==simulacion.getAdmin().getNivel1().size()-1) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        if(carroAux != null){
                            nivel12.setVisible(true);
                            elem12.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel1(carroAux);
                            cont1--;
                        }
                }
                if((cont1==simulacion.getAdmin().getNivel1().size()-2) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel13.setVisible(true);
                        elem13.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-3) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel14.setVisible(true);
                        elem14.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-4) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel15.setVisible(true);
                        elem15.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-5) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel16.setVisible(true);
                        elem16.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-6) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel17.setVisible(true);
                        elem17.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-7) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel18.setVisible(true);
                        elem18.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-8) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel19.setVisible(true);
                        elem19.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-9) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel110.setVisible(true);
                        elem110.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-10) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel111.setVisible(true);
                        elem111.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-11) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel112.setVisible(true);
                        elem112.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getAdmin().getNivel1().size()-12) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel1().poll();
                        nivel113.setVisible(true);
                        elem113.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel1(carroAux);
                        cont1--;
                } 
        } 
    actualizarNivel1 = false;
    }
    
    public void encolarCarrosNivel2(){
        if(!(simulacion.getAdmin().getNivel2().isEmpty())){
                if(cont2==simulacion.getAdmin().getNivel2().size()){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        if(carroAux != null){
                            nivel21.setVisible(true);
                            elem21.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel2(carroAux);
                            cont2--;
                        }
                }
                if((cont2==simulacion.getAdmin().getNivel2().size()-1) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        if(carroAux != null){
                            nivel22.setVisible(true);
                            elem22.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel2(carroAux);
                            cont2--;
                        }
                }
                if((cont2==simulacion.getAdmin().getNivel2().size()-2) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel23.setVisible(true);
                        elem23.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }     
                if((cont2==simulacion.getAdmin().getNivel2().size()-3) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel24.setVisible(true);
                        elem24.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-4) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel25.setVisible(true);
                        elem25.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-5) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel26.setVisible(true);
                        elem26.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-6) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel27.setVisible(true);
                        elem27.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-7) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel28.setVisible(true);
                        elem28.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-8) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel29.setVisible(true);
                        elem29.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-9) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel210.setVisible(true);
                        elem210.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-10) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel211.setVisible(true);
                        elem211.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-11) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel212.setVisible(true);
                        elem212.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
                if((cont2==simulacion.getAdmin().getNivel2().size()-12) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel2().poll();
                        nivel213.setVisible(true);
                        elem213.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel2(carroAux);
                        cont2--;
                }  
        }  
    actualizarNivel2 = false;
    }
    
    public void encolarCarrosNivel3(){
           if(!(simulacion.getAdmin().getNivel3().isEmpty())){
                if(cont3==simulacion.getAdmin().getNivel3().size()){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        if(carroAux != null){
                            nivel31.setVisible(true);
                            elem31.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel3(carroAux);
                            cont3--;
                        }
                }
                if((cont3==simulacion.getAdmin().getNivel3().size()-1) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        if(carroAux != null){
                            nivel32.setVisible(true);
                            elem32.setText(Integer.toString(carroAux.getId()));
                            simulacion.getAdmin().setNivel3(carroAux);
                            cont3--;
                        }
                }
                if((cont3==simulacion.getAdmin().getNivel3().size()-2) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }    
                if((cont3==simulacion.getAdmin().getNivel3().size()-3) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-4) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-5) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-6) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-7) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-8) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-9) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-10) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-11) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
                if((cont3==simulacion.getAdmin().getNivel3().size()-12) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setNivel3(carroAux);
                        cont3--;
                }  
        } 
    actualizarNivel3 = false;
    }
    
    public void encolarCarrosEsperando(){
          if(!(simulacion.getAdmin().getCarrosEsperando().isEmpty())){
                if(cont4==simulacion.getAdmin().getCarrosEsperando().size()){
                        Carro carroAux = (Carro) simulacion.getAdmin().getCarrosEsperando().poll();
                        e1.setVisible(true);
                        elem41.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setCarrosEsperando(carroAux);
                        cont4--;
                }
                if((cont4==simulacion.getAdmin().getCarrosEsperando().size()-1) && cont4 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getCarrosEsperando().poll();
                        e2.setVisible(true);
                        elem42.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setCarrosEsperando(carroAux);
                        cont4--;
                }
                if((cont4==simulacion.getAdmin().getCarrosEsperando().size()-2) && cont4 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getCarrosEsperando().poll();
                        e3.setVisible(true);
                        elem43.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setCarrosEsperando(carroAux);
                        cont4--;
                } 
                if((cont4==simulacion.getAdmin().getCarrosEsperando().size()-3) && cont4 > 0){
                        Carro carroAux = (Carro) simulacion.getAdmin().getCarrosEsperando().poll();
                        e4.setVisible(true);
                        elem44.setText(Integer.toString(carroAux.getId()));
                        simulacion.getAdmin().setCarrosEsperando(carroAux);
                        cont4--;
                } 
        } 
    actualizarEsperando = false;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elem11 = new javax.swing.JLabel();
        nivel11 = new javax.swing.JLabel();
        elem12 = new javax.swing.JLabel();
        nivel12 = new javax.swing.JLabel();
        elem13 = new javax.swing.JLabel();
        nivel13 = new javax.swing.JLabel();
        elem14 = new javax.swing.JLabel();
        nivel14 = new javax.swing.JLabel();
        elem15 = new javax.swing.JLabel();
        nivel15 = new javax.swing.JLabel();
        elem16 = new javax.swing.JLabel();
        nivel16 = new javax.swing.JLabel();
        elem17 = new javax.swing.JLabel();
        nivel17 = new javax.swing.JLabel();
        elem18 = new javax.swing.JLabel();
        nivel18 = new javax.swing.JLabel();
        elem19 = new javax.swing.JLabel();
        nivel19 = new javax.swing.JLabel();
        elem110 = new javax.swing.JLabel();
        nivel110 = new javax.swing.JLabel();
        elem111 = new javax.swing.JLabel();
        nivel111 = new javax.swing.JLabel();
        elem112 = new javax.swing.JLabel();
        nivel112 = new javax.swing.JLabel();
        elem113 = new javax.swing.JLabel();
        nivel113 = new javax.swing.JLabel();
        elem21 = new javax.swing.JLabel();
        nivel21 = new javax.swing.JLabel();
        elem22 = new javax.swing.JLabel();
        nivel22 = new javax.swing.JLabel();
        elem23 = new javax.swing.JLabel();
        nivel23 = new javax.swing.JLabel();
        elem24 = new javax.swing.JLabel();
        nivel24 = new javax.swing.JLabel();
        elem25 = new javax.swing.JLabel();
        nivel25 = new javax.swing.JLabel();
        elem26 = new javax.swing.JLabel();
        nivel26 = new javax.swing.JLabel();
        elem27 = new javax.swing.JLabel();
        nivel27 = new javax.swing.JLabel();
        elem28 = new javax.swing.JLabel();
        nivel28 = new javax.swing.JLabel();
        elem29 = new javax.swing.JLabel();
        nivel29 = new javax.swing.JLabel();
        elem210 = new javax.swing.JLabel();
        nivel210 = new javax.swing.JLabel();
        elem211 = new javax.swing.JLabel();
        nivel211 = new javax.swing.JLabel();
        elem212 = new javax.swing.JLabel();
        nivel212 = new javax.swing.JLabel();
        elem213 = new javax.swing.JLabel();
        nivel213 = new javax.swing.JLabel();
        elem31 = new javax.swing.JLabel();
        nivel31 = new javax.swing.JLabel();
        elem32 = new javax.swing.JLabel();
        nivel32 = new javax.swing.JLabel();
        elem33 = new javax.swing.JLabel();
        nivel33 = new javax.swing.JLabel();
        elem34 = new javax.swing.JLabel();
        nivel34 = new javax.swing.JLabel();
        elem35 = new javax.swing.JLabel();
        nivel35 = new javax.swing.JLabel();
        elem36 = new javax.swing.JLabel();
        nivel36 = new javax.swing.JLabel();
        elem37 = new javax.swing.JLabel();
        nivel37 = new javax.swing.JLabel();
        elem38 = new javax.swing.JLabel();
        nivel38 = new javax.swing.JLabel();
        elem39 = new javax.swing.JLabel();
        nivel39 = new javax.swing.JLabel();
        elem310 = new javax.swing.JLabel();
        nivel310 = new javax.swing.JLabel();
        elem311 = new javax.swing.JLabel();
        nivel311 = new javax.swing.JLabel();
        elem312 = new javax.swing.JLabel();
        nivel312 = new javax.swing.JLabel();
        elem313 = new javax.swing.JLabel();
        nivel313 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        elem41 = new javax.swing.JLabel();
        e1 = new javax.swing.JLabel();
        elem42 = new javax.swing.JLabel();
        e2 = new javax.swing.JLabel();
        elem43 = new javax.swing.JLabel();
        e3 = new javax.swing.JLabel();
        elem44 = new javax.swing.JLabel();
        e4 = new javax.swing.JLabel();
        e5 = new javax.swing.JLabel();
        e6 = new javax.swing.JLabel();
        e7 = new javax.swing.JLabel();
        e8 = new javax.swing.JLabel();
        e9 = new javax.swing.JLabel();
        e10 = new javax.swing.JLabel();
        e11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        elem11.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem11.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem11, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 210, 40, 30));

        nivel11.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel11.setForeground(new java.awt.Color(0, 0, 0));
        nivel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        nivel11.setToolTipText("");
        getContentPane().add(nivel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 184, -1, -1));

        elem12.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem12.setForeground(new java.awt.Color(0, 0, 0));
        elem12.setToolTipText("");
        getContentPane().add(elem12, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 210, 50, 30));

        nivel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 184, -1, -1));

        elem13.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem13.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem13, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 210, -1, -1));

        nivel13.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel13.setForeground(new java.awt.Color(0, 0, 0));
        nivel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        nivel13.setText("4");
        getContentPane().add(nivel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 184, -1, -1));

        elem14.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem14.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem14, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 210, -1, -1));

        nivel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 184, -1, -1));

        elem15.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem15.setForeground(new java.awt.Color(0, 0, 0));
        elem15.setToolTipText("");
        getContentPane().add(elem15, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 210, -1, -1));

        nivel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 184, -1, -1));

        elem16.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem16.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem16, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 210, -1, -1));

        nivel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 184, -1, -1));

        elem17.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem17.setForeground(new java.awt.Color(0, 0, 0));
        elem17.setToolTipText("");
        getContentPane().add(elem17, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 210, -1, -1));

        nivel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 184, -1, -1));

        elem18.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem18.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem18, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 210, -1, -1));

        nivel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 184, -1, -1));

        elem19.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem19.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem19, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 210, -1, -1));

        nivel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 184, -1, -1));

        elem110.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem110.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem110, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 210, -1, -1));

        nivel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        nivel110.setToolTipText("");
        getContentPane().add(nivel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 184, -1, -1));

        elem111.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem111.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem111, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        nivel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 184, -1, -1));

        elem112.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem112.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem112, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 210, -1, -1));

        nivel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 184, -1, -1));

        elem113.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem113.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem113, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 210, -1, -1));

        nivel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 184, -1, -1));

        elem21.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem21.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem21, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 294, -1, -1));

        nivel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 265, -1, -1));

        elem22.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem22.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem22, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 294, -1, -1));

        nivel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 265, -1, -1));

        elem23.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem23.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem23, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 294, -1, -1));

        nivel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 265, -1, -1));

        elem24.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem24.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem24, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 294, -1, -1));

        nivel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 265, -1, -1));

        elem25.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem25.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem25, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 294, -1, -1));

        nivel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 265, -1, -1));

        elem26.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem26.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem26, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 294, -1, -1));

        nivel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        nivel26.setToolTipText("");
        getContentPane().add(nivel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 265, -1, -1));

        elem27.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem27.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem27, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 294, -1, -1));

        nivel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 265, -1, -1));

        elem28.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem28.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem28, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 294, -1, -1));

        nivel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 265, -1, -1));

        elem29.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem29.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem29, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 294, -1, -1));

        nivel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 265, -1, -1));

        elem210.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem210.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem210, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 294, -1, -1));

        nivel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 265, -1, -1));

        elem211.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem211.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem211, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 294, -1, -1));

        nivel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 265, -1, -1));

        elem212.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem212.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem212, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 294, -1, -1));

        nivel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 265, -1, -1));

        elem213.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem213.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem213, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 294, -1, -1));

        nivel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 265, -1, -1));

        elem31.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem31.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem31, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 372, 30, -1));

        nivel31.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel31.setForeground(new java.awt.Color(0, 0, 0));
        nivel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        nivel31.setToolTipText("");
        getContentPane().add(nivel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 346, -1, -1));

        elem32.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem32.setForeground(new java.awt.Color(0, 0, 0));
        elem32.setToolTipText("");
        getContentPane().add(elem32, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 372, -1, -1));

        nivel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 346, -1, -1));

        elem33.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem33.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem33, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 372, -1, -1));

        nivel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 346, -1, -1));

        elem34.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem34.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem34, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 372, -1, -1));

        nivel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        nivel34.setToolTipText("");
        getContentPane().add(nivel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 346, -1, -1));

        elem35.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem35.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem35, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 372, -1, -1));

        nivel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 346, -1, -1));

        elem36.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem36.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem36, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 372, -1, -1));

        nivel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 346, -1, -1));

        elem37.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem37.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem37, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 372, -1, -1));

        nivel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 346, -1, -1));

        elem38.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem38.setForeground(new java.awt.Color(0, 0, 0));
        elem38.setToolTipText("");
        getContentPane().add(elem38, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 372, -1, -1));

        nivel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 346, -1, -1));

        elem39.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem39.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem39, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 372, -1, -1));

        nivel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 346, -1, -1));

        elem310.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem310.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem310, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 372, -1, -1));

        nivel310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel310, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 346, -1, -1));

        elem311.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem311.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem311, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 372, -1, -1));

        nivel311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel311, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 346, -1, -1));

        elem312.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem312.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem312, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 372, -1, -1));

        nivel312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        nivel312.setToolTipText("");
        getContentPane().add(nivel312, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 346, -1, -1));

        elem313.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem313.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem313, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 372, -1, -1));

        nivel313.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel313, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 346, -1, -1));

        ID.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        ID.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, 40, -1));

        elem41.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem41.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem41, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 538, -1, -1));

        e1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 510, -1, -1));

        elem42.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem42.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem42, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 538, -1, -1));

        e2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        e2.setToolTipText("");
        getContentPane().add(e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 510, -1, -1));

        elem43.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem43.setForeground(new java.awt.Color(0, 0, 0));
        elem43.setToolTipText("");
        getContentPane().add(elem43, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 538, -1, -1));

        e3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e3, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 510, -1, -1));

        elem44.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem44.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem44, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 538, -1, -1));

        e4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e4, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 510, -1, -1));

        e5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e5, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 510, -1, -1));

        e6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        e7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 510, -1, -1));

        e8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        e8.setToolTipText("");
        getContentPane().add(e8, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 510, -1, -1));

        e9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e9, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 510, -1, -1));

        e10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        getContentPane().add(e10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, -1, -1));

        e11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/esperando.png"))); // NOI18N
        e11.setToolTipText("");
        getContentPane().add(e11, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 510, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/colas-bg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColasUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ID;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e10;
    private javax.swing.JLabel e11;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JLabel e4;
    private javax.swing.JLabel e5;
    private javax.swing.JLabel e6;
    private javax.swing.JLabel e7;
    private javax.swing.JLabel e8;
    private javax.swing.JLabel e9;
    private javax.swing.JLabel elem11;
    private javax.swing.JLabel elem110;
    private javax.swing.JLabel elem111;
    private javax.swing.JLabel elem112;
    private javax.swing.JLabel elem113;
    private javax.swing.JLabel elem12;
    private javax.swing.JLabel elem13;
    private javax.swing.JLabel elem14;
    private javax.swing.JLabel elem15;
    private javax.swing.JLabel elem16;
    private javax.swing.JLabel elem17;
    private javax.swing.JLabel elem18;
    private javax.swing.JLabel elem19;
    private javax.swing.JLabel elem21;
    private javax.swing.JLabel elem210;
    private javax.swing.JLabel elem211;
    private javax.swing.JLabel elem212;
    private javax.swing.JLabel elem213;
    private javax.swing.JLabel elem22;
    private javax.swing.JLabel elem23;
    private javax.swing.JLabel elem24;
    private javax.swing.JLabel elem25;
    private javax.swing.JLabel elem26;
    private javax.swing.JLabel elem27;
    private javax.swing.JLabel elem28;
    private javax.swing.JLabel elem29;
    private javax.swing.JLabel elem31;
    private javax.swing.JLabel elem310;
    private javax.swing.JLabel elem311;
    private javax.swing.JLabel elem312;
    private javax.swing.JLabel elem313;
    private javax.swing.JLabel elem32;
    private javax.swing.JLabel elem33;
    private javax.swing.JLabel elem34;
    private javax.swing.JLabel elem35;
    private javax.swing.JLabel elem36;
    private javax.swing.JLabel elem37;
    private javax.swing.JLabel elem38;
    private javax.swing.JLabel elem39;
    private javax.swing.JLabel elem41;
    private javax.swing.JLabel elem42;
    private javax.swing.JLabel elem43;
    private javax.swing.JLabel elem44;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nivel11;
    private javax.swing.JLabel nivel110;
    private javax.swing.JLabel nivel111;
    private javax.swing.JLabel nivel112;
    private javax.swing.JLabel nivel113;
    private javax.swing.JLabel nivel12;
    private javax.swing.JLabel nivel13;
    private javax.swing.JLabel nivel14;
    private javax.swing.JLabel nivel15;
    private javax.swing.JLabel nivel16;
    private javax.swing.JLabel nivel17;
    private javax.swing.JLabel nivel18;
    private javax.swing.JLabel nivel19;
    private javax.swing.JLabel nivel21;
    private javax.swing.JLabel nivel210;
    private javax.swing.JLabel nivel211;
    private javax.swing.JLabel nivel212;
    private javax.swing.JLabel nivel213;
    private javax.swing.JLabel nivel22;
    private javax.swing.JLabel nivel23;
    private javax.swing.JLabel nivel24;
    private javax.swing.JLabel nivel25;
    private javax.swing.JLabel nivel26;
    private javax.swing.JLabel nivel27;
    private javax.swing.JLabel nivel28;
    private javax.swing.JLabel nivel29;
    private javax.swing.JLabel nivel31;
    private javax.swing.JLabel nivel310;
    private javax.swing.JLabel nivel311;
    private javax.swing.JLabel nivel312;
    private javax.swing.JLabel nivel313;
    private javax.swing.JLabel nivel32;
    private javax.swing.JLabel nivel33;
    private javax.swing.JLabel nivel34;
    private javax.swing.JLabel nivel35;
    private javax.swing.JLabel nivel36;
    private javax.swing.JLabel nivel37;
    private javax.swing.JLabel nivel38;
    private javax.swing.JLabel nivel39;
    // End of variables declaration//GEN-END:variables
}
