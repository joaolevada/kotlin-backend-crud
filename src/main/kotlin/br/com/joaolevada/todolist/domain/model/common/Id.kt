package br.com.joaolevada.todolist.domain.model.common

import javassist.SerialVersionUID
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Id (
        @Column(nullable = false, updatable = false, length = 36)
        val id: String): Serializable {

    val serialVersionUID = 1L

    fun asString(): String {
        return id
    }

}