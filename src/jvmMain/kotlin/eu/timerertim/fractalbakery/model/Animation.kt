package eu.timerertim.fractalbakery.model

class Animation<out F : Fractal<C>, out C : Configuration> private constructor(
    frames: MutableList<Configuration>
) : List<Configuration> by frames {
    constructor(keyframes: Map<Int, Configuration>, interpolation: Inter) : this()
}
