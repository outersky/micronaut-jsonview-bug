package myview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.http.server.netty.jackson.JsonViewMediaTypeCodecFactory;
import io.micronaut.http.server.netty.jackson.JsonViewServerFilter;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StartupListener {


    @Inject
    private ObjectMapper mapper;

    @Inject
    private ApplicationContext context;

    @EventListener
    public void onStartupEvent(StartupEvent event) {
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        try {
            Role r = Role.create();
            String result = mapper
                    .writerWithView(View.Public.class)
                    .writeValueAsString(r);
            System.out.println("Only id property is expected!");
            System.out.println("Actual @JsonView: " + result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}

