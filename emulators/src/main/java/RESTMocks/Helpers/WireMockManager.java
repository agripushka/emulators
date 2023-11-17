package RESTMocks.Helpers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockManager {
    private WireMockServer wireMockServer;

    public void StartServer(int port) {
        WireMockConfiguration wireMockConfiguration = WireMockConfiguration.options().port(port);
        wireMockServer = new WireMockServer(wireMockConfiguration);
        wireMockServer.start();
    }

    public void stopServer() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            this.wireMockServer.stop();
        }
    }
}
