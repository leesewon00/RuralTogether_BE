package landvibe.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import landvibe.test.controller.BoardController;
import landvibe.test.exception.RuralException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import static landvibe.test.exception.ErrorCode.*;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws RuralException {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object controller = handlerMethod.getBean();

        if (!(controller instanceof BoardController))
            return true;

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            throw new RuralException(SESSION_EXPIRATION_STATUS);
        }
        return true;
    }

}
