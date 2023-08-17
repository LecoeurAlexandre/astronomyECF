package com.example.celestobject.service;

import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.repository.CelestObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelestObjectService {
   @Autowired
   private CelestObjectRepository _celestObjRepo;

   public CelestObject createCelestObj (String name) {
       CelestObject celestObject = CelestObject.builder().name(name).build();
       _celestObjRepo.save(celestObject);
       return celestObject;
   }
   public List<CelestObject> getAllCelestObjects() {
       return (List<CelestObject>) _celestObjRepo.findAll();
   }

    public CelestObject getCelestObjectById(int id) {
        Optional<CelestObject> celestObjectOptional = _celestObjRepo.findById(id);
        if(celestObjectOptional.isPresent()) {
            return celestObjectOptional.get();
        }
        throw new RuntimeException("Not found");
    }
}
