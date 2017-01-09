package pl.maringan.rastrigin.population

import pl.maringan.rastrigin.population.domain.*

class PopulationFacade(val populationInitializer: PopulationInitializer,
                       val populationSelector: PopulationSelector,
                       val populationMutator: PopulationMutator,
                       val populationCross: PopulationCross,
                       val populationSize: Int = 10000,
                       val maxEpoch: Int = 100000) {


    fun doIt() {
        var population: Population = populationInitializer.getPopulation(populationSize)
        var i: Int = 0
        while (i++ < maxEpoch) {
            population = populationSelector.select(population)
            val theBestOne = population.individuals.first()

            println("${theBestOne.arguments}: ${theBestOne.calculateFitnessFunction()} - epoka: $i")

            population = populationCross.crossPopulation(population)
            population = populationMutator.mutate(population)
        }
    }
}