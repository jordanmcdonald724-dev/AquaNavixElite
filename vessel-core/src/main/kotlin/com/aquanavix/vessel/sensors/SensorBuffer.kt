package com.aquanavix.vessel.sensors
class SensorBuffer(private val capacity: Int) {
    private val buffer = arrayOfNulls<SensorSnapshot>(capacity)
    private var head = 0
    private var size = 0
    fun add(snapshot: SensorSnapshot) {
        buffer[head] = snapshot
        head = (head + 1) % capacity
        if (size < capacity) size++
    }
    fun latest(): SensorSnapshot? =
        if (size == 0) null else buffer[(head - 1 + capacity) % capacity]
    fun currentSize(): Int = size
    fun capacity(): Int = capacity
}