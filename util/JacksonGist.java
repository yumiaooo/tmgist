package com.creditease.tradematch.tmfront.gist.util;

import com.creditease.tradematch.domain.TransferFormRequest;
import com.creditease.tradematch.tmfront.dto.InvestReq;
import com.creditease.tradematch.tmfront.dto.TransferReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

/**
 *
 */
public class JacksonGist {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main2(String[] argv) throws IOException {
        URL url = Resources.getResource("json/putTransferReq.json");
        String json = Resources.toString(url, Charsets.UTF_8);

        TransferReq req = mapper.readValue(json, TransferReq.class);

        String json2 = mapper.writeValueAsString(req);
        System.out.println(json2);
    }

    public static void main3(String[] argv) throws IOException {
//        TransferReq req = new TransferReq();
//        req.setFinanceAmount(new BigDecimal("10000.00"));
        TransferFormRequest apamaReq = new TransferFormRequest();
        apamaReq.setFinanceAmount(new BigDecimal("10000.00"));

        String json2 = mapper.writeValueAsString(apamaReq);
        System.out.println(json2);
    }

    public static void main(String[] argv) throws IOException {
        URL url = Resources.getResource("json/putInvestReq.json");
        String json = Resources.toString(url, Charsets.UTF_8);

        InvestReq req = mapper.readValue(json, InvestReq.class);

        System.out.println(req);
        System.out.println();

        String json2 = mapper.writeValueAsString(req);
        System.out.println(json2);
    }
}
