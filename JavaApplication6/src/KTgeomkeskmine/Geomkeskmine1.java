package KTgeomkeskmine;
import java.io.*;
import java.util.*;

public class Geomkeskmine1 {
    
    public static String sqrt1() {
        
        double nr1 = 10;
        double nr2 = 20;
        double multiplication = nr1 * nr2;
        double sqrtMult = Math.sqrt(multiplication);  
        
        return "korrutisest Võetud ruutjuur on: "  + sqrtMult +"\n";
        
      }
    
   
    
   public static String sqrt2(double[] list) {

        int amount = 0;
        double multiplication = 1;
        double sqrt = 0;

        for (int i = 1; i < list.length; i++) {
            multiplication = multiplication * list[i];
            amount++;
        }

        sqrt = Math.pow(multiplication, 1.0 / amount);
        //System.out.println("arvude astendaja pöördväärtus: " + multiplication);
        return "arvude astedaja pöördväärtus on: "+ sqrt  +"\n";
    }


public static void main(String[] args) throws Exception{
    System.out.println(sqrt1());
    
    double[] list = {3, 5, 4, 6};
    System.out.println(sqrt2(list));
    
    
        List<Double> salaries = new ArrayList<Double>();

        BufferedReader in = new BufferedReader(new FileReader(new File("salarykoef.txt")));
        double salary = 0;
        int line = 0;
        double firstSalary = 0;
        double steadyKoef = 0;
        double newSalary = 0;
        double firstKoef = 0;
        
        for (String i = in.readLine(); i != null; i = in.readLine()){
            line++;

            if (line <= 1){
                    salary = Double.parseDouble(i);
                    firstSalary = salary;
                    steadyKoef = salary; 
            } if (line == 2){
                    firstKoef = (Double.parseDouble(i));
                    newSalary = firstKoef + firstSalary;
                    //System.out.println(newSalary);
                    salary = newSalary;
                    salaries.add(salary);
            } else {
                    newSalary = (Double.parseDouble(i)) + salary;
                    salary = newSalary;
                    salaries.add(salary);
            }

       }
        System.out.println(steadyKoef);
        System.out.println(firstKoef);
        for (int i=0; i<5; i++){
               steadyKoef = steadyKoef * firstKoef + steadyKoef;
        }

        String tmp=salaries.toString();
        PrintWriter pw=new PrintWriter(new FileWriter("salarychange.txt"));

        try{	
               pw.println(tmp.substring(1,tmp.length()-1));
               pw.println("püsiva koefitsiendi puhul: "+ steadyKoef);
               pw.close();

       } catch(Exception ex){

               ex.printStackTrace();

       }
            
        System.out.println(salaries);
    }
}