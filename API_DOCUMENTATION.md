# 🚀 Cortex API Documentation

## Base URL
```
http://localhost:8080
```

## Response Format
All API responses follow standard HTTP status codes:
- `200 OK` - Successful GET/PUT/PATCH
- `201 Created` - Successful POST
- `204 No Content` - Successful DELETE
- `400 Bad Request` - Invalid request data
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server error

---

## 📋 Projects API

### 1. Create Project
**POST** `/api/projects`

Creates a new project.

**Request Body:**
```json
{
  "name": "Project Name",        // Required, not blank
  "description": "Description"   // Optional
}
```

**Response:** `201 Created`
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Project Name",
  "description": "Description", 
  "tasks": [],
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### 2. Get All Projects
**GET** `/api/projects`

Retrieves all projects.

**Response:** `200 OK`
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Project 1",
    "description": "First project",
    "tasks": [...],
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
]
```

### 3. Get Project by ID
**GET** `/api/projects/{id}`

Retrieves a specific project by UUID.

**Path Parameters:**
- `id` (UUID) - Project identifier

**Response:** `200 OK` / `404 Not Found`
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Project Name",
  "description": "Description",
  "tasks": [
    {
      "id": "task-uuid",
      "title": "Task Title",
      "completed": false
    }
  ],
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### 4. Update Project
**PUT** `/api/projects/{id}`

Updates an existing project.

**Path Parameters:**
- `id` (UUID) - Project identifier

**Request Body:**
```json
{
  "name": "Updated Project Name",
  "description": "Updated description"
}
```

**Response:** `200 OK` / `404 Not Found`
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Updated Project Name",
  "description": "Updated description",
  "tasks": [...],
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T11:45:00"
}
```

### 5. Delete Project
**DELETE** `/api/projects/{id}`

Deletes a project and all associated tasks.

**Path Parameters:**
- `id` (UUID) - Project identifier

**Response:** `204 No Content` / `404 Not Found`

---

## ✅ Tasks API

### 1. Create Task
**POST** `/api/tasks`

Creates a new task.

**Request Body:**
```json
{
  "title": "Task Title",           // Required, not blank
  "description": "Task details"    // Optional
}
```

**Response:** `201 Created`
```json
{
  "id": "task-uuid-here",
  "title": "Task Title",
  "description": "Task details",
  "completed": false,
  "tags": [],
  "project": null,
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### 2. Get All Tasks
**GET** `/api/tasks`

Retrieves all tasks.

**Response:** `200 OK`
```json
[
  {
    "id": "task-uuid-1",
    "title": "First Task",
    "description": "Task description",
    "completed": false,
    "tags": ["urgent", "backend"],
    "project": {
      "id": "project-uuid",
      "name": "Project Name"
    },
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
]
```

### 3. Get Task by ID
**GET** `/api/tasks/{id}`

Retrieves a specific task by UUID.

**Path Parameters:**
- `id` (UUID) - Task identifier

**Response:** `200 OK` / `404 Not Found`
```json
{
  "id": "task-uuid-here",
  "title": "Task Title",
  "description": "Detailed task description",
  "completed": true,
  "tags": ["frontend", "urgent"],
  "project": {
    "id": "project-uuid",
    "name": "Associated Project"
  },
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T12:15:00"
}
```

### 4. Update Task
**PUT** `/api/tasks/{id}`

Updates a task's title and description.

**Path Parameters:**
- `id` (UUID) - Task identifier

**Request Body:**
```json
{
  "title": "Updated Task Title",
  "description": "Updated description"
}
```

**Response:** `200 OK` / `404 Not Found`
```json
{
  "id": "task-uuid-here",
  "title": "Updated Task Title",
  "description": "Updated description",
  "completed": false,
  "tags": [...],
  "project": {...},
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T13:20:00"
}
```

### 5. Update Task Completion
**PATCH** `/api/tasks/{id}/completion`

Updates only the completion status of a task.

**Path Parameters:**
- `id` (UUID) - Task identifier

**Request Body:**
```json
{
  "completed": true
}
```

**Response:** `200 OK` / `404 Not Found`
```json
{
  "id": "task-uuid-here",
  "title": "Task Title",
  "description": "Description",
  "completed": true,
  "tags": [...],
  "project": {...},
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T14:00:00"
}
```

### 6. Delete Task
**DELETE** `/api/tasks/{id}`

Deletes a task.

**Path Parameters:**
- `id` (UUID) - Task identifier

**Response:** `204 No Content` / `404 Not Found`

---

## 📊 Data Models

### Project Model
```json
{
  "id": "UUID",                    // Auto-generated
  "name": "string",                // Required
  "description": "string",         // Optional
  "tasks": [TaskModel],            // Array of associated tasks
  "createdAt": "ISO DateTime",     // Auto-generated
  "updatedAt": "ISO DateTime"      // Auto-updated
}
```

### Task Model
```json
{
  "id": "UUID",                    // Auto-generated
  "title": "string",               // Required
  "description": "string",         // Optional
  "completed": boolean,            // Default: false
  "tags": ["string"],              // Array of tags
  "project": ProjectModel,         // Associated project (optional)
  "createdAt": "ISO DateTime",     // Auto-generated
  "updatedAt": "ISO DateTime"      // Auto-updated
}
```

---

## 🔧 Example Usage

### Create a Project and Add Tasks

1. **Create Project:**
```bash
curl -X POST http://localhost:8080/api/projects \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mobile App Development",
    "description": "iOS and Android app project"
  }'
```

2. **Create Task:**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Design login screen",
    "description": "Create wireframes and mockups for user authentication"
  }'
```

3. **Mark Task as Complete:**
```bash
curl -X PATCH http://localhost:8080/api/tasks/{task-id}/completion \
  -H "Content-Type: application/json" \
  -d '{
    "completed": true
  }'
```

---

## ⚠️ Error Responses

### Validation Errors (400 Bad Request)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Title is required",
  "path": "/api/tasks"
}
```

### Not Found (404)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Task not found",
  "path": "/api/tasks/invalid-uuid"
}
```

---

## 🚀 Quick Testing

You can test the API using tools like:
- **Postman**: Import the endpoints above
- **curl**: Use the example commands provided
- **Browser**: GET endpoints can be tested directly in browser

**Base URL for local testing:** `http://localhost:8080`