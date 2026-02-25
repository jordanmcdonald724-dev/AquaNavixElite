package com.aquanavix.vessel.navigation
data class EkfState(
    val px: Double,
    val py: Double,
    val v: Double,
    val headingDeg: Double,
    val yawBiasDegPerSec: Double
)