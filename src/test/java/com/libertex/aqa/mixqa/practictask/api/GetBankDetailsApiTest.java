package com.libertex.aqa.mixqa.practictask.api;

import com.libertex.aqa.mixqa.practictask.api.model.BankDetailsResponse;
import com.libertex.aqa.mixqa.practictask.api.model.Requisite;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

@Slf4j
public class GetBankDetailsApiTest extends BaseTestAPI {
    private static final String REQUSITE = "LV51RTMB0000621806801";
    private static final String LANGUAGE_ISO3 = "rus";

    @Test(description = "Response body contains bank name - JSC RIETUMU BANKA")
    public void testGetOrgBankDetails() throws IOException {
        BankDetailsResponse response = bankStatementsApiHelper.getOrgBankDetails(REQUSITE, LANGUAGE_ISO3);

        List<Requisite> requisites = response.getRequisites();
        boolean isBankWithSwift = requisites.stream()
                .filter(requisite -> requisite.getBankInfo().getName().equals("JSC RIETUMU BANKA"))
                .anyMatch(requisite -> requisite.getBankInfo().getCodeType().equals("SWIFT"));

        Assertions.assertThat(isBankWithSwift).isTrue();
    }
}


