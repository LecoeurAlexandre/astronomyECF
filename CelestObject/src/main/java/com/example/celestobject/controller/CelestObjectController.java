package com.example.celestobject.controller;

import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.service.CelestObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/co")
public class CelestObjectController {
    @Autowired
    private CelestObjectService _celestObjectService;
    @PostMapping("")
    public ResponseEntity<CelestObject> post(@RequestParam String name) {
        CelestObject celestObject = _celestObjectService.createCelestObj(name);
        return ResponseEntity.ok(celestObject);
    }
    @GetMapping("")
    public ResponseEntity<List<CelestObject>> getAllCelestObjects() {
        List<CelestObject> celestObjects = _celestObjectService.getAllCelestObjects();
        return ResponseEntity.ok(celestObjects);
    }
    @GetMapping("{id}")
    public ResponseEntity<CelestObject> get(@PathVariable int id) {
        CelestObject celestObject = _celestObjectService.getCelestObjectById(id);
        return ResponseEntity.ok(celestObject);
    }
}
