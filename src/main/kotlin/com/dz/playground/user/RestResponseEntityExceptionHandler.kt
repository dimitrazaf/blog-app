package com.dz.playground.user

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [RuntimeException::class])
    fun handleExceptionInternal(ex: Exception, request: WebRequest): ResponseEntity<Any> {

        return when (ex.cause) {
            is IllegalArgumentException -> handleExceptionInternal(ex, "All fields are required",
                    HttpHeaders(), HttpStatus.BAD_REQUEST, request)
            else -> handleExceptionInternal(ex, "",
                    HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request)
        }
    }
}
