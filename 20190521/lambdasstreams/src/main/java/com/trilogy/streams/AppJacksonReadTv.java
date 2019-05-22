package com.trilogy.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class AppJacksonReadTv {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });


            System.out.println("List of all tvs:");
            System.out.println("================");
            for (Television tv : tvList) {
                System.out.println(tv.getBrand() + " - " + tv.getModel() + " - " + tv.getPrice() + " - " + tv.getScreenSize());
            }

            //----------------------------------------------------------------------------------------------------------
            System.out.println("\n  Tvs with screen size greater than 60:");
            System.out.println(" --------------------------------------------------------");
            System.out.println("|      Brand      |      Model      |  Price |Screen size|");
            System.out.println(" --------------------------------------------------------");
            tvList
                    .stream()
                    .filter(tv -> tv.getScreenSize() > 60)
                    .forEach(tv -> {
//                        System.out.println("===============");
//                        System.out.println("Brand: " + tv.getBrand());
//                        System.out.println("Model: " + tv.getModel());
//                        System.out.println("Price: " + tv.getPrice());
//                        System.out.println("Screen: " + tv.getScreenSize());
                        System.out.format("|  %-15s|  %-15s|  %-7d|   %-7d|%n", tv.getBrand(), tv.getModel(), tv.getPrice(), tv.getScreenSize());
                    });
            System.out.println(" --------------------------------------------------------");



            //----------------------------------------------------------------------------------------------------------
            Map<String, List<Television>> groupedTvs =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(tv -> tv.getBrand()));


            System.out.println("\nTvs brands:");
            System.out.println(" -----------");
            System.out.println("|   Brand   |");
            System.out.println(" -----------");
            Set<String> keys = groupedTvs.keySet();
            for(String key : keys) {
                System.out.printf("| %-10s|%n" , key);
            }
            System.out.println(" -----------");



            //----------------------------------------------------------------------------------------------------------
            double averageScreenSize =
            tvList
                    .stream()
                    .mapToInt(tv -> tv.getScreenSize())
                    .average()
                    .getAsDouble();

            System.out.println("\nAverage screensize is: " + averageScreenSize);
            System.out.println("=============================");


            //----------------------------------------------------------------------------------------------------------
            int maxScreenSize =
                    tvList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .max()
                            .getAsInt();
            System.out.println("\nMax horsepower: " + maxScreenSize);
            System.out.println("=============================");



            System.out.println("\n  Here is the sorted list of all tvs by screen size:");
            System.out.println(" --------------------------------------------------------");
            System.out.println("|      Brand      |      Model      |  Price |Screen size|");
            System.out.println(" --------------------------------------------------------");
            Collections.sort(tvList, new SortByScreenSize());
            for (Television tv : tvList){
                System.out.format("|  %-15s|  %-15s|  %-7d|   %-7d|%n", tv.getBrand(), tv.getModel(), tv.getPrice(), tv.getScreenSize());
            }
            System.out.println(" --------------------------------------------------------");
            //----------------------------------------------------------------------------------------------------------


        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }


    }
}
