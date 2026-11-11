package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {

    // 1-5(marque)
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByMarqueContaining(String mot);
    List<Vehicule> findByMarqueStartingWith(String debut);
    List<Vehicule> findByMarqueEndingWith(String fin);
    List<Vehicule> findByMarqueIgnoreCase(String marque);

    // 6(modele)
    List<Vehicule> findByModele(String modele);

    // 7(immatriculation)
    boolean existsByImmatriculation(String immatriculation);

    // 8(compte par marque)
    long countByMarque(String marque);

    // 9-12(tarif)
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierBetween(BigDecimal min, BigDecimal max);

    // 13-15(tri)
    List<Vehicule> findAllByOrderByTarifJournalierAsc();
    List<Vehicule> findAllByOrderByTarifJournalierDesc();
    List<Vehicule> findByMarqueOrderByTarifJournalierAsc(String marque);

    // 16-17(combinaison)
    List<Vehicule> findByMarqueAndTarifJournalierGreaterThan(String marque, BigDecimal tarif);
    List<Vehicule> findByMarqueOrModele(String marque, String modele);

    // 18-19(in-not in)
    List<Vehicule> findByMarqueIn(List<String> marques);
    List<Vehicule> findByMarqueNotIn(List<String> marques);

    // 20-21(statut)
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);

    // 22-25(agence)
    List<Vehicule> findByAgence_IdAgence(Long idAgence);
    List<Vehicule> findByAgence_Ville(String ville);
    List<Vehicule> findByAgence_NomContaining(String mot);
    List<Vehicule> findByAgence_IdAgenceAndMarque(Long idAgence, String marque);

    // 26-27(null-not null)
    List<Vehicule> findByAgenceIsNull();
    List<Vehicule> findByAgenceIsNotNull();

    // 28-29compte-l exist d agence)
    long countByAgence_IdAgence(Long idAgence);
    boolean existsByAgence_IdAgence(Long idAgence);
}
//Mohamed Chanbeh 4CCE3 vehicule repository