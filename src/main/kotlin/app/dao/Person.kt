package app.dao

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity

import javax.persistence.GeneratedValue
import javax.persistence.Id


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Person(
    @Id
    @GeneratedValue
    val id: Int?=null,
    var age: Int?=null,
    var name: String?=null)