package br.com.joaolevada.todolist.application.task

import br.com.joaolevada.todolist.application.CustomAppService
import br.com.joaolevada.todolist.domain.model.common.Id
import br.com.joaolevada.todolist.domain.model.common.proximoId
import br.com.joaolevada.todolist.domain.model.task.Task
import br.com.joaolevada.todolist.repository.TaskCRUDRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*


@Service
class TaskAppService(private val taskRepo: TaskCRUDRepository): CustomAppService() {

    fun createTask(desc: String): Task {
        val id = proximoId()
        val task = Task(id, desc)
        taskRepo.save(task)
        return task
    }

    fun createTaskExpires(desc: String, expireDate: LocalDateTime): Task {
        val id = proximoId()
        val task = Task(id, desc, expireDate)
        taskRepo.save(task)
        return task
    }

    fun findById(id: String): Optional<Task> {
        val procurarPor = Id(id)
        return taskRepo.findById(procurarPor)
    }
}