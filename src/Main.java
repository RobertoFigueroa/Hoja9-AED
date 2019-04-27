import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
*Universidad Del Valle de Guatemala
*
*  Roberto Figueroa - 18306
* */
public class Main {

    public static void main(String[] args) {

        //instancias utiles
        String textTest;
        ArrayList<String> text = new ArrayList<>();
        String englishWord = "";
        String spanishWord = "";
        int index;
        Scanner sc = new Scanner(System.in);
        Factory<String,String> factory =  new Factory<>();
        String[] textWords;

        System.out.println("1.Splay Binary Search Tree \n2.Red Black Tree\n" +
                "Ingrese el número correspondiente a la implementacion que desee realizar: ");
        int menuOption = sc.nextInt();
        BST tree = factory.Factory(menuOption);
        if(tree != null){

        try {
            FileReader file = new FileReader("C:\\Users\\rober\\OneDrive\\Documentos\\GitHub\\Hoja9-AED\\src\\freedict-eng-spa.dic");
            BufferedReader reader = new BufferedReader(file);
            while ((textTest = reader.readLine()) != null) {
                textTest = textTest.toLowerCase();
                index = textTest.indexOf('\t');
                englishWord = textTest.substring(0,index);
                spanishWord = textTest.substring((index+1),textTest.length());
                if(spanishWord.indexOf(',')>-1){
                    index = spanishWord.indexOf(',');
                    spanishWord = spanishWord.substring(0,index);
                }
                else if(spanishWord.indexOf(';')>-1){
                    index = spanishWord.indexOf(';');
                    spanishWord = spanishWord.substring(0,index);
                }
                else if(spanishWord.indexOf('\t')>-1){
                    index = spanishWord.indexOf('\t');
                    spanishWord = spanishWord.substring(0,index);
                }
                else{
                    spanishWord = spanishWord;
                }
                text.add(englishWord);
                text.add(spanishWord);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado" );
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i<text.size();i+=2){
            tree.put(text.get(i),text.get(i+1));
        }

            String lines = "";
            System.out.println("Texto en ingles extraido de un texto ubicado en la carpeta src de este proyecto");
            try{
                FileReader file = new FileReader("C:\\Users\\rober\\OneDrive\\Documentos\\GitHub\\Hoja9-AED\\src\\text");
                BufferedReader reader = new BufferedReader(file);
                while ((textTest = reader.readLine()) != null) {
                    textTest = textTest.toLowerCase();
                    lines =lines + textTest;
                }
                reader.close();
            }catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado" );
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nTexto en ingles: ");
            textWords = lines.split(" ");
            for(int h=0;h<textWords.length;h++){
                System.out.print(textWords[h] + " ");
            }

            for(int i = 0;i<textWords.length;i++){
                if(tree.contains(textWords[i])){
                    textWords[i] = tree.get(textWords[i]).toString();
                }
                else {
                    textWords[i] = "*"+textWords[i]+"*";
                }
            }
            System.out.println("\n\nTexto traducido en español: ");

            for(int h=0;h<textWords.length;h++){
                System.out.print(textWords[h] + " ");
            }

    }
        else{
            System.out.print("Ingreso incorrecto!");
        }
    }
    }


