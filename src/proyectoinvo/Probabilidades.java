/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.io.Serializable;

/**
 *
 * @author Enrique
 */
public class Probabilidades implements Serializable{
    //segun el ejemplo estos son el numero de valores que tiene cada cuadro de prob.
    private int filas = 2;
    private int col_dem = 10;
    private int col_te = 4;
    
    private Double[][] demanda_diaria ;
    private Double[][] tiempo_entrega ;
    private Double[][] tiempo_espera ;
    
    private Double [][] demanda_diaria_acum;
    private Double [][] tiempo_entrega_acum;
    private Double [][] tiempo_espera_acum;

    public Probabilidades() {
        this.demanda_diaria = new Double[filas][col_dem];
        this.tiempo_entrega = new Double[filas][col_te];
        this.tiempo_espera = new Double[filas][col_te+1];
        
        this.demanda_diaria_acum = new Double[filas][col_dem];
        this.tiempo_entrega_acum = new Double[filas][col_te];
        this.tiempo_espera_acum = new Double[filas][col_te+1];
    }
    
    public void setDemanda(Double dem[][]){
        this.demanda_diaria =dem;
        acumularProbabilidad(dem,"demanda_diaria");
    }
    
    public void setTiempoEntrega(Double te[][]){
        this.tiempo_entrega = te;
        acumularProbabilidad(te,"tiempo_entrega");
    }
    public void setTiempoEspera(Double te[][]){
        this.tiempo_espera = te;
        acumularProbabilidad(te,"tiempo_espera");
    }
    
    private void acumularProbabilidad(Double prob[][],String tipo){
        int i,j;
        if (tipo == "demanda_diaria"){
            for (i=0 ; i < prob.length ; i++ ){
                for (j=0 ; j < prob[i].length ; j++){
                    if ( i==0 || (i!=0 && j==0)){
                        demanda_diaria_acum[i][j] =Math.rint( prob[i][j]*100)/100;
                    }
                    else if (i!=0 && j!=0){
                        demanda_diaria_acum[i][j] = Math.rint((prob[i][j] + demanda_diaria_acum[i][j-1])*100)/100;
                    }
                }
            }
        }
        else if(tipo == "tiempo_entrega"){
            for (i=0 ; i < prob.length ; i++ ){
                for (j=0 ; j < prob[i].length ; j++){
                    if ( i==0 || (i!=0 && j==0)){
                        tiempo_entrega_acum[i][j] = Math.rint( prob[i][j]*100)/100;
                    }
                    else if (i!=0 && j!=0){
                        tiempo_entrega_acum[i][j] = Math.rint((prob[i][j] + tiempo_entrega_acum[i][j-1])*100)/100;
                    }
                }
            }
        }
        else if(tipo == "tiempo_espera"){
            for (i=0 ; i < prob.length ; i++ ){
                for (j=0 ; j < prob[i].length ; j++){
                    if ( i==0 || (i!=0 && j==0)){
                        tiempo_espera_acum[i][j] = Math.rint( prob[i][j]*100)/100;
                    }
                    else if (i!=0 && j!=0){
                        tiempo_espera_acum[i][j] = Math.rint((prob[i][j] + tiempo_espera_acum[i][j-1])*100)/100;
                    }
                }
            }
        }
    }
    
    
    public Double obtenerNumeroDemanda(Double nroAletorio){
        if (nroAletorio > 1.0)
            return null;
        for (int i = 0 ; i < demanda_diaria_acum[1].length ; i++){
            if (nroAletorio <= demanda_diaria_acum[1][i] ){
                return demanda_diaria_acum[0][i];
            }
        }
        return null;
    }
    
    public Double obtenerNumeroTEspera(Double nroAletorio){
        if (nroAletorio > 1.0)
            return null;
        for (int i = 0 ; i < tiempo_espera_acum[1].length ; i++){
            if (nroAletorio <= tiempo_espera_acum[1][i] ){
                return tiempo_espera_acum[0][i];
            }
        }
        return null;
    }
    public Double obtenerNumeroTEntrega(Double nroAletorio){
        if (nroAletorio > 1.0)
            return null;
        for (int i = 0 ; i < tiempo_entrega_acum[1].length ; i++){
            if (nroAletorio <= tiempo_entrega_acum[1][i] ){
                return tiempo_entrega_acum[0][i];
            }
        }
        return null;
    }
    public void imprimir(){
        int i ,j;
        System.out.println("DEMANDA DIARIA\n");
        for (i=0; i <demanda_diaria[0].length; i++ ){
           System.out.print(demanda_diaria[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <demanda_diaria[1].length; i++ ){
           System.out.print(demanda_diaria[1][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <demanda_diaria_acum[1].length; i++ ){
           System.out.print(demanda_diaria_acum[1][i]+"\t");
        }
        System.out.println("\n\n");
        
        System.out.println("TIEMPO ENTREGA\n");
        for (i=0; i <tiempo_entrega[0].length; i++ ){
           System.out.print(tiempo_entrega[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <tiempo_entrega[1].length; i++ ){
           System.out.print(tiempo_entrega[1][i]+"\t");
        }
         System.out.println("\n");
        for (i=0; i <tiempo_entrega_acum[1].length; i++ ){
           System.out.print(tiempo_entrega_acum[1][i]+"\t");
        }
        System.out.println("\n\n");
        
        
        System.out.println("TIEMPO ESPERA\n");
        for (i=0; i <tiempo_espera[0].length; i++ ){
           System.out.print(tiempo_espera[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <tiempo_espera[1].length; i++ ){
           System.out.print(tiempo_espera[1][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <tiempo_espera_acum[1].length; i++ ){
           System.out.print(tiempo_espera_acum[1][i]+"\t");
        }
        System.out.println("\n\n");
    }
    
}
