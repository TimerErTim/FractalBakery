package eu.timerertim.fractalbakery.core.interpolation

enum class Interpolation {
    NEAREST, LINEAR, CUBIC;

    private val interpolator = Interpolator(this)

    fun <T : Interpolatable<T, I>, I> interpolate(
        first: Pair<Double, T>,
        progress: Double,
        second: Pair<Double, I>
    ): T {
        val (firstPos, firstVal) = first
        val (secondPos, secondVal) = second

        if (secondPos == firstPos) {
            return interpolate(firstVal, 0.5, secondVal)
        }

        val parts = (secondPos - firstPos)
        val ratio = (progress - firstPos) / parts
        return interpolate(firstVal, ratio, secondVal)
    }

    operator fun <T : Interpolatable<T, I>, I> invoke(
        first: Pair<Double, T>,
        progress: Double,
        second: Pair<Double, I>
    ) = interpolate(first, progress, second)

    fun <T : Interpolatable<T, I>, I> interpolate(first: T, ratio: Double, second: I): T {
        interpolator.ratio = ratio
        return interpolator(first, second)
    }

    operator fun <T : Interpolatable<T, I>, I> invoke(first: T, ratio: Double, second: I) =
        interpolate(first, ratio, second)
}
