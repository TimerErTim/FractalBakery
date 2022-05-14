package eu.timerertim.fractalbakery.model

import eu.timerertim.fractalbakery.core.numbers.Rational
import eu.timerertim.fractalbakery.model.rendering.MultiSampling
import eu.timerertim.fractalbakery.model.rendering.MultiSampling.NONE
import eu.timerertim.fractalbakery.model.rendering.Resolution

class FractalRepresentation(val resolution: Resolution, val multiSampling: MultiSampling = NONE) {
    val data = Array(resolution.width) {
        Array(resolution.height) {
            Rational(-1.0)
        }
    }

    fun colorize() {

    }
}
