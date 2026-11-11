package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.Contrat;

@Repository
public interface IContratRepository extends JpaRepository<Contrat, Long> {
}