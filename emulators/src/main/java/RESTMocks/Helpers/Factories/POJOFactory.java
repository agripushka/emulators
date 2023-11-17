package RESTMocks.Helpers.Factories;

import RESTMocks.POJORequests.VreqRequest;

public class POJOFactory {
    public static Class<?> createPOJO(String endpoint) throws ClassNotFoundException {
        switch (endpoint) {
            case "/check_stoplist":
                return VreqRequest.class;
            default:
                throw new ClassNotFoundException("Unknown endpoint: " + endpoint);
        }
    }
}
