package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Pet, Long>{

}
