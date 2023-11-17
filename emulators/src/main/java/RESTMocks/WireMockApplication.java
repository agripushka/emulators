package RESTMocks;

import RESTMocks.Helpers.ResponseCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.RequestListener;
import com.github.tomakehurst.wiremock.http.Response;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import com.github.tomakehurst.wiremock.verification.LoggedRequest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class WireMockApplication {

    public static void main(String[] args) throws ClassNotFoundException, JsonProcessingException {
        ResponseCreator responseCreator = new ResponseCreator();
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", 8080);

        ServeEvent serveEvent = wireMockServer.getAllServeEvents().get(0);
        LoggedRequest loggedRequest = serveEvent.getRequest();
        String endpoint = loggedRequest.getUrl();


        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(String.valueOf(WireMock.urlEqualTo(endpoint))))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(responseCreator.transform(loggedRequest))));

        Runtime.getRuntime().addShutdownHook(new Thread(wireMockServer::stop));
    }
}
