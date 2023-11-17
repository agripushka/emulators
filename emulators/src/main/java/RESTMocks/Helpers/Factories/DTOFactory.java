package RESTMocks.Helpers.Factories;

import RESTMocks.DTOResponses.CheckStopListResponseDTO;

public class DTOFactory {

    public static Class<?> findDTO(String endpoint) throws ClassNotFoundException {
        switch (endpoint) {
            case "/check_stoplist":
                return CheckStopListResponseDTO.class;
            default:
                throw new ClassNotFoundException("Unknown endpoint: " + endpoint);
        }
    }
}
