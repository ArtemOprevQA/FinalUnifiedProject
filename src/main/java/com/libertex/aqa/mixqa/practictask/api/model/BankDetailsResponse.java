package com.libertex.aqa.mixqa.practictask.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class BankDetailsResponse {
    private ResponseInfo responseInfo;
    private List<Requisite> requisites;
}
