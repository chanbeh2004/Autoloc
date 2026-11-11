package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Agence;
import tn.esprit.spring.repository.IAgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    IAgenceRepository agenceRepository;

    @Override
    public Agence creer(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence obtenirParId(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> listerTous() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence mettreAJour(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimer(Long id) {
        agenceRepository.deleteById(id);
    }
}