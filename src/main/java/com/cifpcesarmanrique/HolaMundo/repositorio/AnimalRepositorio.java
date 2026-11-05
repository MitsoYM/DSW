package com.cifpcesarmanrique.HolaMundo.repositorio;

import com.cifpcesarmanrique.HolaMundo.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepositorio extends JpaRepository<Animal, Integer> {
}