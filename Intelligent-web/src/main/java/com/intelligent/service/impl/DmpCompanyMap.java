package com.intelligent.service.impl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "dmp")
public class DmpCompanyMap {
    private Map<String, Integer> marketingPlateCompany;
}
