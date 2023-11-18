package com.example.filedataprocessingclient.soapclient;

import com.example.filedataprocessingclient.soapservice.GetProducerLaptopCountRequest;
import com.example.filedataprocessingclient.soapservice.GetProducerLaptopCountResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class LaptopClient extends WebServiceGatewaySupport {
    
    public GetProducerLaptopCountResponse getProducerLaptopCount(String producerName) {
        GetProducerLaptopCountRequest request = new GetProducerLaptopCountRequest();
        request.setProducerName(producerName);

        GetProducerLaptopCountResponse response = (GetProducerLaptopCountResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/soapservice",
                        request,
                        null
                );
        return response;
    }
}
