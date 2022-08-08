package com.virgin.money.data.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RoomTest {

    lateinit var room: Room

    @Before
    fun setUp() {
        room = Room()
    }

    @Test
    fun `When id is not set any value`() {
        Assert.assertEquals("", room.id)
    }

    @Test
    fun `When id is set some value`() {
        room.id = "1"
        Assert.assertEquals("1", room.id)
    }

    @Test
    fun `When createdAt is not set any value`() {
        Assert.assertEquals("", room.createdAt)
    }

    @Test
    fun `When createdAt is set some value`() {
        room.createdAt = "2022-01-24T17:02:23.729Z"
        Assert.assertEquals("2022-01-24T17:02:23.729Z", room.createdAt)
    }

    @Test
    fun `When isOccupied is not set any value`() {
        Assert.assertFalse(room.isOccupied)
    }

    @Test
    fun `When isOccupied is set some value`() {
        room.isOccupied = true
        Assert.assertTrue(room.isOccupied)
    }

    @Test
    fun `When maxOccupancy is not set any value`() {
        Assert.assertEquals(0, room.maxOccupancy)
    }

    @Test
    fun `When maxOccupancy is set some value`() {
        room.maxOccupancy = 10
        Assert.assertEquals(10, room.maxOccupancy)
    }
}