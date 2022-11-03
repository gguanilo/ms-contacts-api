package com.example.mscontactsapi.repository;

import com.example.mscontactsapi.repository.model.ContactDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactDTO,Integer> {
}
