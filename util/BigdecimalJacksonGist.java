package com.creditease.tradematch.tmfront.gist.util;

import com.creditease.tradematch.tmfront.dto.InvestReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 */
public class BigdecimalJacksonGist {
    public static void main(String[] argv) throws IOException {
        String json = "{\"value\":\"3.141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279141592653589793238462643383279\"}";
//        String json = "{\"value\":\"10000.00\"}";
//        String json = "{\"value\":\"3.141592653589793238462643383279\"}";

        ObjectMapper mapper = new ObjectMapper();
        SomeDTO obj = mapper.readValue(json, SomeDTO.class);

        String json2 = mapper.writeValueAsString(obj);

        System.out.println(obj.value);
        System.out.println(obj.d);

        System.out.println(json2);
    }

    public static class SomeDTO {
//        @JsonSerialize(using = ToStringSerializer.class)
        private BigDecimal value;

        private Double d;

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public Double getD() {
            return d;
        }

        public void setD(Double d) {
            this.d = d;
        }
    }
}
