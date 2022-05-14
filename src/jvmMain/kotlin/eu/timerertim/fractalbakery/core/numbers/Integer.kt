package eu.timerertim.fractalbakery.core.numbers

import eu.timerertim.fractalbakery.core.interpolation.SelfInterpolatableProvider

@JvmInline
value class Integer(val value: Long) : SelfInterpolatableProvider<Integer> {
    constructor(value: Number) : this(value.toLong())

    override fun interpolateNearest(participation: Double, with: Integer): Integer {
        return Integer(if (participation > 0.5) with.value else this.value)
    }

    override fun interpolateLinear(participation: Double, with: Integer): Integer {
        return Integer((with.value - this.value) * participation + this.value)
    }

    override fun interpolateCubic(participation: Double, with: Integer): Integer {
        val difference = this.value - with.value
        return Integer(
            2 * difference * participation * participation * participation -
                    3 * difference * participation * participation +
                    this.value
        )
    }

    fun toRational() = Rational(value)
}
