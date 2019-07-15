import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOutPutImplByStream implements MapOutPut{

    @Override
    public void opMapOutPut() {
        int max=100,min=1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int ran1 =(int) (Math.random()*(max-min)+min);
            list.add(ran1);
        }
        Stream<Integer> stream = list.stream();
//        Map<Integer, Integer> collect = stream.collect();
//        collect.forEach((key, value) -> {
//            System.out.println("key: " + key + "    value: " + value);
//        });

//        stream.flatMap()
    }

    public static void main(String[] args) {
        new MapOutPutImplByStream().opMapOutPut();

    }

}
