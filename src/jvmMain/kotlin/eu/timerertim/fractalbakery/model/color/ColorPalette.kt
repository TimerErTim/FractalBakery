package eu.timerertim.fractalbakery.model.color

import eu.timerertim.fractalbakery.core.numbers.Rational
import java.util.*

sealed interface ColorPalette {
    operator fun get(position: Rational): Color


    fun <T, O> SortedMap<T, O>.surrounding(key: T): Pair<Pair<T, O>, Pair<T, O>> {
        val first = this.headMap(key).entries.last().toPair()
        val second = this.tailMap(key).entries.first().toPair()

        return Pair(first, second)
    }
}
