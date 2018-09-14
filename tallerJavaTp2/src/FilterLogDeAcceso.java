import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "FilterLogDeAcceso",
        urlPatterns = {"/*"},
        initParams = @WebInitParam(name = "archivoLog", value = "logs.txt")
)
public class FilterLogDeAcceso implements Filter {
    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        config.getServletContext().log("hola esto es un log");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
