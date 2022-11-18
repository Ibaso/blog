package uz.ibaso.blog.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.ibaso.blog.db.dto.ErrorMessageDto;
import uz.ibaso.blog.db.entity.UserEntity;
import uz.ibaso.blog.mappers.AuthMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(2)
public class AuthFilter extends OncePerRequestFilter {
    private Integer UNAUTHORIZED_CODE = 401;
    @Autowired
    AuthMapper mapper;

    @Override

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (request.getRequestURI().endsWith("login")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            errorWriter(response, UNAUTHORIZED_CODE, UNAUTHORIZED_CODE, "Unauthorized" +
                    "");
            return;

        }
        if (authorization.startsWith("Bearer ")){
            String token = authorization.split(" ")[1];
            System.out.println(token);
            UserEntity userEntity = mapper.findUserByToken(token);
            System.out.println(userEntity);
        }


        filterChain.doFilter(request, response);
    }

    public void errorWriter(HttpServletResponse response, Integer httpCode, Integer errorCode, String message) throws IOException {
        response.setStatus(httpCode);
        response.getWriter().write(new ErrorMessageDto(errorCode, message).toJson());
    }
}
