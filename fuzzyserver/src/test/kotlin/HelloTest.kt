package test

import com.devtechnology.coi.fuzzy.getHelloString
import kotlin.test.assertEquals
import org.junit.Test

class HelloTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello World", getHelloString())
    }
}
