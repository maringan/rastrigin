package pl.maringan.rastrigin.population.domain

import java.util.*


class PopulationMutator(val setRange: SetRange,
                        val mutationRation: Double = 0.5,
                        val mutationPercentage: Double = 0.1) {
    companion object {
        val GENERATOR = Random()
    }

    fun mutate(population: Population): Population {
        return Population(population.individuals.map {
            if (shouldMutate()) {
                Individual(it.arguments.map {
                    mutateTrait(it)
                })
            } else {
                it
            }
        })
    }

    private fun shouldMutate(): Boolean {
        return GENERATOR.nextDouble() < mutationRation
    }

    private fun mutateTrait(x: Double): Double {
        val mutationSign = if(GENERATOR.nextBoolean()) 1 else -1
        val newX = x + mutationSign * calculateMutationRatio(x)
        return checkBorders(newX)
    }

    private fun checkBorders(newX: Double): Double {
        return if (newX > setRange.max) {
            setRange.max
        } else {
            if (newX < setRange.min) {
                setRange.min
            } else {
                newX
            }
        }
    }

    private fun calculateMutationRatio(x: Double) = mutationPercentage * GENERATOR.nextDouble() * x
}
