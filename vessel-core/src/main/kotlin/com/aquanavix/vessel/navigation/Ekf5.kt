package com.aquanavix.vessel.navigation
class Ekf5(initial: EkfState) {
    private var state = initial
    fun predict() {}
    fun updateGpsPosition(x: Double, y: Double) {}
    fun updateHeading(h: Double, reliability: Double) {}
    fun state(): EkfState = state
}