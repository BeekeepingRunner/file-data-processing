package com.example.filedataprocessing.db.repositories;

import com.example.filedataprocessing.db.repositories.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
