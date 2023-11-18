package com.example.filedataprocessingserver.db.repositories;

import com.example.filedataprocessingserver.db.repositories.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    List<Laptop> getAllByManufacturer(String manufacturer);
}
