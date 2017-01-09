package pl.maringan.rastrigin.population

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.maringan.rastrigin.population.domain.*


@Configuration
open class PopulationConfiguration {
    companion object {
        val setRange: SetRange = SetRange(-5.12, 5.12)
        val max: Int = 10000
    }

    @Bean
    fun PopulationFacade(): PopulationFacade {
        val populationInitializer = PopulationInitializer(setRange)
        val populationSelector = PopulationSelector(max)
        val populationMutator = PopulationMutator(setRange)
        val populationCross = PopulationCross()

        return PopulationFacade(populationInitializer,
                populationSelector,
                populationMutator,
                populationCross)
    }
}