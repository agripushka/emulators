package RESTMocks.Helpers;

import RESTMocks.Helpers.Factories.DTOFactory;
import RESTMocks.Helpers.Factories.POJOFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import com.github.tomakehurst.wiremock.verification.LoggedRequest;


public class ResponseCreator{

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String transform(LoggedRequest request) throws ClassNotFoundException, JsonProcessingException {
        DTOModifier dtoModifier = new DTOModifier();
        LoggedRequest loggedRequest = ServeEvent.of(request).getRequest();

        String endpoint = loggedRequest.getUrl();

        try {
            objectMapper.readValue(loggedRequest.getBodyAsString(), POJOFactory.createPOJO(endpoint));
            dtoModifier.modify(endpoint);
        } catch (JsonProcessingException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        return objectMapper.writeValueAsString(DTOFactory.findDTO(endpoint));
    }
}
