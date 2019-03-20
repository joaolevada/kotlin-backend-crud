package br.com.joaolevada.todolist.controller

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

abstract class CustomController {

    fun createURI(id: String): URI {

        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand("id")
                .toUri()

    }
}