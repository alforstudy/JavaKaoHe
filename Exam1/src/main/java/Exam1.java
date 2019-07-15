public class Exam1 {
    public static void main(String[] args) {
        String opname = args[0];
        MapOutPut mapOutPut = MapOutPutFactory.getMapOutPut(opname);
        mapOutPut.opMapOutPut();
    }
}
