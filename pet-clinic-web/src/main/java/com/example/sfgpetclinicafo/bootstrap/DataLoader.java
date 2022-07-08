package com.example.sfgpetclinicafo.bootstrap;

import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    private final VisitService visitService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if(count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType petTypeSavedDog = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);


        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);



        PetType cat = new PetType();
        dog.setName("Cat");
        PetType petTypeSavedCat = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("92 rue tommy");
        owner1.setCity("Lyon");
        owner1.setTelephone("073493473866");

        Pet mikesPet = new Pet();
        mikesPet.setOwner(owner1);
        mikesPet.setPetType(petTypeSavedDog);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Dig");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("95 rue Franc");
        owner2.setCity("Lyon");
        owner2.setTelephone("073493473869");

        Pet fionaCat = new Pet();
        fionaCat.setOwner(owner1);
        fionaCat.setPetType(petTypeSavedDog);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("panther");
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Loading owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loading veterinarians.....");

        Set<Owner> owners = ownerService.findAll();
        owners.forEach(owner -> System.out.println("name:" + owner.getFirstName()));
    }
}
