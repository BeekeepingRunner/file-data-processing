package com.example.filedataprocessingserver.soapservice.service;

import com.example.filedataprocessingserver.db.repositories.LaptopRepository;
import com.example.filedataprocessingserver.db.repositories.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse getProducerLatopCount(
            @RequestPayload io.spring.guides.gs_producing_web_service.GetProducerLaptopCountRequest request
    ) {
        String producerName = request.getProducerName();
        int laptopCount = laptopRepository.getAllByManufacturer(producerName).size();

        io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse response
                = new io.spring.guides.gs_producing_web_service.GetProducerLaptopCountResponse();
        response.setLaptopCount(laptopCount);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProportionLaptopsCountRequest")
    @ResponsePayload
    public io.spring.guides.gs_producing_web_service.GetProportionLaptopsCountResponse getProportionLaptopCount(
            @RequestPayload io.spring.guides.gs_producing_web_service.GetProportionLaptopsCountRequest request
    ) {
        float resolutionFactor = 0f;
        if (request.isProportion1610()) {
            resolutionFactor = (float) 16 / 10;
        } else {
            resolutionFactor = (float) 16 / 9;
        }

        float finalResolutionFactor = resolutionFactor;
        long laptopCount = laptopRepository.findAll().stream()
                .filter(laptop -> Objects.nonNull(laptop.getScreenResolution()) && !laptop.getScreenResolution().isBlank())
                .filter(laptop -> {
                    String screenResolution = laptop.getScreenResolution();
                    String[] widthAndHeight = screenResolution.split("x");
                    if (widthAndHeight.length != 2) {
                        return false;
                    }

                    float width = Float.parseFloat(widthAndHeight[0]);
                    float height = Float.parseFloat(widthAndHeight[1]);
                    float laptopResult = width / height;
                    int precision = 6;
                    return areFloatsEqual(laptopResult, finalResolutionFactor, precision);
                })
                .count();


        io.spring.guides.gs_producing_web_service.GetProportionLaptopsCountResponse response
                = new io.spring.guides.gs_producing_web_service.GetProportionLaptopsCountResponse();
        response.setResult(laptopCount);
        return response;
    }

    private static boolean areFloatsEqual(float num1, float num2, int precision) {
        float epsilon = (float) Math.pow(10, -precision);

        return Math.abs(num1 - num2) < epsilon;
    }
}
