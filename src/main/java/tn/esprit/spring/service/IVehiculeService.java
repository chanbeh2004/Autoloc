package tn.esprit.spring.service;

import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {

    Vehicule creer(Vehicule vehicule);
    Vehicule obtenirParId(Long id);
    List<Vehicule> listerTous();
    Vehicule mettreAJour(Vehicule vehicule);
    void supprimer(Long id);
    Vehicule affecterVehiculeEquipement(Long idVehicule, Long idEquipement);

    List<Vehicule> rechercherParMarque(String marque);
    List<Vehicule> rechercherMarqueContient(String mot);
    List<Vehicule> rechercherMarqueCommencePar(String debut);
    List<Vehicule> rechercherMarqueTerminePar(String fin);
    List<Vehicule> rechercherParMarqueIgnoreCase(String marque);
    List<Vehicule> rechercherParModele(String modele);
    boolean existeParImmatriculation(String immatriculation);
    long compterParMarque(String marque);

    List<Vehicule> tarifSuperieurA(BigDecimal tarif);
    List<Vehicule> tarifInferieurA(BigDecimal tarif);
    List<Vehicule> tarifSuperieurOuEgalA(BigDecimal tarif);
    List<Vehicule> tarifEntre(BigDecimal min, BigDecimal max);
    List<Vehicule> trierParTarifCroissant();
    List<Vehicule> trierParTarifDecroissant();
    List<Vehicule> marqueTriesParTarifCroissant(String marque);
    List<Vehicule> marqueTarifSuperieurA(String marque, BigDecimal tarif);
    List<Vehicule> marqueOuModele(String marque, String modele);
    List<Vehicule> marqueDansListe(List<String> marques);
    List<Vehicule> marqueHorsListe(List<String> marques);

    List<Vehicule> parStatut(StatutVehicule statut);
    List<Vehicule> disponiblesTriesParTarif();

    List<Vehicule> parAgence(Long idAgence);
    List<Vehicule> parVilleAgence(String ville);
    List<Vehicule> parNomAgenceContient(String mot);
    List<Vehicule> parAgenceEtMarque(Long idAgence, String marque);
    List<Vehicule> sansAgence();
    List<Vehicule> avecAgence();
    long compterParAgence(Long idAgence);
    boolean agenceADesVehicules(Long idAgence);
}