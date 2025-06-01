package org.example.feedbackfinal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test básico que verifica que el contexto de Spring Boot se carga sin errores.
 * Gracias a la dependencia 'spring-boot-starter-test' en pom.xml, están disponibles:
 *  - org.junit.jupiter.api.Test
 *  - org.springframework.boot.test.context.SpringBootTest
 */
@SpringBootTest
class FeedBackFinalApplicationTests {

    @Test
    void contextLoads() {
        // Si el contexto de Spring Boot no se carga correctamente, este test fallará.
        // No es necesario añadir nada adicional aquí.
    }
}
