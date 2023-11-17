package RESTMocks.POJORequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VreqRequest {
    private Vreq VREQ;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Vreq {
        public String SYSTEM_ID;
        public String MSG_ID;
        public String CLIENT_EXT_ID;
    }
}
