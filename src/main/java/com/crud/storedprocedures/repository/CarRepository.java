package com.crud.storedprocedures.repository;

import com.crud.storedprocedures.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "{call list_procedure()}", nativeQuery = true)
    List<Car> listProcedure();

    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Optional<Car> idProcedure(@Param("idIn") int idIn);

    @Query(value = "{call brand_procedure(:brandIn)}", nativeQuery = true)
    List<Car> brandProcedure(@Param("brandIn") String brandIn);

    @Query(value = "{call save_procedure(:brandIn, :modelIn, :yearIn, :kmIn)}", nativeQuery = true)
    void saveProcedure(
        @Param("brandIn") String brandIn,
        @Param("modelIn") String modelIn,
        @Param("yearIn") int yearIn,
        @Param("kmIn") int kmIn
    );

    @Query(value = "{call average_km_procedure()}", nativeQuery = true)
    float averageKmProcedure();

    @Query(value = "{call delete_procedure(:idIn)}", nativeQuery = true)
    void deleteProcedure(@Param("idIn") int idIn);
}
