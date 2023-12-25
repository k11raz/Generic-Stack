public class Main {
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();

        Stack<Integer> numbers1 = rf.fileToStack("numbers1.txt");
        Stack<Integer> numbers2 = rf.fileToStack("numbers2.txt");

        Stack<String> mountains1 = rf.fileToStack("mountains1.txt");
        Stack<String> mountains2 = rf.fileToStack("mountains2.txt");

        Stack<Integer> mergedNumbers = new Stack<>();
        Stack<String> mergedMountains = new Stack<>();

        System.out.println("Numbers Stack1 :");
        numbers1.printStack();
        System.out.print("--------------------------------");
        System.out.println();

        System.out.println("Numbers Stack2:");
        numbers2.printStack();
        System.out.print("--------------------------------");
        System.out.println();


        System.out.println("Merged stack:");
        Stack.mergeStack(numbers1,numbers2,mergedNumbers);
        Stack.printReverse(mergedNumbers);
        System.out.print("--------------------------------");
        System.out.println();

        System.out.println("String Stack1 :");
        mountains1.printStack();
        System.out.print("--------------------------------");
        System.out.println();

        System.out.println("String Stack2:");
        mountains2.printStack();
        System.out.print("--------------------------------");
        System.out.println();

        System.out.println("Merged stack:");
        Stack.mergeStack(mountains1,mountains2,mergedMountains);
        Stack.printReverse(mergedMountains);
        System.out.print("--------------------------------");
        System.out.println();

        System.out.println("Integers   Strings ");
        Stack.printTwoStacks(mergedNumbers,mergedMountains);

    }
}