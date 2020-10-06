package com.example.kalamba.repository;

import com.example.kalamba.model.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends JpaRepository<ActionEntity, Integer> {
}
