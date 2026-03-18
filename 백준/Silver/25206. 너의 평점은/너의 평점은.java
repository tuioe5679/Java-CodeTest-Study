import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] subjects = new String[20];
        String[][] subjectFragment= new String[20][3];

        Map<String,Double> grades = new HashMap<>();
        grades.put("A+",4.5);
        grades.put("A0",4.0);
        grades.put("B+",3.5);
        grades.put("B0",3.0);
        grades.put("C+",2.5);
        grades.put("C0",2.0);
        grades.put("D+",1.5);
        grades.put("D0",1.0);
        grades.put("F",0.0);

        double[] conclusion = new double[20];
        double sumConclusion = 0;
        double credits = 0;
        double result;

        for(int i = 0; i < subjects.length; i++){
            subjects[i] = sc.nextLine();
        }

        for(int i = 0; i < subjects.length; i++){
            subjectFragment[i] = subjects[i].split(" ");
        }

        for(int i = 0; i < subjects.length; i++){
            if(!subjectFragment[i][2].equals("P")){
                conclusion[i] += (grades.get(subjectFragment[i][2]) * Double.parseDouble(subjectFragment[i][1]));
                credits += Double.parseDouble(subjectFragment[i][1]);
            }
        }

        for(double cons:conclusion){
            sumConclusion += cons;
        }
        result = sumConclusion / credits;
        System.out.println(result);
    }
}