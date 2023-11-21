package com.example.filedataprocessingserver.soapservice.service;

import com.example.filedataprocessingserver.db.repositories.LaptopRepository;
import com.example.filedataprocessingserver.db.repositories.model.Laptop;
import io.spring.guides.gs_producing_web_service.GetLaptopListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Endpoint
public class SoapEndpoint {

    private static final Logger log = LoggerFactory.getLogger(SoapEndpoint.class);

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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLaptopListRequest")
    @ResponsePayload
    public io.spring.guides.gs_producing_web_service.GetLaptopListResponse getLaptopListRequest(
            @RequestPayload io.spring.guides.gs_producing_web_service.GetLaptopListRequest request
    ) {
        List<String> requestPropertyNames = request.getPropertyName();

        List<GetLaptopListResponse.Laptop> responseLaptops = laptopRepository.findAll().stream()
                .map(laptop -> mapLaptop(laptop, requestPropertyNames))
                .collect(Collectors.toList());

        io.spring.guides.gs_producing_web_service.GetLaptopListResponse response
                = new io.spring.guides.gs_producing_web_service.GetLaptopListResponse();
        response.getLaptop().addAll(responseLaptops);
        return response;
    }

    private GetLaptopListResponse.Laptop mapLaptop(Laptop laptop, List<String> requestPropertyNames) {
        GetLaptopListResponse.Laptop responseLaptop = new GetLaptopListResponse.Laptop();
        List<GetLaptopListResponse.Laptop.Property> responseLaptopProperties = responseLaptop.getProperty();

        for (String requestPropertyName : requestPropertyNames) {
            Field declaredField = null;
            try {
                declaredField = Laptop.class.getDeclaredField(requestPropertyName);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }

            declaredField.setAccessible(true);
            String propValue = "";
            try {
                propValue = (String) declaredField.get(laptop);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            GetLaptopListResponse.Laptop.Property responseProp = new GetLaptopListResponse.Laptop.Property();
            responseProp.setName(requestPropertyName);
            responseProp.setValue(propValue);
            responseLaptopProperties.add(responseProp);
        }

        return responseLaptop;
    }
}
