# 📝 Todo API Documentation

This API manages a multi-user, hierarchical Todo list with subtask support. All endpoints are protected and require **Basic Authentication**.

## Base URL
`http://localhost:8080/todos`

---

## Endpoints Summary

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/todos` | List all todos belonging to the authenticated user. |
| **GET** | `/todos/{todoid}` | Fetch a specific todo or subtask by its UUID. |
| **POST** | `/todos` | Create a new root-level Todo. |
| **POST** | `/todos/{todoid}/subtasks` | Add a subtask to an existing Todo. |
| **PUT** | `/todos` | Update an existing Todo or Subtask details. |
| **DELETE** | `/todos/{todoid}` | Delete a Todo (and all its nested subtasks). |

---

## Detailed Usage

### 1. List User Todos
Fetches the task tree for the currently logged-in user.
* **Method:** `GET`
* **URL:** `/todos`
* **Auth:** Required

### 2. Get Specific Todo
Retrieve details for a single task.
* **Method:** `GET`
* **URL:** `/todos/{todoid}`
* **Path Variable:** `todoid` (UUID)

### 3. Create Root Todo
Creates a task at the top level. The system automatically assigns the authenticated user as the owner.
* **Method:** `POST`
* **URL:** `/todos`
* **Body (JSON):**
    ```json
    {
      "title": "Master Spring Boot",
      "description": "Complete the backend architecture"
    }
    ```

### 4. Create Subtask
Links a new task to a specific parent.
* **Method:** `POST`
* **URL:** `/todos/{todoid}/subtasks`
* **Path Variable:** `todoid` (The UUID of the parent task)
* **Body (JSON):**
    ```json
    {
      "title": "Learn JPA Mapping",
      "description": "Understand @ManyToOne relationships"
    }
    ```

### 5. Update Todo
Updates an existing task. Ensure the `id` is provided in the body.
* **Method:** `PUT`
* **URL:** `/todos`
* **Body (JSON):**
    ```json
    {
      "id": "550e8400-e29b-41d4-a716-446655440000",
      "title": "Updated Title",
      "isCompleted": true
    }
    ```

### 6. Delete Todo
Removes the specified task and all nested subtasks.
* **Method:** `DELETE`
* **URL:** `/todos/{todoid}`
* **Response:** Returns a success message string.

---

## Security & Ownership
* **Authentication:** All requests must include a `Basic Auth` header.
* **Data Privacy:** Users can only access, update, or delete tasks that they own.
* **Cascading:** Deleting a parent task automatically removes all child subtasks from the database.