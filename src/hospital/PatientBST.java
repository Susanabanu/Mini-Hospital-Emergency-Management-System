package hospital;

public class PatientBST {

    // Node class
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor
    public PatientBST() {
        root = null;
    }

    // Insert patient
    public void insert(Patient patient) {
        root = insertNode(root, patient);
    }

    private Node insertNode(Node node, Patient patient) {

        if (node == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < node.patient.getPatientId()) {
            node.left = insertNode(node.left, patient);
        } 
        else if (patient.getPatientId() > node.patient.getPatientId()) {
            node.right = insertNode(node.right, patient);
        } 
        else {
            System.out.println("Patient ID already exists.");
        }

        return node;
    }

    // Search patient
    public Patient search(int patientId) {
        Node result = searchNode(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node node, int patientId) {

        if (node == null) {
            return null;
        }

        if (patientId == node.patient.getPatientId()) {
            return node;
        }

        if (patientId < node.patient.getPatientId()) {
            return searchNode(node.left, patientId);
        }

        return searchNode(node.right, patientId);
    }

    // Delete patient
    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deleteNode(root, patientId);
        System.out.println("Patient deleted successfully.");
    }

    private Node deleteNode(Node node, int patientId) {

        if (node == null) {
            return null;
        }

        if (patientId < node.patient.getPatientId()) {
            node.left = deleteNode(node.left, patientId);
        } 
        else if (patientId > node.patient.getPatientId()) {
            node.right = deleteNode(node.right, patientId);
        } 
        else {

            // No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Only right child
            if (node.left == null) {
                return node.right;
            }

            // Only left child
            if (node.right == null) {
                return node.left;
            }

            // Two children
            Node successor = findMinimum(node.right);
            node.patient = successor.patient;
            node.right = deleteNode(
                    node.right,
                    successor.patient.getPatientId()
            );
        }

        return node;
    }

    // Find minimum node
    private Node findMinimum(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // In-order traversal
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node != null) {

            inOrder(node.left);

            node.patient.displayPatient();
            System.out.println("-------------------------");

            inOrder(node.right);
        }
    }
}