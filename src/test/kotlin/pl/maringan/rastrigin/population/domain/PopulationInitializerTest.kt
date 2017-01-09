package pl.maringan.rastrigin.population.domain

import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class PopulationInitializerTest {

    companion object {
        const val size = 1000
        const val max = 5.12
        const val min = -5.12
    }

    @Test
    fun shouldGeneratePopulation() {
        // given
        val subject = PopulationInitializer(SetRange(min, max))

        // when
        val result = subject.getPopulation(size)

        // then
        assertEquals(result.individuals.size, size)
        assertTrue(result.individuals.all {
            it.arguments.size == 2
                    && it.arguments.all { x -> x < max && x > min } })
    }
}