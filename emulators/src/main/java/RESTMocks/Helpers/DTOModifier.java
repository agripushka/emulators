package RESTMocks.Helpers;

import RESTMocks.DTOResponses.CheckStopListResponseDTO;
import RESTMocks.POJORequests.VreqRequest;

public class DTOModifier {
    public void modify(String endpoint) {
        switch (endpoint) {
            case "/check_stoplist":
                CheckStopListResponseDTO.CheckStopList dto = new CheckStopListResponseDTO().getCHECK_STOP_LIST();
                VreqRequest.Vreq pojo = new VreqRequest().getVREQ();

                dto.setMSG_ID(pojo.getMSG_ID());
                dto.setSYSTEM_ID(pojo.getSYSTEM_ID());
        }
    }
}
