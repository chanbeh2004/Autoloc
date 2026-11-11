package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.domain.Equipement;
import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.repository.IEquipementRepository;
import tn.esprit.spring.repository.IVehiculeRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IEquipementRepository equipementRepository;

    @Override
    public Vehicule creer(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule obtenirParId(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> listerTous() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule mettreAJour(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Vehicule affecterVehiculeEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable : " + idVehicule));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable : " + idEquipement));

        if (vehicule.getEquipements() == null) {
            throw new RuntimeException("La liste des équipements du véhicule est null");
        }

        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    // ===== Recherches =====

    @Override
    public List<Vehicule> rechercherParMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    @Override
    public List<Vehicule> rechercherMarqueContient(String mot) {
        return vehiculeRepository.findByMarqueContaining(mot);
    }

    @Override
    public List<Vehicule> rechercherMarqueCommencePar(String debut) {
        return vehiculeRepository.findByMarqueStartingWith(debut);
    }

    @Override
    public List<Vehicule> rechercherMarqueTerminePar(String fin) {
        return vehiculeRepository.findByMarqueEndingWith(fin);
    }

    @Override
    public List<Vehicule> rechercherParMarqueIgnoreCase(String marque) {
        return vehiculeRepository.findByMarqueIgnoreCase(marque);
    }

    @Override
    public List<Vehicule> rechercherParModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    @Override
    public boolean existeParImmatriculation(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }

    @Override
    public long compterParMarque(String marque) {
        return vehiculeRepository.countByMarque(marque);
    }

    @Override
    public List<Vehicule> tarifSuperieurA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> tarifInferieurA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarif);
    }

    @Override
    public List<Vehicule> tarifSuperieurOuEgalA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarif);
    }

    @Override
    public List<Vehicule> tarifEntre(BigDecimal min, BigDecimal max) {
        return vehiculeRepository.findByTarifJournalierBetween(min, max);
    }

    @Override
    public List<Vehicule> trierParTarifCroissant() {
        return vehiculeRepository.findAllByOrderByTarifJournalierAsc();
    }

    @Override
    public List<Vehicule> trierParTarifDecroissant() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }

    @Override
    public List<Vehicule> marqueTriesParTarifCroissant(String marque) {
        return vehiculeRepository.findByMarqueOrderByTarifJournalierAsc(marque);
    }

    @Override
    public List<Vehicule> marqueTarifSuperieurA(String marque, BigDecimal tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierGreaterThan(marque, tarif);
    }

    @Override
    public List<Vehicule> marqueOuModele(String marque, String modele) {
        return vehiculeRepository.findByMarqueOrModele(marque, modele);
    }

    @Override
    public List<Vehicule> marqueDansListe(List<String> marques) {
        return vehiculeRepository.findByMarqueIn(marques);
    }

    @Override
    public List<Vehicule> marqueHorsListe(List<String> marques) {
        return vehiculeRepository.findByMarqueNotIn(marques);
    }

    @Override
    public List<Vehicule> parStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> disponiblesTriesParTarif() {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> parAgence(Long idAgence) {
        return vehiculeRepository.findByAgence_IdAgence(idAgence);
    }

    @Override
    public List<Vehicule> parVilleAgence(String ville) {
        return vehiculeRepository.findByAgence_Ville(ville);
    }

    @Override
    public List<Vehicule> parNomAgenceContient(String mot) {
        return vehiculeRepository.findByAgence_NomContaining(mot);
    }

    @Override
    public List<Vehicule> parAgenceEtMarque(Long idAgence, String marque) {
        return vehiculeRepository.findByAgence_IdAgenceAndMarque(idAgence, marque);
    }

    @Override
    public List<Vehicule> sansAgence() {
        return vehiculeRepository.findByAgenceIsNull();
    }

    @Override
    public List<Vehicule> avecAgence() {
        return vehiculeRepository.findByAgenceIsNotNull();
    }

    @Override
    public long compterParAgence(Long idAgence) {
        return vehiculeRepository.countByAgence_IdAgence(idAgence);
    }

    @Override
    public boolean agenceADesVehicules(Long idAgence) {
        return vehiculeRepository.existsByAgence_IdAgence(idAgence);
    }
}