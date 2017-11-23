/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Transient;


/**
 *
 * @author Nermin
 */

public class Ugovor implements Serializable {
    
    
    
    private final IntegerProperty idUgovora=new SimpleIntegerProperty(this, "idUgovora", 0);
   
    private final StringProperty ime=new SimpleStringProperty(this, "ime", "");
 
    private final StringProperty prezime=new SimpleStringProperty(this, "prezime", "");
    
    private final StringProperty adresa=new SimpleStringProperty(this, "adresa", "");
  
    private final StringProperty brzina=new SimpleStringProperty(this, "brzina", "");
   
    private final StringProperty protok=new SimpleStringProperty(this, "protok", "");

    private final StringProperty trajanjeUgovora=new SimpleStringProperty(this, "trajanjeUgovora", "");
    


    public Ugovor(){
        
    }
    
    public Ugovor(String ime, String prezime, String adresa, String brzina, String protok, String trajanjeUgovora){
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.adresa.set(adresa);
        this.brzina.set(brzina);
        this.protok.set(protok);
        this.trajanjeUgovora.set(trajanjeUgovora);
        
    }
    
    public Ugovor(String ime){
        this.ime.set(ime);
    }
    
    public Ugovor(String ime, String prezime,String adresa){
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.adresa.set(adresa);
        
    }

    public Integer getIdUgovora(){
        return idUgovora.get();
    }
    
    public void setidUgovora(Integer idUgovora){
        this.idUgovora.set(idUgovora);
    }
    
    public IntegerProperty idUgovoraProperty(){
        return idUgovora;
    }

    public String getIme(){
        return ime.get();
    }
    
    public void setIme(String ime){
        this.ime.set(ime);
    }
    
    public StringProperty imeProperty(){
        return ime;
    }

    public String getPrezime(){
        return prezime.get();
    }
    
    
    public void setPrezime(String prezime){
        this.prezime.set(prezime);   
    }
    
    public StringProperty prezimeProperty(){
        return prezime;
    } 
    

    public String getAdresa(){
        return adresa.get();
    }
    
    
    public void setAdresa(String adresa){
        this.adresa.set(adresa);   
    }
    
    public StringProperty adresaProperty(){
        return adresa;
    } 
    

    public String getBrzina(){
        return brzina.get();
    }
    
    
    
    public  void setBrzina(String brzina){
        this.brzina.set(brzina);
    }
   
    public StringProperty brzinaProperty(){
        return brzina;
    } 
    

    public String getProtok(){
        return protok.get();
    }
    
    
    public void setProtok(String protok){
        this.protok.set(protok);   
    }
    
    public StringProperty protokProperty(){
        return protok;
    } 

    public String getTrajanjeUgovora(){
        return trajanjeUgovora.get();
    }
    
    
    public void setTrajanjeUgovora(String trajanjeUgovora){
        this.trajanjeUgovora.set(trajanjeUgovora);   
    }
    
    public StringProperty trajanjeUgovoraProperty(){
        return trajanjeUgovora;
    } 

    @Transient
    private final ObjectProperty<ArrayList<String>> errroList=new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());
    
    public ObjectProperty<ArrayList<String>> errorProperty(){
        return errroList;
    }
    
    public boolean isValid(){
        boolean isValid=true;
        if(ime.get() != null &&ime.get().equals("")){
        errroList.getValue().add("Polje za ime ne može biti prazno!!!");
        isValid=false;
    }
        if(prezime.get() != null &&prezime.get().equals("")){
        errroList.getValue().add("Polje za prezime ne može biti prazno!!!");
        isValid=false;
    }
        if(adresa.get() != null &&adresa.get().equals("")){
        errroList.getValue().add("Polje za adresu ne može biti prazno!!!");
        isValid=false;
        }
        return isValid;
    }


}

    


  
    
     

