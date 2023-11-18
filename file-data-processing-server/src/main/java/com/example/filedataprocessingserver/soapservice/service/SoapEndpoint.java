package com.example.filedataprocessingserver.soapservice.service;

import com.example.filedataprocessingserver.db.repositories.LaptopRepository;
import com.example.filedataprocessingserver.soapservice.generated.GetProducerLaptopCountRequest;
import com.example.filedataprocessingserver.soapservice.generated.GetProducerLaptopCountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/service";

    @Autowired
    private LaptopRepository laptopRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStringRequest")
    @ResponsePayload
    public GetProducerLaptopCountResponse getProducerLatopCount(@RequestPayload GetProducerLaptopCountRequest request) {
        String producerName = request.getProducerName();
        int laptopCount = laptopRepository.getAllByManufacturer(producerName).size();

        GetProducerLaptopCountResponse response = new GetProducerLaptopCountResponse();
        response.setLaptopCount(laptopCount);
        return response;
    }
}
