package RESTMocks.DTOResponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckStopListResponseDTO {
    private CheckStopList CHECK_STOP_LIST;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CheckStopList {
        private String SYSTEM_ID;
        private String MSG_ID;
        private List<CheckInfo> CHECK_INFO;
        private int CHECKS_COUNT;
        private boolean CHECKS_RESULT;
        private int RESULT_CODE;
        private String RESULT;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class CheckInfo {
        private String  CHECK_NAME;
        private String CHECK_RESULT;
        private boolean CHECK_OK;
    }

    public void fillInfo() {
        CHECK_STOP_LIST = new CheckStopList();
        CHECK_STOP_LIST.setCHECK_INFO(new ArrayList<>());

        CheckInfo checkInfo1 = new CheckInfo();
        checkInfo1.setCHECK_NAME("Проверка по списку недействительных удостоверений");
        checkInfo1.setCHECK_RESULT("Не выявлено совпадений со списком недействительных удостоверений");
        checkInfo1.setCHECK_OK(true);
        CHECK_STOP_LIST.getCHECK_INFO().add(checkInfo1);

        CheckInfo checkInfo2 = new CheckInfo();
        checkInfo1.setCHECK_NAME("Проверка по списку террористов/экстремистов РФ от 06.09.2023");
        checkInfo1.setCHECK_RESULT("Не выявлено совпадений со справочником террористов РФ");
        checkInfo1.setCHECK_OK(true);
        CHECK_STOP_LIST.getCHECK_INFO().add(checkInfo2);

        CheckInfo checkInfo3 = new CheckInfo();
        checkInfo1.setCHECK_NAME("Проверка по списку сомнительных статусов клиентов");
        checkInfo1.setCHECK_RESULT("нет совпадений");
        checkInfo1.setCHECK_OK(true);
        CHECK_STOP_LIST.getCHECK_INFO().add(checkInfo3);

        CheckInfo checkInfo4 = new CheckInfo();
        checkInfo1.setCHECK_NAME("Проверка по списку сомнительных клиентов");
        checkInfo1.setCHECK_RESULT("нет совпадений");
        checkInfo1.setCHECK_OK(true);
        CHECK_STOP_LIST.getCHECK_INFO().add(checkInfo4);

        CheckInfo checkInfo5 = new CheckInfo();
        checkInfo1.setCHECK_NAME("Проверка по стоп-листу банкротства");
        checkInfo1.setCHECK_RESULT("нет совпадений");
        checkInfo1.setCHECK_OK(true);
        CHECK_STOP_LIST.getCHECK_INFO().add(checkInfo5);

        CHECK_STOP_LIST.setCHECKS_COUNT(5);
        CHECK_STOP_LIST.setCHECKS_RESULT(true);
        CHECK_STOP_LIST.setRESULT_CODE(0);
        CHECK_STOP_LIST.setRESULT("");
    }
}
