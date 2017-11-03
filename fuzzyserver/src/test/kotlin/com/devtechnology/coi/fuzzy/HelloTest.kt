package com.devtechnology.coi.fuzzy

import getHelloString
import kotlin.test.assertEquals
import org.junit.Test

class HelloTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello World", getHelloString())
    }
}
