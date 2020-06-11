package systems.abacus.springbootjwtcustom.annotations

import org.springframework.context.annotation.Import
import systems.abacus.springbootjwtcustom.config.JwtTokenAuthorizationConfig

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(JwtTokenAuthorizationConfig::class)
annotation class EnableJwtTokenFiltering