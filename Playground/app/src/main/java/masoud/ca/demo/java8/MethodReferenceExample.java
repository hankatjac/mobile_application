package masoud.ca.demo.java8;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {


    // Just to show how Optional is defined in Java 8
    private Optional<Integer> myInteger;




    public MethodReferenceExample() {

        SampleObjectWithSomeMethods sampleObjectWithSomeMethodsObject = new SampleObjectWithSomeMethods();

        //..................................................
        // Function<T, U> is a functional interface in Java 8 which convert type T to type U
        // Here we assigned 'sampleObjectWithSomeMethodsObject::method1' to this interface.
        // It is like we implemented this interface by pointing it to a method from an object that has one input type and one output type
        Function<Integer, Integer> function = sampleObjectWithSomeMethodsObject::method1;

        // Because we have a reference to a method for our above functional interface, so we can use it as it already implemented
        function.apply(7);
        // In this line we called below defined method 'functionPassingTest' and
        // passed Function reference we created by assigning 'sampleObjectWithSomeMethodsObject::method1' to it in above line
        functionPassingTest(function, "Some String");


        // As can be seen method referencing is not like calling a method, and below line will generate an error
        //Function<Integer, Integer> function1_ = sampleObjectWithSomeMethodsObject.method1(2);
        //Function<Integer, Integer> function = sampleObjectWithSomeMethodsObject::method1;
        //methodPassingTest(function, "Hi");
        //..................................................



        //..................................................
        // Consumer<T> is an other functional interface that get an object of type T and use it
        // or consume it. It does not return any object
        Consumer<Boolean> consumer = sampleObjectWithSomeMethodsObject::method3;

        // In this line we called below defined method 'consumerPassingTest' and passed Consumer reference we created by
        // assigning 'sampleObjectWithSomeMethodsObject::method3' to it in above line
        consumerPassingTest(consumer, "Bye");
        //..................................................



        //..................................................
        // Predicate<T> is an other functional interface in Java 8 that receive an object of type T and return a boolean
        // An example of static method reference
        Predicate<Boolean> predicate = SampleObjectWithSomeMethods::method4;

        // In this line we called below defined method 'predicatePassingTest' and
        // passed Predicate reference we created by assigning 'sampleObjectWithSomeMethodsObject::method4' to it in above line
        predicatePassingTest(predicate,"Again Hi");
        //..................................................
    }








    //------------------------------------------------------------------------------------------------------------------
    // Here as an example we defined 3 methods that each of them has an argument
    // Each of these methods argument is type of one of Java8 predefined functional interface
    public void functionPassingTest(Function<Integer, Integer> function , String string){

        int myNormalInt;

        myNormalInt = function.apply(2);
        System.out.println("******  Function :   *******   " + string);
        System.out.println(myNormalInt);
    }

    public void consumerPassingTest(Consumer<Boolean> consumer , String string){
        consumer.accept(true );
        System.out.println("consumer is run ");
    }

    public void predicatePassingTest(Predicate<Boolean> predicate , String string){
        System.out.println("predecate :   " + predicate.test(false));
    }
    //------------------------------------------------------------------------------------------------------------------
}
