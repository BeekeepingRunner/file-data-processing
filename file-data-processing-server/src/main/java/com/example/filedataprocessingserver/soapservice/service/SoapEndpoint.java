package com.example.filedataprocessingserver.soapservice.service;

import com.example.filedataprocessingserver.db.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private LaptopRepository laptopRepository;

    @Autowired
    public SoapEndpoint(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProducerLaptopCountRequest")
    @ResponsePayload
    public io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse getProducerLatopCount(@RequestPayload io.spring.guides.gs_producing_web_service.GetProducerLaptopCountRequest request) {
        String producerName = request.getProducerName();
        int laptopCount = laptopRepository.getAllByManufacturer(producerName).size();

        io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse response = new io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse();
        response.setLaptopCount(laptopCount);
        return response;
    }
}
