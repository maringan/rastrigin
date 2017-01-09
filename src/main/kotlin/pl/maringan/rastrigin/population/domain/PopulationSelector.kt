package pl.maringan.rastrigin.population.domain

class PopulationSelector(val max: Int) {
    fun select(population: Population): Population {
        return Population(
                selectIndividuals(population.individuals)
        )
    }

    private fun selectIndividuals(individuals: List<Individual>): List<Individual> {
        val selectedIndividuals = individuals.sortedBy { it.calculateFitnessFunction() }
        return selectedIndividuals.subList(0, max)
    }

}