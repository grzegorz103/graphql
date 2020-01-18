package com.system.car.dao;

import com.system.car.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v " +
            "ORDER BY " +
            "CASE WHEN v.brand IS NULL THEN 1 ELSE 0 END," +
            "v.year")
    List<Vehicle> findAllSorted();

}
