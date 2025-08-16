package com.delia.cortex.services;

import com.delia.cortex.dto.CreateProjectRequest;
import com.delia.cortex.models.ProjectModel;
import com.delia.cortex.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    public ProjectModel createProject(CreateProjectRequest request) {
        ProjectModel project = new ProjectModel(request.getName(), request.getDescription());
        return projectRepository.save(project);
    }
    
    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public Optional<ProjectModel> getProjectById(UUID id) {
        return projectRepository.findById(id);
    }
    
    public Optional<ProjectModel> updateProject(UUID id, CreateProjectRequest request) {
        Optional<ProjectModel> existingProject = projectRepository.findById(id);
        
        if (existingProject.isPresent()) {
            ProjectModel project = existingProject.get();
            project.setName(request.getName());
            project.setDescription(request.getDescription());
            return Optional.of(projectRepository.save(project));
        }
        
        return Optional.empty();
    }
    
    public boolean deleteProject(UUID id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
