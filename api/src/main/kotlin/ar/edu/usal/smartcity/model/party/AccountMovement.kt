package ar.edu.usal.smartcity.model.party

import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Digits

@Entity
@Table(name = "account_movement", schema = "party")
class AccountMovement (
        @Digits(integer=10, fraction=2)
        var amount: BigDecimal = BigDecimal.ZERO,

        var conceptType: AccountMovementConcept = AccountMovementConcept.NONE,
        var conceptId: Long = 0,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
)

enum class AccountMovementConcept {
    NONE,
    TRAFFIC_VIOLATION
}
