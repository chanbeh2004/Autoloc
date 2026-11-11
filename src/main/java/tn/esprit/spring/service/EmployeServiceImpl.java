package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Employe;
import tn.esprit.spring.domain.Agence;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.repository.IAgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;

    @Override
    public Employe creer(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe obtenirParId(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> listerTous() {
        return employeRepository.findAll();
    }

    @Override
    public Employe mettreAJour(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void supprimer(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe affecterEmployeAgent(Long idE, Long idA) {

        Employe employe = employeRepository.findById(idE)
                .orElseThrow(() -> new RuntimeException("Employe introuvable"));

        Agence agence = agenceRepository.findById(idA)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        employe.setAgence(agence);

        return employeRepository.save(employe);
    }
}