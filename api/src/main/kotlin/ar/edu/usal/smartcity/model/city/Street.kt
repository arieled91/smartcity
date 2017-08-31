package ar.edu.usal.smartcity.model.city

import javax.persistence.*

@Entity
@Table(name = "street", schema = "city")
class Street (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)

enum class C