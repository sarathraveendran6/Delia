package com.delia.cortex.repositories;

import com.delia.cortex.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, UUID> {
    // Spring Data JPA automatically implements basic CRUD operations
}
