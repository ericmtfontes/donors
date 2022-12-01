package com.myapi.myapplication.repositories;

import com.myapi.myapplication.entities.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
}
