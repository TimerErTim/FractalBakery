package eu.timerertim.fractalbakery.model.rendering

enum class MultiSampling(
    val modifyResolution: (Resolution) -> Resolution = { it },
    val getNextPoint: (() -> Unit)? = null
) {
    NONE,
    X2({
        Resolution(it.width, it.height * 2)
    }),
    X4
}
