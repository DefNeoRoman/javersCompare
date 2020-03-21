package app.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonRepository : CrudRepository<Person, Int>