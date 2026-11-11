
package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.domain.Maintenance;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.repository.IMaintenanceRepository;
import tn.esprit.spring.repository.IVehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Maintenance creer(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance obtenirParId(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> listerTous() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance mettreAJour(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Maintenance affecterVehiculeMaintenace(long idM, long idV) {

        Maintenance maintenance = maintenanceRepository.findById(idM)
                .orElseThrow(() ->
                        new RuntimeException("Maintenance introuvable : " + idM));

        Vehicule vehicule = vehiculeRepository.findById(idV)
                .orElseThrow(() ->
                        new RuntimeException("Véhicule introuvable : " + idV));

        maintenance.setVehicule(vehicule);

        return maintenanceRepository.save(maintenance);
    }

}
