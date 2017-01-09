package pl.maringan.rastrigin.population.domain

class PopulationInitializer(val setRange: SetRange,
                            val dim: Int = 2) {
    fun getPopulation(size: Int): Population {
        return Population(createListIndividuals(size))
    }

    private fun createListIndividuals(size: Int): List<Individual> {
        return (1..size).map {
            crateIndividual()
        }
    }

    private fun crateIndividual(): Individual {
        return Individual(
                (1..dim).map { getRandomArgument() }
        )
    }

    private fun getRandomArgument(): Double {
        return setRange.min + Math.random() * (setRange.max - setRange.min)
    }
}