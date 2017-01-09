package pl.maringan.rastrigin.population.domain

class PopulationCross {
    fun crossPopulation(population: Population): Population {
        val children: MutableList<Individual> = mutableListOf()

        var x = population.individuals
        while (x.isNotEmpty()) {
            try {
                val parent = x.take(2)
                if (x.size == 2) {
                    children.addAll(parent[0].cross(parent[1]))
                } else {
                    break
                }

                x = x.drop(2)
            } catch (e: IllegalArgumentException) {
                break
            }
        }

        return Population(children + population.individuals)
    }
}