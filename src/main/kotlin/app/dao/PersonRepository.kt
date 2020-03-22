package app.dao

import org.javers.spring.annotation.JaversSpringDataAuditable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
@JaversSpringDataAuditable
interface PersonRepository : CrudRepository<Person, Int>