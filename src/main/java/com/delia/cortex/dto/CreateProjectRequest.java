package com.delia.cortex.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateProjectRequest {
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
