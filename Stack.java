import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {

    private final ArrayList<T> elements;

    public Stack() {
        this(10);
    }

    public Stack(int capacity) {
        int initCapacity = capacity > 0 ? capacity : 10;
        elements = new ArrayList<>(initCapacity);
    }

    public void push(T pushValue) {
        elements.add(pushValue);
    }

    public T pop() {
        if (elements.isEmpty())
            throw new EmptyStackException();

        return elements.remove(elements.size() - 1);
    }

    public void printStack() {
        for (int i = elements.size() - 1; i >= 0; i--) {
            System.out.println(elements.get(i));
        }
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public static <E extends Comparable<E>> void mergeStack(Stack<E> stack1, Stack<E> stack2, Stack<E> mergedStack) {
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            E top1 = stack1.pop();
            E top2 = stack2.pop();

            if (top1.compareTo(top2) <= 0) {
                mergedStack.push(top1);
                stack2.push(top2); // Push value2 back to stack2 because i need in reverse
            } else {
                mergedStack.push(top2);
                stack1.push(top1); // Push value1 back to stack1 because i need in reverse
            }
        }

        while (!stack1.isEmpty()) {
            mergedStack.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            mergedStack.push(stack2.pop());
        }

    }

    public static <E> void printReverse(Stack<E> st) {
        Stack<E> tempStack = new Stack<>();

        while (!st.isEmpty()) {
            E element = st.pop();    // what ı did in here because when i call printTwoStacks it said to me there's nothing
            tempStack.push(element); // then i push again
        }

        while (!tempStack.isEmpty()) {
            E element = tempStack.pop();
            st.push(element);
            System.out.println(element);
        }
    }

    public static <E,F> void printTwoStacks(Stack<E> stack1, Stack<F> stack2)
    {
        Stack<E> tempStack1 = new Stack<>();
        Stack<F> tempStack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            tempStack1.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            tempStack2.push(stack2.pop());
        }

        E topNumbers = null;
        if (!tempStack1.isEmpty()) {
            topNumbers = tempStack1.pop();
            tempStack1.push(topNumbers);
        }

        F topMountains = null;
        if (!tempStack2.isEmpty()) {
            topMountains = tempStack2.pop();
            tempStack2.push(topMountains);
        }

        while (!tempStack1.isEmpty() || !tempStack2.isEmpty()) {
            if (!tempStack1.isEmpty()) {
                System.out.printf("%2d         ", tempStack1.pop());
            } else {
                System.out.print("-------" + "          ");
            }

            if (!tempStack2.isEmpty()) {
                System.out.print(tempStack2.pop());
            } else {
                System.out.print("----------");
            }
            System.out.println();
        }

        System.out.println("Number stack top: " + topNumbers);
        System.out.println("String stack top: " + topMountains);
    }
}
