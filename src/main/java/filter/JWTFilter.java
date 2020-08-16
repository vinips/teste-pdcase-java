package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import util.JWTUtil;

@WebFilter("/rest/*")
public class JWTFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse res = (HttpServletResponse) servletResponse;
		res.setHeader("server-header", "WildFly/19");
		res.setHeader("x-powered-by-header", "Undertow/1");
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT");
		res.setHeader("Access-Control-Allow-Headers", "accept, authorization, content-type, x-requested-with");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Max-Age", "1");

		try {
			String token = req.getHeader(JWTUtil.TOKEN_HEADER);
			if (token == null || token.trim().isEmpty()) {
				res.setStatus(401);
				return;
			}

			Jws<Claims> parser = JWTUtil.decode(token);
			if (parser != null)
				filterChain.doFilter(servletRequest, servletResponse);
			else
				res.setStatus(401);

		} catch (Exception e) {
			res.setStatus(401);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
