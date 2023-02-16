package com.example.soapwebservisi;

import com.localhost.oglas.Oglasi;
import com.localhost.oglas.Oglas;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "oglasi",
        propOrder = {"oglas"}
)
public class OglasiWrapper extends Oglasi {
    public void setOglasi(ArrayList<Oglas> oglasi) {
        oglas = oglasi;
    }
}