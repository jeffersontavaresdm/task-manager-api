package tma.resource.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.resource.response.APIResponse;
import tma.resource.task.dto.TaskDTO;
import tma.resource.task.service.TaskService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

    private final TaskService taskService;

    public TaskManagerController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<Object>> list() {
        return APIResponse.response(
            HttpStatus.OK,
            "List of task",
            Collections.emptyList()
        );
    }
}