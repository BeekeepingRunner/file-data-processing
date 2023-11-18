package com.example.filedataprocessingclient.soapclient;

import com.example.filedataprocessingclient.soapservice.GetProducerLaptopCountRequest;
import com.example.filedataprocessingclient.soapservice.GetProducerLaptopCountResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class LaptopClient extends WebServiceGatewaySupport {
    
    public GetProducerLaptopCountResponse getProducerLaptopCount(String producerName) {
        GetProducerLaptopCountRequest request = new GetProducerLaptopCountRequest();
        request.setProducerName(producerName);

       /* (GetProducerLaptopCountResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "",
                        new SoapActionCallback(
                                
                        )
                )*/
        return null;
    }
}
