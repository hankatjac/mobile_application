package masoud.ca.demo.java8;


import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationsExample {

    List<Car> carsArrayList;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public StreamOperationsExample() {
        carsArrayList = new ArrayList<>();
        dummyData();
        streamOperation();
    }

    public void dummyData(){

        carsArrayList.add(new Car(5,"e"));
        carsArrayList.add(new Car(3,"c"));
        carsArrayList.add(new Car(4,"d"));
        carsArrayList.add(new Car(2,"b"));
        carsArrayList.add(new Car(1,"a"));
        carsArrayList.add(new Car(1,"a"));
    }


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void streamOperation(){

        carsArrayList.stream().forEach(System.out::println);
        carsArrayList.stream().forEach(a-> System.out.println(a));

        // Add _suffix to end of all elements
        System.out.println("\nmap:");
        carsArrayList.stream().map(a -> a.getColor() + "_suffix").forEach(System.out::println);

        // Filter and sort does not change original data structure
        // Filter only names start with "mas"
        System.out.println("\nfilter:");
        carsArrayList.stream().filter(a->a.getColor().equals("a")).forEach(System.out::println);


        System.out.println("\nsorted:");
        Stream stream_0 = carsArrayList.stream().sorted((a, b)->a.getPrice()-b.getPrice());
        Stream stream_1 = carsArrayList.stream().sorted(Comparator.comparingInt(Car::getPrice));
        stream_1.forEach(System.out::println);

        System.out.println("\nskip:");
        carsArrayList.stream().skip(2).forEach(System.out::println);


        System.out.println("\nreduce:");
        Optional<Integer> sumOfPrice;
        sumOfPrice = carsArrayList.stream().map(Car::getPrice).reduce((price1,price2)->price1+price2);
        sumOfPrice.ifPresent(System.out::println);


        System.out.println("\ncount:");
        Long lowPrice = carsArrayList.stream().filter(a->a.getPrice()<3).count();
        System.out.println("Low price: " + lowPrice);


        System.out.println("\ncollector:");
        List<Car> newCarsArrayList = carsArrayList.stream().filter(a->a.getPrice()<3).collect(Collectors.toList());
        Set<Car> carsSet = carsArrayList.stream().filter(a->a.getPrice()<3).collect(Collectors.toSet());
        Map<String, Car> carsMap = carsArrayList.stream().filter(a->a.getPrice()<3).collect(Collectors.toMap(car->car.getColor()+ Math.random(), car->car));


        System.out.println("\nMatch:");
        boolean oneBlack = carsArrayList.stream().anyMatch(car->car.getColor().equals("a"));
        boolean allBlack = carsArrayList.stream().allMatch(car->car.getColor().equals("a"));
        boolean notBlack = carsArrayList.stream().noneMatch(car->car.getColor().equals("a"));


        // Cars with price less than 3, sort by price, show only 3 first item
        System.out.println("\nCars with price less than 3, sort by price, show only 3 first item:");
        carsArrayList.stream()
                .filter(car->car.getPrice()<3)
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(3)
                .forEach(System.out::println);


        // Range of numbers with stream
        System.out.println("\nRange of numbers with stream:");
        Stream.iterate(0, x->x+2).limit(10).forEach(System.out::println);


        // Prime number from 1 to 100
        System.out.println("\nPrime number from 1 to 100:");
        IntStream.range(2,100).filter(a-> IntStream.range(2, a-1).noneMatch(x -> a % x == 0)).forEach(System.out::println);


        // Read line from a file
        System.out.println("\nRead lines from a file:");
        try {
            Stream<String> lines = Files.lines(Paths.get("bank.txt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Parallel Stream
        // Do NOT parallel iterator. It will decrease the performance
        System.out.println("\nParallel Stream:");
        carsArrayList.stream().parallel()
                .sorted(Comparator.comparingInt(Car::getPrice))
                .forEach(System.out::println);
    }
}
