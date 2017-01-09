package pl.maringan.rastrigin.population.domain

import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class IndividualTest {

    @Test
    fun shouldCalculatedFitnessFunction() {
        // given
        val subject = Individual(arrayListOf(0.0, 0.0))

        // when
        val result = subject.calculateFitnessFunction()

        // then
        assertEquals(0.0, result)
    }
    
    @Test
    fun shouldCanProduceNewIndividuals() {
        // given
        val individual1 = Individual(arrayListOf(0.0, 0.0))
        val individual2 = Individual(arrayListOf(5.0, 5.0))

        // when
        val result = individual1.cross(individual2)

        // then
        assertTrue(result.size <= 5)
        assertTrue(result.all { arrayListOf(0.0, 5.0).containsAll(it.arguments) })
    }
}