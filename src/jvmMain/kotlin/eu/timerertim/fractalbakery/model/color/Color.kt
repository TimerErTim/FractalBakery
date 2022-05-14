package eu.timerertim.fractalbakery.model.color

import eu.timerertim.fractalbakery.core.interpolation.Interpolator
import eu.timerertim.fractalbakery.core.interpolation.SelfInterpolatable
import eu.timerertim.fractalbakery.core.numbers.Integer

data class Color(val alpha: Integer, val red: Integer, val green: Integer, val blue: Integer) :
    SelfInterpolatable<Color> {
    fun to32BitInt() = blue.value shl 0 and green.value shl 8 and red.value shl 16 and alpha.value shl 24

    override fun interpolate(interpolator: Interpolator, other: Color): Color {
        val interpolatedAlpha = interpolator.interpolate(this.alpha, other.alpha)
        val interpolatedRed = interpolator.interpolate(this.red, other.red)
        val interpolatedGreen = interpolator.interpolate(this.green, other.green)
        val interpolatedBlue = interpolator.interpolate(this.blue, other.blue)

        return Color(interpolatedAlpha, interpolatedRed, interpolatedGreen, interpolatedBlue)
    }
}
