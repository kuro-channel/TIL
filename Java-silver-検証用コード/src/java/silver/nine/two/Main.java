package java.silver.nine.two;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Sample[] samples = {
                new Sample(2, "B"),
                new Sample(3, "C"),
                new Sample(1, "A")
        };

        List<Sample> list = new ArrayList<Sample>(Arrays.asList(samples));
        list.sort(new SampleComparator());

        for(Sample s: list){
            System.out.println(s.getName());
        }
    }
}
