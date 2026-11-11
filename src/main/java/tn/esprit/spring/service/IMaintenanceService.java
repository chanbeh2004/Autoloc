package tn.esprit.spring.service;

import tn.esprit.spring.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance creer(Maintenance maintenance);
    Maintenance obtenirParId(Long id);
    List<Maintenance> listerTous();
    Maintenance mettreAJour(Maintenance maintenance);
    void supprimer(Long id);
    Maintenance affecterVehiculeMaintenace(long idM, long idV);
}