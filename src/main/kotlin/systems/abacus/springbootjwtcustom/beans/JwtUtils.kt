package systems.abacus.springbootjwtcustom.beans

import io.jsonwebtoken.Claims

interface JwtUtils {
    fun generateToken(id: String, username: String, roles: List<String>, groupIds: List<Long>): String
    fun checkToken(token: String): Boolean
    fun parseToken(token: String): Claims
}