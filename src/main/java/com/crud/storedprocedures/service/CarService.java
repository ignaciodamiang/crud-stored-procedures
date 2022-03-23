package com.crud.storedprocedures.service;

import com.crud.storedprocedures.entity.Car;
import com.crud.storedprocedures.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> listProcedure(){
        return carRepository.listProcedure();
    }

    public Optional<Car> idProcedure(int id){
        return carRepository.idProcedure(id);
    }

    public List<Car> brandProcedure(String brand){
        return carRepository.brandProcedure(brand);
    }

    public void saveProcedure(Car car){
        carRepository.saveProcedure(car.getBrand(), car.getModel(), car.getYear(), car.getKm());
    }

    public float averageKmProcedure(){
        return carRepository.averageKmProcedure();
    }

    public void deleteProcedure(int id){
        carRepository.deleteProcedure(id);
    }
}
