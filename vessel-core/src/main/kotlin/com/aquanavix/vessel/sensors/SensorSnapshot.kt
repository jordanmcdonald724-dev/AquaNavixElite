package com.aquanavix.vessel.sensors
data class SensorSnapshot(
    val heading: Double?,
    val yawRate: Double?,
    val velocity: Double,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long
)