package com.aquanavix.vessel.state
data class NavigationState(
    val posEastMeters: Double,
    val posNorthMeters: Double,
    val velocityMps: Double,
    val headingDeg: Double,
    val yawBiasDegPerSec: Double,
    val confidence: Double,
    val timestamp: Long
)