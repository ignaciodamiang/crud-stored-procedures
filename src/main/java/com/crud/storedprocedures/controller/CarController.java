package com.crud.storedprocedures.controller;

import com.crud.storedprocedures.entity.Car;
import com.crud.storedprocedures.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/list")
    public ResponseEntity<List<Car>> listProcedure() {
        List<Car> list = carService.listProcedure();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Car> idProcedure(@PathVariable("id") int id) {
        Optional<Car> car = carService.idProcedure(id);
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> brandProcedure(@PathVariable("brand") String brand){
    List<Car> cars = carService.brandProcedure(brand);
    return new ResponseEntity(cars, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveProcedure(@RequestBody Car car) {
        carService.saveProcedure(car);
        return new ResponseEntity("Car saved", HttpStatus.CREATED);
    }

    @GetMapping("/average-km")
    public ResponseEntity<Float> averageKmProcedure() {
        float average = carService.averageKmProcedure();
        return new ResponseEntity(average, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProcedure(@PathVariable("id") int id) {
        carService.deleteProcedure(id);
        return new ResponseEntity("Car deleted", HttpStatus.OK);
    }
}