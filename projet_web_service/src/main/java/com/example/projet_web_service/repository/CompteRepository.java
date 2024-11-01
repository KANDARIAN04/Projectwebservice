package com.example.projet_web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projet_web_service.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
