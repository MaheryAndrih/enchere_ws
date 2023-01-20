package enchere_ws.controller;

import enchere_ws.model.*;
import enchere_ws.repository.DemandeRepository;
import enchere_ws.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin("*")
@RestController
public class ProduitController {
    private final ProduitRepository repository;

    //public ProduitController(ProduitRepository repository){this.repository=repository;}
    public ProduitController(ProduitRepository repository){
        this.repository=repository;
    }
    @GetMapping("/produit/recherche")
    Object all(){
        try{
            JsonDataSuccess<Produit> data = new JsonDataSuccess();
            //Date da = new Date(123,00,20);
            /*System.out.println("categorie="+categorie);
            System.out.println("date="+date);
            System.out.println("prixMin="+prixMin);*/
            data.setData(repository.recherche(1,1000));


            return data;
        }
        catch(Exception ex){
            JsonError err = new JsonError();
            Erreur e = new Erreur();
            e.setCode(404);
            e.setMessage("Error found");
            err.setError(e);
            return err;
        }
    }
}
