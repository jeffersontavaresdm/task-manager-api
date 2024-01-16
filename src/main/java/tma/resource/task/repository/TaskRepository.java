package tma.resource.task.repository;

import org.springframework.data.repository.CrudRepository;
import tma.resource.task.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> { }