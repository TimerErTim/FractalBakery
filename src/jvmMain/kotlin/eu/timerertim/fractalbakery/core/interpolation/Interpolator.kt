package eu.timerertim.fractalbakery.core.interpolation

class Interpolator(val type: Interpolation) {
    var ratio = 0.5

    operator fun <T : Interpolatable<T, I>, I> invoke(first: T, second: I) = interpolate(first, second)

    fun <T : Interpolatable<T, I>, I> interpolate(first: T, second: I): T {
        return first.interpolate(this, second)
    }
}
