package br.com.joaolevada.todolist.domain.model.common

import java.util.*

fun proximoId(): Id {

    val uniqueId = UUID.randomUUID().toString()
    return Id(uniqueId)

}