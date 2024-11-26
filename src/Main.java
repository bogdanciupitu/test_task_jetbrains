import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> program = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            program.add(line);
        }

        Interpreter interpreter = new Interpreter(program);
        interpreter.execute();
    }
}