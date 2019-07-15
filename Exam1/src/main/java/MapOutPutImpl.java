import utils.SortUtil;

import java.util.*;

public class MapOutPutImpl implements MapOutPut{

    @Override
    public void opMapOutPut() {
        int max=100,min=1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int ran1 =(int) (Math.random()*(max-min)+min);
            list.add(ran1);
        }
        HashMap<Integer, List> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i)/10;
            if(map.get(key)==null){
                ArrayList<Object> innerList = new ArrayList<>();
                map.put(key,innerList);
            }
            map.get(key).add(list.get(i));
        }
        for (List varList : map.values()) {
            SortUtil.sortList(varList);
        }
        for (List varList : map.values()) {
            System.out.println(varList);
        }
    }

    public static void main(String[] args) {
        new MapOutPutImpl().opMapOutPut();
    }
}
