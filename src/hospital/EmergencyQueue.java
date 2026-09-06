package hospital;

public class EmergencyQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public EmergencyQueue(int capacity) {
        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue - add patient
    public void enqueue(Patient patient) {

        if (size == queue.length) {
            System.out.println("Emergency queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = patient;
        size++;

        System.out.println("Patient added to emergency queue.");
    }

    // Dequeue - remove next patient
    public Patient dequeue() {

        if (size == 0) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        System.out.println("Patient removed from emergency queue.");

        return patient;
    }

    // Display waiting patients
    public void displayQueue() {

        if (size == 0) {
            System.out.println("No patients are waiting.");
            return;
        }

        System.out.println("\n--- Emergency Waiting Queue ---");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % queue.length;

            Patient patient = queue[index];

            System.out.println("Patient ID: " + patient.getPatientId());
            System.out.println("Name: " + patient.getPatientName());
            System.out.println("Medical Condition: "
                    + patient.getMedicalCondition());
            System.out.println("-------------------------");
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
}