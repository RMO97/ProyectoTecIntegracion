package com.adopcion.FormularioAdopcion;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reportes {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idReporte;
    private String reporte;
    private int idDueño;
    private int idPerrito;
    private int nReporte;


    
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public int getIdPerrito() {
        return idPerrito;
    }

    public void setIdPerrito(int idPerrito) {
        this.idPerrito = idPerrito;
    }
    
    public int getnReporte() {
        return nReporte;
    }

    public void setnReporte(int nReporte) {
        this.nReporte = nReporte;
    }

    public static void add(Reportes reporte2) {
    }


}
