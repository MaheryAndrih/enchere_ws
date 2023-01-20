package enchere_ws.controller;

import enchere_ws.DAOpostgres.Generique;
import enchere_ws.model.*;
import enchere_ws.repository.CategorieRepository;
import enchere_ws.repository.EnchereRepository;
import enchere_ws.repository.MouvementCompteRepository;
import enchere_ws.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EnchereController {
    private final EnchereRepository repository;


    public EnchereController(EnchereRepository repository){this.repository=repository;}

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private MouvementCompteRepository moveproduitRepository;

    @GetMapping("/Enchere")
    Object all(){
        try{
            JsonDataSuccess<Enchere> data = new JsonDataSuccess();
            data.setData(repository.findAll());
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
   /* @PostMapping("/Categorie/save")
    Enchere newEnchere(@RequestBody Enchere newEnchere) {

        return repository.save(newEnchere);
    }*/
   /* @PostMapping
    public void save(@RequestBody Enchere newEnchere) throws Exception {
        Enchere enchere = new Enchere();
        enchere.setIdclient(newEnchere.getIdclient());
        enchere.setIdproduit(newEnchere.getIdproduit());

        List<Enchere> encheres = repository.findByIdProduit(newEnchere.getId());

        if (encheres.isEmpty()) {
            Produit prod = produitRepository.findById(newEnchere.getIdproduit());
            if (newEnchere.getMontantenchere()<= prod.getPrixmin()) {
                throw new Exception("Montant insuffisant");
            } else {
                enchere.setMontantenchere(newEnchere.getMontantenchere());
            }
        } else {

            // Partie qui prend le montant le plus elevé de la table enchere
            double montant_plus_eleve = encheres.get(0).getMontantenchere();
            for (int i = 1; i < encheres.size(); i++) {
                if (montant_plus_eleve < encheres.get(i).getMontantenchere()) {
                    montant_plus_eleve = encheres.get(i).getMontantenchere();
                }
            }
            //////

            // Partie qui calcule le montant actuel du client
            List<MouvementCompte> mouvement_comptes = moveproduitRepository.findByIdClient(newEnchere.getIdclient());

            double montant_actuel = 0;
            for (int i = 0; i < mouvement_comptes.size(); i++) {
                if (mouvement_comptes.get(i).getTypemouvement()== 1) {
                    montant_actuel = montant_actuel + mouvement_comptes.get(i).getMontant();
                } else {
                    montant_actuel = montant_actuel - mouvement_comptes.get(i).getMontant();
                }
            }
            //////

            if (montant_plus_eleve > newEnchere.getMontantenchere()) {
                throw new Exception("Montant insuffisant");
            } else if (montant_actuel < newEnchere.getMontantenchere()) {
                throw new Exception("Montant trop eleve");
            } else {
                enchere.setMontantenchere(newEnchere.getMontantenchere());
            }
        }

        repository.save(enchere);
    }*/


}
