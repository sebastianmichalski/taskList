import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TopicList implements Runnable {

    private static final String EXIT = "exit";
    private final Map<String, List<Topic>> topic = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TopicList(in, out).run();
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show" -> show();
            case "help" -> help();
            default -> error(command);
        }
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(EXIT)) {
                break;
            }
            execute(command);
        }
    }

    public TopicList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  help");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

    //TODO: Using TDD approach create methots add() and show()

    private void add(String commandLine) {
    }

    private void show() {
    }


}