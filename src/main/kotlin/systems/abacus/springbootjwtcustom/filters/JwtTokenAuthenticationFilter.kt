package systems.abacus.springbootjwtcustom.filters

import io.jsonwebtoken.Claims
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import systems.abacus.springbootjwtcustom.config.JwtConfig
import systems.abacus.springbootjwtcustom.beans.JwtUtils
import systems.abacus.springbootjwtcustom.security.LocalPrincipal
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenAuthenticationFilter @Autowired constructor(private val config: JwtConfig, private val utils: JwtUtils) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val header = request.getHeader(config.header)

        if (header == null || !header.startsWith(config.prefix!!)) {
            filterChain.doFilter(request, response)
            return
        }

        val token = header.replace(config.prefix, "").trim()

        try {
            val claims: Claims = utils.parseToken(token)

            val username = claims.subject

            if (username != null) {

                val userId = claims.id.toLong()

                val authorities: List<GrantedAuthority>

                val authoritiesClaim = claims["authorities"] as String

                authorities = authoritiesClaim.split(',')
                        .map { a -> SimpleGrantedAuthority("ROLE_" + a.toUpperCase()) }
                        .toList()

                val rawGroupIds = claims["groupIds"] as String

                val groupIds: List<Long>

                groupIds = rawGroupIds.trim()
                        .split(',')
                        .filter { !it.isBlank() }
                        .map { it.toLong() }
                        .toList()

                val principal = LocalPrincipal(userId, username, groupIds)

                val auth = UsernamePasswordAuthenticationToken(principal, null, authorities)

                SecurityContextHolder.getContext().authentication = auth
            }
        } catch (e: Exception) {
            SecurityContextHolder.clearContext()
        }

        filterChain.doFilter(request, response)
    }
}