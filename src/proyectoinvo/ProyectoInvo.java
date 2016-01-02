/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ProyectoInvo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Double d[][] =new Double[2][10];
        Double tent[][]=new Double[2][4];
        Double tesp[][]=new Double[2][5];
        
        d[0][0] = 25.0;
        d[0][1] = 26.0;
        d[0][2] = 27.0;
        d[0][3] = 28.0;
        d[0][4] = 29.0;
        d[0][5] = 30.0;
        d[0][6] = 31.0;
        d[0][7] = 35.0;
        d[0][8] = 33.0;
        d[0][9] = 34.0;
        
        d[1][0] = 0.02;
        d[1][1] = 0.04;
        d[1][2] = 0.06;
        d[1][3] = 0.12;
        d[1][4] = 0.20;
        d[1][5] = 0.24;
        d[1][6] = 0.15;
        d[1][7] = 0.10;
        d[1][8] = 0.05;
        d[1][9] = 0.02;
        
        tent[0][0] = 1.0;
        tent[0][1] = 2.0;
        tent[0][2] = 3.0;
        tent[0][3] = 4.0;
        
        tent[1][0] = 0.2;
        tent[1][1] = 0.3;
        tent[1][2] = 0.25;
        tent[1][3] = 0.25;
        
        tesp[0][0] = 0.0;
        tesp[0][1] = 1.0;
        tesp[0][2] = 2.0;
        tesp[0][3] = 3.0;
        tesp[0][4] = 4.0;
        
        tesp[1][0] = 0.4;
        tesp[1][1] = 0.2;
        tesp[1][2] = 0.15;
        tesp[1][3] = 0.15;
        tesp[1][4] = 0.1;
                
        Probabilidades p = new Probabilidades();
        
        p.setDemanda(d);
        p.setTiempoEntrega(tent);
        p.setTiempoEspera(tesp);
        
        
       // p.imprimir();
       Archivos a  = new Archivos();
        try {
            a.escribirProbabilidades(p);
        } catch (IOException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Probabilidades aux;
            aux = a.leerProbabilidades();
            System.out.println("lectura exitosa");
            aux.imprimir();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }
    
}
