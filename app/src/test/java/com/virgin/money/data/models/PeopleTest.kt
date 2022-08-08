package com.virgin.money.data.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PeopleTest {

    lateinit var people: People

    @Before
    fun setUp() {
        people = People()
    }

    @Test
    fun `When id is not set any value`() {
        Assert.assertEquals("", people.id)
    }

    @Test
    fun `When id is set some value`() {
        people.id = "1"
        Assert.assertEquals("1", people.id)
    }

    @Test
    fun `When firstName is not set any value`() {
        Assert.assertEquals("", people.firstName)
    }

    @Test
    fun `When firstName is set some value`() {
        people.firstName = "Maggie"
        Assert.assertEquals("Maggie", people.firstName)
    }

    @Test
    fun `When lastName is not set any value`() {
        Assert.assertEquals("", people.lastName)
    }

    @Test
    fun `When lastName is set some value`() {
        people.lastName = "Brekke"
        Assert.assertEquals("Brekke", people.lastName)
    }

    @Test
    fun `When avatar is not set any value`() {
        Assert.assertEquals("", people.avatar)
    }

    @Test
    fun `When avatar is set some value`() {
        people.avatar = "https://randomuser.me/api/portraits/women/21.jpg"
        Assert.assertEquals("https://randomuser.me/api/portraits/women/21.jpg", people.avatar)
    }

    @Test
    fun `When email is not set any value`() {
        Assert.assertEquals("", people.email)
    }

    @Test
    fun `When email is set some value`() {
        people.email = "Crystel.Nicolas61@hotmail.com"
        Assert.assertEquals("Crystel.Nicolas61@hotmail.com", people.email)
    }

    @Test
    fun `When jobTitle is not set any value`() {
        Assert.assertEquals("", people.jobTitle)
    }

    @Test
    fun `When jobTitle is set some value`() {
        people.jobTitle = "Future Functionality Strategist"
        Assert.assertEquals("Future Functionality Strategist", people.jobTitle)
    }

    @Test
    fun `When favouriteColor is not set any value`() {
        Assert.assertEquals("", people.favouriteColor)
    }

    @Test
    fun `When favouriteColor is set some value`() {
        people.favouriteColor = "pink"
        Assert.assertEquals("pink", people.favouriteColor)
    }

    @Test
    fun `When createdAt is not set any value`() {
        Assert.assertEquals("", people.createdAt)
    }

    @Test
    fun `When createdAt is set some value`() {
        people.createdAt = "2022-01-24T17:02:23.729Z"
        Assert.assertEquals("2022-01-24T17:02:23.729Z", people.createdAt)
    }
}