package com.cifpcesarmanrique.HolaMundo.services;

import com.cifpcesarmanrique.HolaMundo.models.Animal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
@Service
public class AnimalService {
    private  final List<Animal> animals = new ArrayList<>();

    public AnimalService()
    {
        animals.add(new Animal(1, "Dodo",30, true));
        animals.add(new Animal(2, "Tortuga", 100, false));
        animals.add(new Animal(3, "Lince", 15, false));
    }

    public List<Animal> findAll()
    {
        return animals;
    }

    public Animal findById(Integer id)
    {
        return animals.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Animal animal)
    {
        if (animal.getId() == null)
        {
            int nextId = animals.stream()
                    .mapToInt(Animal::getId)
                    .max()
                    .orElse(0) + 1;
            animal.setId(nextId);
            animals.add(animal);
        } else {
            Animal existing = findById(animal.getId());
            if (existing != null)
            {
                existing.setNombre(animal.getNombre());
                existing.setVidaMedia(animal.getVidaMedia());
                existing.setExtinto(animal.isExtinto());
            }
        }
    }

    public void delete(Integer id)
    {
        boolean removeIf = animals.removeIf(a -> a.getId().equals(id));
    }
}
