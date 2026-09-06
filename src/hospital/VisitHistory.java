package hospital;

public class VisitHistory {

    // Node for Singly Linked List
    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    // Constructor
    public VisitHistory() {
        head = null;
    }

    // Add a new visit
    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Remove a visit using Visit ID
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Search for a visit
    public Visit searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Display all visits
    public void displayHistory() {

        if (head == null) {
            System.out.println("No previous visits available.");
            return;
        }

        System.out.println("\n--- Patient Visit History ---");

        Node current = head;

        while (current != null) {

            current.visit.displayVisit();
            System.out.println("-------------------------");

            current = current.next;
        }
    }
}