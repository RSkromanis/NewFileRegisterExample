import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;





public class WriteToFile {
    public static void main(String [] args){
        File file = new File("data/itlat19.txt");
        /********* Faila izveide, ja nepieciesams *******/
        try{
            file.createNewFile();
            System.out.println(file.getAbsoluteFile());
        }catch(Exception ex){
            System.out.println("Nogaja greizi " + ex.getMessage());
        }
        
/********* Rakstisana faila *******/
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true)); // seit true noradam, ja gribam pievienot faila gala, false, ja negribam pievienot ( viņš neturpina failu ) Ja false, tad vnk jaunu listu taisa, veco izdzēšot
            bw.write("Mani sauc Andris!");
            bw.newLine();
            bw.write("Super Maris");
            bw.newLine();
            bw.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        } 

/********* Faila lasisana pa rindinam *******/
        try {        
            BufferedReader br = new BufferedReader(new FileReader(file));
        
            String rindina;
            try {
                while((rindina = br.readLine()) != null){
                    System.out.println(rindina);
                }       
            } catch (IOException ex) {
                Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        /********* Faila lasisana pa simbolam *******/
        try {        
            BufferedReader br = new BufferedReader(new FileReader(file));
            int simbols;

            try {
                while((simbols = br.read()) != -1){
                    System.out.print(simbols + " = ");
                    System.out.println(Character.toChars(simbols));
                }        
            } catch (IOException ex) {
                Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        }                        
//                
//
    }
}

