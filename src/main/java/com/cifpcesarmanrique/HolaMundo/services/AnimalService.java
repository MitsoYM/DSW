package com.cifpcesarmanrique.HolaMundo.services;

import com.cifpcesarmanrique.HolaMundo.models.Animal;
import com.cifpcesarmanrique.HolaMundo.repositorio.AnimalRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private  final AnimalRepositorio repo;

    public AnimalService(AnimalRepositorio repo)
    {
        this.repo = repo;
    }

    public List<Animal> findAll()
    {
        return repo.findAll();
    }

    public Animal findById(Integer id)
    {
        return repo.findById(id).orElse(null);
    }

    public void save(Animal animal)
    {
        repo.save(animal);
    }

    public void delete(Integer id)
    {
        repo.deleteById(id);
    }
}
