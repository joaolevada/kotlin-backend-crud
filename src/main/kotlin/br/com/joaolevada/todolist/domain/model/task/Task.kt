package br.com.joaolevada.todolist.domain.model.task

import br.com.joaolevada.todolist.domain.model.common.Id
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class Task {

    @EmbeddedId
    var id: Id

    @Column(nullable = false, length = 255)
    @NotNull
    @NotEmpty
    var description: String

    @Column(nullable = false)
    @NotNull
    var creationDate: LocalDateTime

    @Column
    var expireDate: LocalDateTime? = null

    @Column
    var dueDate: LocalDateTime? = null

    constructor(id: Id, description: String) {
        this.id = id
        this.description = description
        creationDate = LocalDateTime.now()
    }

    constructor(id: Id, description: String, expireDate: LocalDateTime) {
        this.id = id
        this.description = description
        creationDate = LocalDateTime.now()
        this.expireDate = expireDate
    }

}