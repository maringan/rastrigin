package pl.maringan.rastrigin.population.domain

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class PopulationSelectorTest {

    @Test
    fun shouldSelectTheBestIndividuals() {
        // given
        val populationSize = 1
        val individual1 = Individual(arrayListOf(5.0, 5.0))
        val individual2 = Individual(arrayListOf(0.0, 0.0))

        val population = Population(arrayListOf(
                individual1,
                individual2
        ))

        val subject = PopulationSelector(populationSize)

        // when
        val result = subject.select(population)

        // then
        assertEquals(result.individuals.size, populationSize)
        assertEquals(result.individuals.first(), individual2)
    }
}