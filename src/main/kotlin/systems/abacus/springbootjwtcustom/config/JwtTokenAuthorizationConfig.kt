package systems.abacus.springbootjwtcustom.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import systems.abacus.springbootjwtcustom.beans.JwtUtils
import systems.abacus.springbootjwtcustom.beans.implementations.JwtUtilsImpl

@Configuration
@EnableConfigurationProperties(JwtConfig::class)
class JwtTokenAuthorizationConfig {
    @Bean
    fun jwtUtils(config: JwtConfig): JwtUtils {
        return JwtUtilsImpl(config)
    }
}