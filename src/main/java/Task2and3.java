import java.util.ArrayList;
import java.util.Random;

public class Task2and3 {
    private static Object RuntimeException;

    public static void main(String[] args) {
        ArrayList <Integer> massiv=new ArrayList<Integer>();
        ArrayList <Integer> resultMassiv = new ArrayList<Integer>();
        Random random = new Random();
        int number;
        for (int i=0;i<10;i++){
            number= random.nextInt(10);
            massiv.add(number);
        }
        System.out.println(massiv);
        System.out.println(massiv.size());
        System.out.println();

        System.out.println(checkMassiv1or4Elements(massiv));

        try{
            resultMassiv=getRightSideMassiv(massiv);
            System.out.println(resultMassiv);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Integer> getRightSideMassiv(ArrayList<Integer> mass) throws RuntimeException{
        ArrayList <Integer> resultMassiv=new ArrayList<Integer>();
        int position=300000;
        boolean positionStatus=false;
        for (int i= mass.size()-1;i>=0;i--){
            if (mass.get(i)==4){
                position=i;
                positionStatus=true;
                break;
            }
        }
        if (positionStatus){
            for (int i=position+1;i< mass.size();i++){
                resultMassiv.add(mass.get(i));
            }
        }else{
            throw new RuntimeException("Четверки отсутствуют");
        }
        System.out.println(position);
        //System.out.println(positionStatus);

        return resultMassiv;
    }

    public static boolean checkMassiv1or4Elements(ArrayList<Integer> mass){
        boolean resultFlag1 = false;
        boolean resultFlag4 = false;
        for (int i=0;i<mass.size();i++){
            if (!resultFlag1 && mass.get(i)==1){
                resultFlag1 = true;
            }
            if (!resultFlag4 && mass.get(i)==4){
                resultFlag4=true;
            }
        }
        return (resultFlag1 & resultFlag4);
    }
}
