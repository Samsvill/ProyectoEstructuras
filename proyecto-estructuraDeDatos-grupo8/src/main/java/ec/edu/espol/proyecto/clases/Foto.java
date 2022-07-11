/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.clases;
import ec.edu.espol.proyecto.tda.*;
import java.time.LocalDate;

/**
 *
 * @author saman
 */
public class Foto {
    private String filename;
    private String desc;
    private LocalDate date;
    private List<Persona> listaPersonas = new ArrayList();

    public Foto(String filename, String desc, LocalDate date) {
        this.filename = filename;
        this.desc = desc;
        this.date = date;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
