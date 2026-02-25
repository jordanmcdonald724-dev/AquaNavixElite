package com.aquanavix.vessel.simulation
import com.aquanavix.vessel.*
import com.aquanavix.vessel.sensors.*
import kotlin.random.Random

class MonteCarloRunner {
    fun runBatch(seeds: Int = 50): Double {
        var totalError = 0.0
        repeat(seeds) { seed ->
            val random = Random(seed)
            val buffer = SensorBuffer(128)
            val core = VesselCore(buffer)
            repeat(1000) {
                buffer.add(
                    SensorSnapshot(
                        heading = 90.0 + random.nextDouble(-5.0,5.0),
                        yawRate = 0.0,
                        velocity = 3.0,
                        latitude = 0.0,
                        longitude = 0.0,
                        timestamp = it.toLong()
                    )
                )
                core.tick()
            }
            totalError += kotlin.math.abs(core.getState().headingDeg - 90.0)
        }
        return totalError / seeds
    }
}