package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    List<Client> findDistinctByNomAndPrenomAndReservations_Vehicule_Categorie(
            String nom, String prenom, CategorieVehicule categorie);
}