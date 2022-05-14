package eu.timerertim.fractalbakery.core.interpolation

typealias SelfInterpolatable<T> = Interpolatable<T, T>

interface Interpolatable<T : Interpolatable<T, I>, I> {
    fun interpolate(interpolator: Interpolator, other: I): T
}
