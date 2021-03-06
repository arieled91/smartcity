package ar.edu.usal.smartcity

import org.h2.server.web.WebServlet
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableScheduling
class Application : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Bean
    fun h2servletRegistration(): ServletRegistrationBean {
        val registration = ServletRegistrationBean(WebServlet())
        registration.addUrlMappings("/console/*")
        return registration
    }

}