package com.creditease.tradematch.tmfront.gist.util;

import com.creditease.tradematch.domain.TransferFormRequest;
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
    public static void main2(String[] argv) throws IOException {
        URL url = Resources.getResource("json/putTransferReq.json");
        String json = Resources.toString(url, Charsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        TransferReq req = mapper.readValue(json, TransferReq.class);

        String json2 = mapper.writeValueAsString(req);
        System.out.println(json2);
    }

    public static void main(String[] argv) throws IOException {
//        TransferReq req = new TransferReq();
//        req.setFinanceAmount(new BigDecimal("10000.00"));
        TransferFormRequest apamaReq = new TransferFormRequest();
        apamaReq.setFinanceAmount(new BigDecimal("10000.00"));

        ObjectMapper mapper = new ObjectMapper();
        String json2 = mapper.writeValueAsString(apamaReq);
        System.out.println(json2);
    }
}
