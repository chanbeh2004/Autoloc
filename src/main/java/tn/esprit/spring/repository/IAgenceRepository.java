package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.Agence;

@Repository
public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}