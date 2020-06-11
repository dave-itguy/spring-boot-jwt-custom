package systems.abacus.springbootjwtcustom

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import systems.abacus.springbootjwtcustom.annotations.EnableJwtTokenFiltering

@SpringBootTest
@EnableJwtTokenFiltering
class SpringBootJwtCustomApplicationTests {

    @Test
    fun contextLoads() {
    }

}
