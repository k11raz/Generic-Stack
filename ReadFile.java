import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile<T> {
    public Stack<T> fileToStack(String fileName) {
        Stack<T> stack = new Stack<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\" + fileName));
            String line;

            while ((line = br.readLine()) != null) {
                if (isInteger(line))
                    stack.push((T) Integer.valueOf(line));
                else
                    stack.push((T) line);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stack;
    }

    private boolean isInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
    }
    }
}
