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
        //Interfaz I = new  Interfaz ();
        //I.setVisible(true);
        
       //System.out.println(I.demanda_d[0][1]);
       // 
       /*
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 9 ; j++){ 
               d[i][j]=I.demanda_d[i][j];
           } 
         }
         
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 3 ; j++){ 
              tent[i][j]=I.t_entrega[i][j];
           } 
         }
         
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 4 ; j++){ 
               tesp[i][j]=I.t_espera[i][j];
           } 
         }
        
         
         */
         
         /*
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 9 ; j++){ 
              System.out.println( d[i][j]);
           } 
         }
         
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 3 ; j++){ 
             System.out.println( tent[i][j]);
           } 
         }
         
         for (int i =0 ; i <= 1 ; i++){
           for (int j =0 ; j <= 4 ; j++){ 
              System.out.println( tesp[i][j]);
           } 
         }
         
         
         */
         
        
        
      
        
        p.setDemanda(d);
        p.setTiempoEntrega(tent);
        p.setTiempoEspera(tesp);
        
       
       //p.imprimir();
      /* PoliticaInventario poli = new PoliticaInventario(52.0, 100.0,20.0, 50.0, 50);
       poli.setQ(100);
       poli.setR(75);*/
       Archivos a  = new Archivos();
        try {
            a.escribirProbabilidades(p);
        } catch (IOException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Probabilidades aux;
            aux = a.leerProbabilidades();
            PoliticaInventario poli = new PoliticaInventario(52.0, 100.0,20.0, 50.0, 50);
            Intervalo i = new Intervalo(poli.getCosto_inventario(),poli.getCosto_orden(),poli.getCosto_con_espera(),poli.getCosto_sin_espera(),p,365);
            Double Qmin,Qmax,Rmin,Rmax;
            Qmin =  Math.rint((100*(i.getQmin()))/100);
            Qmax = Math.rint((100*(i.getQmax()))/100);
            Rmin = Math.rint((100*(i.getRmin()))/100);
            Rmax = Math.rint((100*(i.getRmax()))/100);
           /* System.out.println("Qmin: " + Qmin);
            System.out.println("Qmax: " + Qmax);
            System.out.println("Rmin: " + Rmin);
            System.out.println("Rmax: " + Rmax);*/
            PoliticaInventario poliopt = null;
            Double costo_menor=9999999999999999999999999999999999999999999999.0;
            for (int q = Qmin.intValue() ; q <= Qmax.intValue() ; q++){
                for (int r = Rmin.intValue() ; r<= Rmax.intValue() ;r++){
                    poli = new PoliticaInventario(52.0, 100.0,20.0, 50.0, 50);
                    poli.setQ(q);
                    poli.setR(r);
                    Simulacion s = new Simulacion (poli,p);
                    s.run();
                    if (s.getCostoTotal() < costo_menor){
                        costo_menor = s.getCostoTotal();
                        poliopt = poli;
                    }
                }
            }
            
            System.out.println("poliopt q:" +poliopt.getQ() + " r:"+poliopt.getR() + "costo: "+ costo_menor );
            poliopt.imprimirTabla();
            
            /*poli.setQ(294);
            poli.setR(136);
             Simulacion s = new Simulacion (poli,p);
                    s.run();
                    poli.imprimirTabla();*/
            
        } catch (IOException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoInvo.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
       
        
       /* Simulacion s = new Simulacion (poli,p);
        s.run();*/
        
    }
    
}
