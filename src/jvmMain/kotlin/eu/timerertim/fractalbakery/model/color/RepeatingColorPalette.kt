package eu.timerertim.fractalbakery.model.color

import eu.timerertim.fractalbakery.core.interpolation.Interpolation
import eu.timerertim.fractalbakery.core.numbers.Rational

class RepeatingColorPalette(
    colors: Map<Double, Color>,
    var interpolation: Interpolation = Interpolation.LINEAR
) : ColorPalette {
    val colors = colors.toSortedMap()

    override fun get(position: Rational): Color {
        val nonRepeatedPosition = position.value % colors.maxOf { it.key }
        val (leftColor, rightColor) = colors.surrounding(nonRepeatedPosition)
        return interpolation.interpolate(leftColor, nonRepeatedPosition, rightColor)
    }
}
