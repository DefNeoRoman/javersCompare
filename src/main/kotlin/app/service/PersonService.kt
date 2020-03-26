package app.service

import app.dao.Person
import app.dao.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    @PostConstruct
    fun init(){
    }

    fun findAll(): Any? {
        return repository.findAll();
    }

    fun save(person: Person) {
        repository.save(person)
    }

    fun update(person: Person){
        val personById = repository.findById(person.id).get()
        personById.name = person.name
        personById.age = person.age
        repository.save(personById)
    }
}