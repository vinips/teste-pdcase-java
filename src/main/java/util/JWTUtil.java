package util;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	public static final String TOKEN_HEADER = "Authorization";

	public static String create(String subject) throws Exception {
		try {
			return Jwts.builder().setIssuer("BDGIA_APP_2018").setIssuedAt(getDate())
					.setSubject(subject).signWith(SignatureAlgorithm.HS256, Base64.decodeBase64("BDGIA_@50uH&"))
					.compact();
		} catch (Exception e) {
			throw new Exception("Error creating access Token!", e);
		}
	}

	public static Jws<Claims> decode(String token) throws Exception {
		try {
			return Jwts.parser().setSigningKey(Base64.decodeBase64("BDGIA_@50uH&")).parseClaimsJws(token);
		} catch (ExpiredJwtException e) {
			throw new Exception("Expired Token!", e);
		} catch (Exception e) {
			throw new Exception("Error decoding access Token!", e);
		}
	}

	private static Date getDate() {
		return new Date();
	}

}