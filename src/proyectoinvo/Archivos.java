/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Enrique
 */
public class Archivos {
    private String archivoProb = "probabilidades.obj";
    private String archivoPoli = "politicas.obj";
    
    
    public Archivos(){
        
    }
    
    public void escribirProbabilidades(Probabilidades p) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoProb,false));
        oos.writeObject(p);
        oos.close();  // Se cierra al terminar
    }
    
    public Probabilidades leerProbabilidades() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoProb));
        Object p = ois.readObject();
        ois.close();
        
        return (Probabilidades) p;
    }
    
     public void escribirPolitica(PoliticaInventario p) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoPoli,false));
        oos.writeObject(p);
        oos.close();  // Se cierra al terminar
    }
    
    public PoliticaInventario leerPolitica() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoPoli));
        Object p = ois.readObject();
        ois.close();
        
        return (PoliticaInventario) p;
    }

}
