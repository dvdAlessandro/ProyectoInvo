/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class PoliticaInventario implements Serializable {
    private Double costo_inventario;
    private Double costo_orden;
    private Double costo_con_espera;
    private Double costo_sin_espera;
    private Integer inventario_inicial;
    private Integer q;
    private Integer R;
    private ArrayList<Eventos> tabla_eventos;
    

    public PoliticaInventario(Double costo_inventario, Double costo_orden, Double costo_con_espera, Double costo_sin_espera, Integer inventario_inicial) {
        this.costo_inventario = costo_inventario;
        this.costo_orden = costo_orden;
        this.costo_con_espera = costo_con_espera;
        this.costo_sin_espera = costo_sin_espera;
        this.inventario_inicial = inventario_inicial;
        this.tabla_eventos = new ArrayList<Eventos>();
    }

    public Double getCosto_inventario() {
        return costo_inventario;
    }

    public void setCosto_inventario(Double costo_inventario) {
        this.costo_inventario = costo_inventario;
    }

    public Double getCosto_orden() {
        return costo_orden;
    }

    public void setCosto_orden(Double costo_orden) {
        this.costo_orden = costo_orden;
    }

    public Double getCosto_con_espera() {
        return costo_con_espera;
    }

    public void setCosto_con_espera(Double costo_con_espera) {
        this.costo_con_espera = costo_con_espera;
    }

    public Double getCosto_sin_espera() {
        return costo_sin_espera;
    }

    public void setCosto_sin_espera(Double costo_sin_espera) {
        this.costo_sin_espera = costo_sin_espera;
    }

    public Integer getInventario_inicial() {
        return inventario_inicial;
    }

    public void setInventario_inicial(Integer inventario_inicial) {
        this.inventario_inicial = inventario_inicial;
    }

    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }

    public Integer getR() {
        return R;
    }

    public void setR(Integer R) {
        this.R = R;
    }
    
    

    public ArrayList<Eventos> getTabla_eventos() {
        return tabla_eventos;
    }
    
    public void imprimirTabla (){
        Eventos evento;
         DecimalFormat decimales = new DecimalFormat("0.00");
        
        System.out.println("TABLA EVENTOS!................................>>><<<<<");
        System.out.println("\t Dia\t INVI\t ad\t DEM\t invf\t invp\t fal\t ord\t aent\t tent\t aesp\t tesp\t ");
        for (int i = 0 ; i <  this.tabla_eventos.size() ; i++){
            evento = tabla_eventos.get(i);
            System.out.print("\t" +evento.dia);
            System.out.print("\t" +evento.invi);
            System.out.print("\t" +decimales.format(evento.nro_ale_dem));
            System.out.print("\t" +evento.dem);
            System.out.print("\t" +evento.invf);
            System.out.print("\t" +evento.invp);
            if (evento.fal==null)
                System.out.print("\t-");
            else
                System.out.print("\t" +evento.fal);
            if (evento.nro_orden==null)
                System.out.print("\t-");
            else
                System.out.print("\t" +evento.nro_orden);
            if (evento.nro_ale_tent==null)
                System.out.print("\t-");
            else
                System.out.print("\t" +decimales.format(evento.nro_ale_tent));
            if (evento.tent==null)
                System.out.print("\t-");
            else
                System.out.print("\t" +evento.tent);
            if (evento.nro_ale_tesp==null)
                System.out.print("\t-");
            else
                System.out.print("\t" +decimales.format(evento.nro_ale_tesp));
            if (evento.tesp==null)
                System.out.println("\t-");
            else
                System.out.println("\t" +evento.tesp);
            
        }
    }
    
}
