package pl.maringan.rastrigin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import pl.maringan.rastrigin.population.PopulationFacade

@SpringBootApplication
class RastringinApplication
@Autowired
constructor(val populationFacade: PopulationFacade) : CommandLineRunner {
    override fun run(vararg args: String?) {
        populationFacade.doIt()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(RastringinApplication::class.java, *args)
}
