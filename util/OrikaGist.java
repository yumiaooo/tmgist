package com.creditease.tradematch.tmfront.gist.util;

import com.creditease.tradematch.domain.DebtSet;
import com.creditease.tradematch.domain.TransferFormReq;
import com.creditease.tradematch.tmfront.dto.TransferReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class OrikaGist {
    public static void main(String[] argv) throws IOException {
        URL url = Resources.getResource("json/putTransferReq.json");
        String json = Resources.toString(url, Charsets.UTF_8);

        final ObjectMapper mapper = new ObjectMapper();
        final TransferReq req = mapper.readValue(json, TransferReq.class);

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();

        mapperFactory.classMap(TransferReq.class, TransferFormReq.class)
                .fieldAToB("requestId", "financeFormId")
                .exclude("investProductType")
                .exclude("isTotal")
                .exclude("isSplit")
                .exclude("isPartSuccess")
                .exclude("matchId")
                .byDefault(MappingDirection.A_TO_B)
                .register();


        mapperFactory.classMap(TransferReq.DebtSet.class, DebtSet.class)
                .exclude("debtSignType")
                .exclude("loanSource")
                .exclude("leftTerm")
                .exclude("repayType")
                .exclude("repayDay")
                .exclude("mortgageType")
                .exclude("creditLevel")
                .exclude("compensateType")
                .byDefault(MappingDirection.A_TO_B)
                .register();

        BoundMapperFacade<TransferReq, TransferFormReq> boundMapper = mapperFactory.getMapperFacade(TransferReq.class, TransferFormReq.class, false);

        TransferFormReq apamaReq = boundMapper.map(req);

        System.out.println(ReflectionToStringBuilder.toString(apamaReq, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(apamaReq.getDebtSet().get(0), ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(apamaReq.getDebtSet().get(1), ToStringStyle.MULTI_LINE_STYLE));

        mapperFactory.getMapperFacade(TransferReq.class, TransferFormReq.class, false);
    }
}
