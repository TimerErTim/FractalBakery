package eu.timerertim.fractalbakery.core.interpolation

import eu.timerertim.fractalbakery.core.interpolation.Interpolation.CUBIC
import eu.timerertim.fractalbakery.core.interpolation.Interpolation.LINEAR
import eu.timerertim.fractalbakery.core.interpolation.Interpolation.NEAREST

typealias SelfInterpolatableProvider<T> = InterpolatableProvider<T, T>

interface InterpolatableProvider<T : Interpolatable<T, I>, I> : Interpolatable<T, I> {
    override fun interpolate(interpolator: Interpolator, other: I): T {
        return when (interpolator.type) {
            NEAREST -> interpolateNearest(interpolator.ratio, other)
            LINEAR -> interpolateLinear(interpolator.ratio, other)
            CUBIC -> interpolateCubic(interpolator.ratio, other)
        }
    }

    fun interpolateNearest(participation: Double, with: I): T
    fun interpolateLinear(participation: Double, with: I): T
    fun interpolateCubic(participation: Double, with: I): T
}
