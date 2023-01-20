package enchere_ws.repository;

import enchere_ws.model.MouvementCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import java.util.List;


import java.util.List;

public interface MouvementCompteRepository extends JpaRepository<MouvementCompte, Long> {
    MouvementCompte findById(int id);
    /*@Transactional
    public List<MouvementCompte> findByIdClient(long id);*/
}
