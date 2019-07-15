public class MapOutPutFactory {
    public static MapOutPut getMapOutPut(String opname){
        if(opname.equals("qita")){
            return new MapOutPutImpl();
        } else {
            System.out.println("此方式暂未实现");
            System.exit(0);
            return new MapOutPutImplByStream();
        }
    }
}
