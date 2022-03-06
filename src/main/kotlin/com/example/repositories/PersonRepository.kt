package com.example.repositories

import com.example.entities.Person
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
interface PersonRepository : ReactiveCrudRepository<Person, Long> {
    @Query("select id, name, age from person c where c.name = :name")
    fun findByName(name: String): Flux<Person>
}