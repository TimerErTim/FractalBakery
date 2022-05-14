package eu.timerertim.fractalbakery.model.rendering

@JvmInline
value class Resolution(val values: Pair<Int, Int>) {
    constructor(width: Int, height: Int) : this(width to height)

    val width get() = values.first
    val height get() = values.second
}
