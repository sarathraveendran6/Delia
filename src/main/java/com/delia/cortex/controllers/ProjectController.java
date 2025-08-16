package com.delia.cortex.controllers;

import com.delia.cortex.dto.CreateProjectRequest;
import com.delia.cortex.models.ProjectModel;
import com.delia.cortex.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;
    
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    @PostMapping
    public ResponseEntity<ProjectModel> createProject(@Valid @RequestBody CreateProjectRequest request) {
        ProjectModel createdProject = projectService.createProject(request);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ProjectModel>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getProjectById(@PathVariable UUID id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProjectModel> updateProject(@PathVariable UUID id, @Valid @RequestBody CreateProjectRequest request) {
        return projectService.updateProject(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        if (projectService.deleteProject(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
