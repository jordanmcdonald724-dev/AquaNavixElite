package com.aquanavix.vessel
import com.aquanavix.vessel.sensors.*
import com.aquanavix.vessel.navigation.*
import com.aquanavix.vessel.validation.*
import com.aquanavix.vessel.state.*

class VesselCore(private val buffer: SensorBuffer) {
    private val ekf = Ekf5(EkfState(0.0,0.0,0.0,0.0,0.0))
    private val reliability = SensorReliability()

    fun tick() {
        val latest = buffer.latest() ?: return
        ekf.predict()
        if (latest.heading != null) {
            ekf.updateHeading(latest.heading, reliability.current())
        }
    }

    fun getState(): NavigationState {
        val s = ekf.state()
        return NavigationState(
            s.px, s.py, s.v, s.headingDeg, s.yawBiasDegPerSec,
            reliability.current(),
            System.currentTimeMillis()
        )
    }
}