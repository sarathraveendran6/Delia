package com.delia.cortex.repositories;

import com.delia.cortex.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
    // Spring Data JPA automatically implements basic CRUD operations
    // You can add custom query methods if needed
}