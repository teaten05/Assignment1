import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        int warn = 0, info = 0, error = 0, memory = 0;

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new Queue<>();


        try{

            Scanner input = new Scanner(System.in);

            File file = new File("lib/log-data.csv");
            input = new Scanner(file);

            while(input.hasNextLine()){

                String line = input.nextLine();
                //System.out.println(line);
                queue.enqueue(line);

            }

        } catch(Exception e){

            e.printStackTrace();

        }

        for(int i = 0; i< queue.size(); i++){

            String k = queue.dequeue();
            if (k.contains("INFO")){

                info++;

            }
            else if (k.contains("WARN")){

                warn++;

                if (k.contains("Memory")){ memory ++; }

            }
            else if (k.contains("ERROR")){

                error++;
                stack.push(k);

            }

        }

        System.out.println("Number of INFO entries: "+info);
        System.out.println("Number of WARN entries: "+warn);
        System.out.println("Number of Memory warning entries: "+ memory);
        System.out.println("Number of ERROR entries: "+error);
        System.out.println("Last 100 ERROR entries: ");

        for(int i = 0; i<100; i++){
            if (stack.isEmpty()) {
                break;
            }
            System.out.println(stack.pop());

        }
    }

}