package com.boltChallenge.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Invalid char")
class InvalidItemException: RuntimeException() {}