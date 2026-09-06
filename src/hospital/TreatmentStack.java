package hospital;

import java.util.Stack;

public class TreatmentStack {

    private Stack<String> treatmentStack;

    // Constructor
    public TreatmentStack() {
        treatmentStack = new Stack<>();
    }

    // Push - add completed treatment
    public void push(String treatment) {
        treatmentStack.push(treatment);
        System.out.println("Treatment record added successfully.");
    }

    // Pop - remove most recent treatment
    public String pop() {

        if (treatmentStack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        String treatment = treatmentStack.pop();
        System.out.println("Treatment record removed.");

        return treatment;
    }

    // Display treatment records
    public void displayTreatments() {

        if (treatmentStack.isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("\n--- Treatment History ---");

        for (int i = treatmentStack.size() - 1; i >= 0; i--) {
            System.out.println(treatmentStack.get(i));
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return treatmentStack.isEmpty();
    }
}