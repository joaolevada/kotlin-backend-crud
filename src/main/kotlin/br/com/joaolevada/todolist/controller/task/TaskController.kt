package br.com.joaolevada.todolist.controller.task

import br.com.joaolevada.todolist.application.task.TaskAppService
import br.com.joaolevada.todolist.controller.CustomController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.Objects.isNull

@RestController
@RequestMapping("openapi/task")
class TaskController (val taskAppService: TaskAppService): CustomController() {

    data class TaskToListDto(val id: String, val description: String, val creationDate: LocalDateTime, val expireDate: LocalDateTime?, val dueDate: LocalDateTime?)

    data class FullTaskDto(val id: String, val description: String, val creationDate: LocalDateTime, val expireDate: LocalDateTime?, val dueDate: LocalDateTime?)

    @GetMapping("{id}")
    fun findById(@PathVariable id: String): ResponseEntity<FullTaskDto> {
        val task = taskAppService.findById(id).orElse(null)

        if (isNull(task)) {
            return ResponseEntity.notFound().build()
        }

        val respDto = FullTaskDto(task.id.asString(), task.description, task.creationDate, task.expireDate, task.dueDate)
        return ResponseEntity.ok(respDto)
    }

    data class NewTaskDto(val description: String)

    @PostMapping
    fun createTask(@RequestBody newTaskDTO: NewTaskDto): ResponseEntity<String> {

        val newTask = taskAppService.createTask(newTaskDTO.description)
        val newTaskURI = super.createURI(newTask.id.asString())
        return ResponseEntity.created(newTaskURI).build()

    }

    data class NewTaskExpiresDto(val description: String, val expireDate: LocalDateTime)

    @PostMapping("expires")
    fun createTaskExpires(@RequestBody newTaskExpiresDTO: NewTaskExpiresDto): ResponseEntity<String> {

        val newTask = taskAppService.createTaskExpires(newTaskExpiresDTO.description, newTaskExpiresDTO.expireDate)
        val newTaskURI = super.createURI(newTask.id.asString())
        return ResponseEntity.created(newTaskURI).build()

    }

}