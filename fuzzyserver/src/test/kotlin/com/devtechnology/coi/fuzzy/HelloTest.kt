package com.devtechnology.coi.fuzzy

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HelloTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello World", getHelloString())
    }

    @Test fun mongo_return_more_than_one_hello() : Unit {
        assertTrue { getAllHellosFromMongo().isNotEmpty() }
    }
}
