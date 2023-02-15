package com.example.soapwebservisi;

import com.localhost.oglas.GetOglasRequest;
import com.localhost.oglas.GetOglasResponse;
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
}
