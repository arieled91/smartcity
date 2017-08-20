package ar.edu.usal.smartcity.model.common

import javax.persistence.*

@Entity
@Table(name = "resource", schema = "common")
class Resource(
    @Lob
    var content: ByteArray = byteArrayOf(),

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)