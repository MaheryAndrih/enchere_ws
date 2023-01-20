package enchere_ws.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name="produit")
public class Produit {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
   private int idclient;
   private String nomproduit;
   private int idcategorie;
   private Time dureeenchereminute;
   private LocalDateTime dateenchere;
   private int prixmin;

    public Produit() {
    }

    public Produit(Long id, int idclient, String nomproduit, int idcategorie, Time dureeenchereminute, LocalDateTime dateenchere, int prixmin) {
        this.id = id;
        this.idclient = idclient;
        this.nomproduit = nomproduit;
        this.idcategorie = idcategorie;
        this.dureeenchereminute = dureeenchereminute;
        this.dateenchere = dateenchere;
        this.prixmin = prixmin;
    }

    public Produit(int idclient, String nomproduit, int idcategorie, Time dureeenchereminute, LocalDateTime dateenchere, int prixmin) {
        this.idclient = idclient;
        this.nomproduit = nomproduit;
        this.idcategorie = idcategorie;
        this.dureeenchereminute = dureeenchereminute;
        this.dateenchere = dateenchere;
        this.prixmin = prixmin;
    }

    public Produit(String nomproduit, int idcategorie, LocalDateTime dateenchere, int prixmin) {
        this.nomproduit = nomproduit;
        this.idcategorie = idcategorie;
        this.dateenchere = dateenchere;
        this.prixmin = prixmin;
    }

    public Produit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public Produit(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Produit(LocalDateTime dateenchere) {
        this.dateenchere = dateenchere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int id_client) {
        this.idclient = id_client;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nom_produit) {
        this.nomproduit = nom_produit;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int id_categorie) {
        this.idcategorie = id_categorie;
    }

    public Time getDureeenchereminute() {
        return dureeenchereminute;
    }

    public void setDureeenchereminute(Time duree_enchere_minute) {
        this.dureeenchereminute = duree_enchere_minute;
    }

    public LocalDateTime getDateenchere() {
        return dateenchere;
    }

    public void setDateenchere(LocalDateTime date_enchere) {
        this.dateenchere = date_enchere;
    }

    public int getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(int prix_min) {
        this.prixmin = prix_min;
    }
}
