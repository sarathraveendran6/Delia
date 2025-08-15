package com.delia.cortex.dto;

public class UpdateTaskCompletionRequest {
    private boolean completed;
    
    // Default constructor
    public UpdateTaskCompletionRequest() {}
    
    // Constructor
    public UpdateTaskCompletionRequest(boolean completed) {
        this.completed = completed;
    }
    
    // Getter and Setter
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
