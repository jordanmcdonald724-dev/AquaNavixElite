package com.aquanavix.vessel.validation
class SensorReliability {
    private var reliability = 1.0
    fun update(faultScore: Double) {
        reliability -= faultScore * 0.2
        if (reliability < 0.0) reliability = 0.0
        reliability += 0.01
        if (reliability > 1.0) reliability = 1.0
    }
    fun current(): Double = reliability
}