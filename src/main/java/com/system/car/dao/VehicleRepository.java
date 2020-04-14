package com.system.car.dao;

import com.system.car.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT v FROM Vehicle v " +
            "WHERE v.brand.id = :brandId "+
            "ORDER BY "+
    "CASE WHEN v.brand IS NULL THEN 1 ELSE 0 END," +
            "v.year")
    Page<Vehicle> findAllByBrandId(Long brandId, Pageable pageable);
}
