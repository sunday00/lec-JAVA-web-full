package resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

public class HandlerMapArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == MapArgumentResolver.class;
    }

    @Override
    public MapArgumentResolver resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MapArgumentResolver argumentResolver = new MapArgumentResolver();

        Iterator<String> headerNames = webRequest.getHeaderNames();
        while ( headerNames.hasNext() ) {
            String headerName = headerNames.next();
            String headerValue = webRequest.getHeader(headerName);
            argumentResolver.setMap(headerName, headerValue);
        }

        return argumentResolver;
    }
}
