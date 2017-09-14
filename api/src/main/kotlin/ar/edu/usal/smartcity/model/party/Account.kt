package ar.edu.usal.smartcity.model.party

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Digits

@Entity
@Table(name = "account", schema = "party")
class Account (
    @Digits(integer=20, fraction=2)
    var balance: BigDecimal = BigDecimal.ZERO,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    var uuid: UUID = UUID(0L,0L)
)