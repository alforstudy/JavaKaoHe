public class MapOutPutFactory {
    public static MapOutPut getMapOutPut(String opname){
        if(opname.equals("qita")){
            return new MapOutPutImpl();
        } else {
            return new MapOutPutImplByStream();
        }
    }
}
