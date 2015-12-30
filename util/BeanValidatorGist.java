package com.creditease.tradematch.tmfront.gist.util;

import com.creditease.tradematch.tmfront.dto.InvestReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;


/**
 *
 */
public class BeanValidatorGist {
    public static void main(String[] argv) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        String jsonString = Resources.toString(Resources.getResource("json/putInvestReq.json"), Charsets.UTF_8);

        InvestReq investReq = objectMapper.readValue(jsonString, InvestReq.class);

        Set<ConstraintViolation<InvestReq>> constraintViolations = validator.validate(investReq);
        for (ConstraintViolation<InvestReq> constraintViolation : constraintViolations) {
            System.out.println("[x] " + constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        }

        System.out.println(objectMapper.writeValueAsString(investReq));
    }
}
