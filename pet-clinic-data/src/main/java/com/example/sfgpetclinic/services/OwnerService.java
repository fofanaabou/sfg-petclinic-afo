package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
