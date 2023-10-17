package com.libertex.aqa.mixqa.practictask.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankInfo {
    private String codeType;
    private String code;
    private String name;
}
