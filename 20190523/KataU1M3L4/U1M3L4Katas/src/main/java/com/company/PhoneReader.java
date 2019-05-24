package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {

    public static void main(String[] args) {



        try {
            ObjectMapper mapper = new XmlMapper();

            List<Phone> phones;

            phones = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>(){});

            System.out.println("------------------Printing the car list after reading from XML file------------------");
            for (Phone phone : phones) {
                System.out.println("Brand: " + phone.getBrand());
                System.out.println("Model: " + phone.getModel());
                System.out.println("Processor: " + phone.getProcessor());
                System.out.println("Storage: " + phone.getStorage());
                System.out.println("Price: " + phone.getPrice());
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}
