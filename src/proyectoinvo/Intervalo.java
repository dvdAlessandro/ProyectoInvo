/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

/**
 *
 * @author Enrique
 */
public class Intervalo {
    private Double costo_inventario;
    private Double costo_orden;
    private Double costo_con_espera;
    private Double costo_sin_espera;
    private int dias;
    private Probabilidades p;

    public Intervalo(Double costo_inventario, Double costo_orden, Double costo_con_espera, Double costo_sin_espera, Probabilidades p,int dias) {
        this.costo_inventario = costo_inventario;
        this.costo_orden = costo_orden;
        this.costo_con_espera = costo_con_espera;
        this.costo_sin_espera = costo_sin_espera;
        this.p = p;
        this.dias = dias;
    }
    
    public Double getQmin(){
        Double mayor_costo_faltante;
        
        if (costo_con_espera > costo_sin_espera)
           mayor_costo_faltante = costo_con_espera;
        else
            mayor_costo_faltante = costo_sin_espera;
       // System.out.println("menor "+p.getMayorDemanda()*dias+" "+costo_orden+" "+costo_inventario+ " " +mayor_costo_faltante);
        return calcularQ(p.getMenorDemanda()*dias,costo_orden,costo_inventario,mayor_costo_faltante);
    }
    
    public Double getQmax(){
        Double menor_costo_faltante;
        
        if (costo_con_espera < costo_sin_espera)
           menor_costo_faltante = costo_con_espera;
        else
            menor_costo_faltante = costo_sin_espera;
        //System.out.println(p.getMayorDemanda()*dias+" "+costo_orden+" "+costo_inventario+ " " +menor_costo_faltante);
        return calcularQ(p.getMayorDemanda()*dias,costo_orden,costo_inventario,menor_costo_faltante);
    }
    
    public Double getRmin(){
        return p.getMenorTEnt() * p.getMenorDemanda();
    }
    
    public Double getRmax(){
        return p.getMayorTEnt() * p.getMayorDemanda();
    }
    
    
    public Double calcularQ(Double D, Double K, Double h, Double s){
        
        return Math.sqrt((2*K*D*(h+s))/(h*s));
        
    }
    
}
