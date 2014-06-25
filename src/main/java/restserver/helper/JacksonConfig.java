package restserver.helper;

import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * Responsável pela  configuração da serialização de objetos em json utilizando jackson
 * <p> configura especialmente o formato da data e pode ser utilizada para mais configurações necessárias</p>
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonConfig() {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        mapper.configure(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY, true);
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }
}
