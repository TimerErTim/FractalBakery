package eu.timerertim.fractalbakery.core.numbers

import eu.timerertim.fractalbakery.core.interpolation.SelfInterpolatableProvider

@JvmInline
value class Rational(val value: Double) : SelfInterpolatableProvider<Rational> {
    constructor(value: Number) : this(value.toDouble())

    override fun interpolateNearest(participation: Double, with: Rational): Rational {
        return Rational(if (participation > 0.5) with.value else this.value)
    }

    override fun interpolateLinear(participation: Double, with: Rational): Rational {
        return Rational((with.value - this.value) * participation + this.value)
    }

    override fun interpolateCubic(participation: Double, with: Rational): Rational {
        val difference = this.value - with.value
        return Rational(
            2 * difference * participation * participation * participation -
                    3 * difference * participation * participation +
                    this.value
        )
    }

    fun toInteger() = Integer(value)
}
