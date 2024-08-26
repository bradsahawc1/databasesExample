import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.lang.String;

public class Homework {

    public static String findDep(String name, File file) throws FileNotFoundException {
        Scanner readfile = new Scanner(file);
        String temp;
        while((temp = readfile.nextLine()) != null) {
            if (temp.contains(name)) {
                int i = 0;
                for (String word : temp.split(",")) {
                    i++;
                    if (i == 5) {
                        return word;
                    }
                }
            }
        }
        return "-1";
    }

    public static String[] findPeople(String dep, String name, File file) throws FileNotFoundException {
        Scanner readfile = new Scanner(file);
        String temp;
        String templist[]= new String[50];
        int i = 0;
        while(readfile.hasNextLine()) {
            temp = readfile.nextLine();
            if (temp.contains(dep)) {
                if (!temp.contains(name)) {
                    int index = 0;
                    for (String word : temp.split(",")) {
                        if (index == 0) {
                            templist[i] = word;
                        }
                        index++;
                    }
                    i++;
                }
            }
        }
        return templist;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String dep;
        String list[];
        System.out.println("What is the name of the file?");
        File file = new File(input.nextLine());
        System.out.println("Who do you want to find?");
        String name = input.nextLine();

        dep = findDep(name, file);
        if (dep.equals("-1")) {
            System.out.println("Could not find the person");
            System.exit(0);
        }

        list = findPeople(dep, name, file);

        for (int i = 0; i < list.length; i++) {
            if (!(list[i] == null)) {
                System.out.println(list[i]);
            }
        }
    }
}


/*
Sample Input:
C:\\Users\\Cameron Bradshaw\\Documents\\Databases\\HW3_Bradshaw\\HW3_Bradshaw\\src\\employee-sample.csv
Adcock Sr Gerald W

 Output:
Colbert James M
Forney Bryan W.
Fouant Zelinda Joan
Harper Todd S
Johnson Bobby R
Johnson Jared
Johnson Richard
Jones David E
Kline Victoria
Klinger Dieter
Mack Patricia D
Malcom Betty L.
Miller Judith M
Milo Deborah L
Moeis Deri N
Pappachan Shoge
Plucinski Karen J
Rogers Richard L
Segal Harash N
Selbst Barbara A
Sessa Louis J
Shang Catherine L
Tang Karen N.
Tao Pea-Fen W.
Taormino Timothy P
Tarquinio Michael C
Varkey Samir J
Vellaiappan Balamurugan
Vernoy Gregory L
 */