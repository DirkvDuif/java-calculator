import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("First number: ");
        String firstNumber = System.console().readLine();
        System.out.print("Second number: ");
        String secondNumber = System.console().readLine();

        try {
            System.out.println(Calculator.add(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber)));
        } catch (NumberFormatException e) {
            System.out.println("The given input cannot be converted to an integer.");
        }
    }
}