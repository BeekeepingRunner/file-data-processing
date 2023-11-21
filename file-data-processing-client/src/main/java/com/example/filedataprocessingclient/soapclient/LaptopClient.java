package com.example.filedataprocessingclient.soapclient;

import com.example.filedataprocessingclient.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class LaptopClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LaptopClient.class);

    public GetProducerLaptopCountResponse getProducerLaptopCountResponse(String producerName) {

        GetProducerLaptopCountRequest request = new GetProducerLaptopCountRequest();
        request.setProducerName(producerName);

        log.info("Requesting laptop count for producer name: " + producerName);

        return (GetProducerLaptopCountResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/soapLaptops",
                        request,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/getProducerLaptopCountRequest")
                );
    }

    public GetProportionLaptopsCountResponse getProportionLaptopsCountResponse(String screenRatio) {

        GetProportionLaptopsCountRequest request = new GetProportionLaptopsCountRequest();

        switch (screenRatio) {
            case "16x9" -> request.setProportion169(true);
            case "16x10" -> request.setProportion1610(true);
            default -> log.error("Cannot send soap request for laptop count: Unexpected screen ratio");
        }

        log.info("Requesting laptop count for screen ratio: " + screenRatio);

        return (GetProportionLaptopsCountResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/soapLaptops",
                        request,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/getProportionLaptopsCountRequest")
                );
    }

    public GetLaptopListResponse getLaptopListResponse(List<String> propertyNames) {

        GetLaptopListRequest request = new GetLaptopListRequest();
        List<String> requestPropertyNames = request.getPropertyName();
        requestPropertyNames.addAll(propertyNames);

        log.info("Requesting laptop list with specified properties");

        return (GetLaptopListResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/soapLaptops",
                        request,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/getLaptopListRequest")
                );
    }
}
