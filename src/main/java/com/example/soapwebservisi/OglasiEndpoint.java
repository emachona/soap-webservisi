package com.example.soapwebservisi;

import com.localhost.oglas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OglasiEndpoint {
    private static final String NAMESPACE_URI = "http://localhost.com/oglas";
    private OglasiRepository oglasiRepository;
    @Autowired
    public OglasiEndpoint(OglasiRepository oglasiRepository){
        this.oglasiRepository = oglasiRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOglasRequest")
    @ResponsePayload
    public GetOglasResponse getOglas(@RequestPayload GetOglasRequest request){
        GetOglasResponse response = new GetOglasResponse();
        System.out.println(oglasiRepository.findOglas(request.getId()));

        response.setOglas(oglasiRepository.findOglas(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOglasOcenaRequest")
    @ResponsePayload
    public GetOglasOcenaResponse getOglasOcena(@RequestPayload GetOglasOcenaRequest request){
        GetOglasOcenaResponse response = new GetOglasOcenaResponse();
        response.setOglasi(oglasiRepository.findbyOcena(request.getOcena()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOglasRequest")
    @ResponsePayload
    public UpdateOglasResponse updateOglas(@RequestPayload UpdateOglasRequest request){
        UpdateOglasResponse response = new UpdateOglasResponse();
        response.setOglas(oglasiRepository.updateOglas(request.getId(),request.getCena()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOcenaRequest")
    @ResponsePayload
    public UpdateOcenaResponse updateOcena(@RequestPayload UpdateOcenaRequest request){
        UpdateOcenaResponse response = new UpdateOcenaResponse();
        response.setOglas(oglasiRepository.updateOcena(request.getId(),request.getOcena()));
        return response;
    }
}
