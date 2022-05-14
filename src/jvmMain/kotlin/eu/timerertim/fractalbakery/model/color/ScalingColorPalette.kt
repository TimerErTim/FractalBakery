package eu.timerertim.fractalbakery.model.color

import eu.timerertim.fractalbakery.core.interpolation.Interpolation
import eu.timerertim.fractalbakery.core.numbers.Rational

class ScalingColorPalette(
    colors: Map<Double, Color>,
    var interpolation: Interpolation = Interpolation.LINEAR
) : ColorPalette {
    override fun get(position: Rational): Color {
        TODO("Not yet implemented")
    }
}
