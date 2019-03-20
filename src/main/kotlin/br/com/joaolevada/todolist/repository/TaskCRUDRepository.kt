package br.com.joaolevada.todolist.repository

import br.com.joaolevada.todolist.domain.model.common.Id
import br.com.joaolevada.todolist.domain.model.task.Task
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TaskCRUDRepository : CrudRepository<Task, Id> {

    // override fun findAll(): Iterable<Task>
    override fun findById(id: Id): Optional<Task>
    fun findByDescription(description: String) {}

}