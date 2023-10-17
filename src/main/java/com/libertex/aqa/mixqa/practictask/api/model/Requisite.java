package com.libertex.aqa.mixqa.practictask.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Requisite {
    private String requisite;
    private String currency;
    private BankInfo bankInfo;
    private OwnerInfo ownerInfo;
}
