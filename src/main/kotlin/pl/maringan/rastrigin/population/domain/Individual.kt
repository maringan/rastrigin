package pl.maringan.rastrigin.population.domain

import java.util.*

data class Individual(val arguments: List<Double>, val A: Int = 10) {
    private var dim: Int
    private val generator: Random = Random()
    private val maxChildren: Int = 5

    init {
        dim = arguments.size
    }

    fun calculateFitnessFunction(): Double {
        val const: Int = A * dim

        return const + E(dim)
    }

    fun cross(individual: Individual): List<Individual> {
        return (0..(generator.nextInt(maxChildren))).map { crossTwoIndividuals(individual) }
    }

    private fun crossTwoIndividuals(individual: Individual): Individual {
        val args: List<Double> = (individual.arguments + arguments).sortedBy { Math.random() }
        val selectedTraits = args.subList(0, args.size / 2)

        if (selectedTraits.size != dim) {
            throw IllegalArgumentException()
        }

        return Individual(selectedTraits)
    }

    private fun E(n: Int): Double {
        return times(n).sumByDouble {
            val x: Double = arguments[it]
            partFunction(x)
        }
    }

    private fun times(n: Int) = (0..(n - 1))

    private fun partFunction(x: Double): Double {
        return (x * x) - (A * Math.cos(2 * Math.PI * x))
    }
}