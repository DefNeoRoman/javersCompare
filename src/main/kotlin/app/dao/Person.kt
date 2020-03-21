package app.dao

import com.fasterxml.jackson.annotation.JsonIgnoreProperties



@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Person(
    @Id
    @GeneratedValue
    val id: Int?=null,
    var age: Int?=null,
    var name: String?=null)