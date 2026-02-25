package com.aquanavix.vessel
import com.aquanavix.vessel.simulation.MonteCarloRunner
import kotlin.test.Test
import kotlin.test.assertTrue

class MonteCarloValidationTest {
    @Test
    fun monteCarloBatchRemainsStable() {
        val runner = MonteCarloRunner()
        val avgError = runner.runBatch(100)
        assertTrue(avgError < 10.0)
    }
}