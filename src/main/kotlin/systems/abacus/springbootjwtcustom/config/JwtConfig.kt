package systems.abacus.springbootjwtcustom.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
class JwtConfig {
    val audience: String? = null
    val secret: String? = null
    val expiration: Long = 0L
    val issuer: String? = null
    val prefix: String? = null
    val header: String? = null
}