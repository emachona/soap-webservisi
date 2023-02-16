package com.example.soapwebservisi;

import com.localhost.oglas.Oglasi;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.localhost.oglas.Oglas;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.*;
import javax.xml.datatype.DatatypeFactory;

@Component
public class OglasiRepository {
    private static final Map<Integer, Oglas> oglasiMap = new HashMap<>();
    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        Oglas oglas1 = new Oglas();
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
                .newInstance().newXMLGregorianCalendar(gregorianCalendar);
        oglas1.setId(1);
        oglas1.setIme("Ime na oglas 1");
        oglas1.setOpis("Opis za prv oglas");
        oglas1.setStatus("NEW");
        oglas1.setCena(new BigDecimal(50.43));
        oglas1.setDatum(xmlGregorianCalendar);
        oglas1.setOcena(new BigDecimal(0.00));
        oglasiMap.put(oglas1.getId(), oglas1);

        Oglas oglas2 = new Oglas();
        oglas2.setId(2);
        oglas2.setIme("Ime na oglas 2");
        oglas2.setOpis("Opis za vtor oglas");
        oglas2.setStatus("NEW");
        oglas2.setCena(new BigDecimal(100.00));
        oglas2.setDatum(xmlGregorianCalendar);
        oglas2.setOcena(new BigDecimal(0.00));
        oglasiMap.put(oglas2.getId(), oglas2);
    }

    public Oglas findOglas(int id){
        System.out.println(oglasiMap.get(id));
        return oglasiMap.get(id);
    }

    public Oglasi findbyOcena(BigDecimal ocena){
        OglasiWrapper og = new OglasiWrapper();
        ArrayList oglasii = new ArrayList<Oglas>();
        Iterator<Map.Entry<Integer, Oglas>> new_Iterator = oglasiMap.entrySet().iterator();
        while (new_Iterator.hasNext()) {
            Oglas oglas = new_Iterator.next().getValue();
            if(oglas.getOcena().compareTo(ocena) == 0){
                oglasii.add(oglas);
            }
        }
        og.setOglasi(oglasii);

        return og;
    }

    public Oglas updateOglas(int id, BigDecimal cena){
        findOglas(id).setCena(cena);
        return oglasiMap.get(id);
    }

    public Oglas updateOcena(int id, BigDecimal ocena){
        if(ocena.compareTo(BigDecimal.valueOf(1)) != -1 && ocena.compareTo(BigDecimal.valueOf(10)) != 1){
            findOglas(id).setOcena(ocena);
        }
        return oglasiMap.get(id);
    }
}
