package hospital;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue(100);
    static TreatmentStack treatmentStack = new TreatmentStack();
    static VisitHistory visitHistory = new VisitHistory();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayPatients();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    displayWaitingPatients();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeTreatment();
                    break;

                case 10:
                    displayTreatments();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    removeVisit();
                    break;

                case 13:
                    searchVisit();
                    break;

                case 14:
                    displayVisitHistory();
                    break;

                case 0:
                    System.out.println("Thank you for using the Hospital System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("        Java Data Structures Project");
        System.out.println("==========================================");

        System.out.println("1.  Register New Patient");
        System.out.println("2.  Search Patient");
        System.out.println("3.  Delete Patient");
        System.out.println("4.  Display All Patients");

        System.out.println("5.  Add Patient to Emergency Queue");
        System.out.println("6.  Treat Next Emergency Patient");
        System.out.println("7.  Display Waiting Patients");

        System.out.println("8.  Add Treatment Record");
        System.out.println("9.  Remove Latest Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Visit History");

        System.out.println("0.  Exit");

        System.out.println("==========================================");
    }

    public static void registerPatient() {

        System.out.println("\n--- Register New Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    public static void searchPatient() {

        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            System.out.println("\nPatient Found:");
            patient.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();

        patientBST.delete(id);
    }

    public static void displayPatients() {

        System.out.println("\n--- All Patients ---");

        patientBST.displayInOrder();
    }

    public static void addEmergencyPatient() {

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {

            emergencyQueue.enqueue(patient);

        } else {

            System.out.println(
                "Patient not found. Please register the patient first."
            );
        }
    }

    public static void treatNextPatient() {

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {

            System.out.println("\nNow treating:");
            patient.displayPatient();

            System.out.println("Treatment started successfully.");
        }
    }

    public static void displayWaitingPatients() {

        emergencyQueue.displayQueue();
    }

    public static void addTreatment() {

        System.out.println("\n--- Add Treatment Record ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter treatment description: ");
        String treatment = scanner.nextLine();

        String record =
                "Patient ID: " + patientId
                + " | Patient Name: " + patient.getPatientName()
                + " | Treatment: " + treatment;

        treatmentStack.push(record);
    }

    public static void removeTreatment() {

        String treatment = treatmentStack.pop();

        if (treatment != null) {
            System.out.println("Removed Treatment:");
            System.out.println(treatment);
        }
    }

    public static void displayTreatments() {

        treatmentStack.displayTreatments();
    }

    public static void addVisit() {

        System.out.println("\n--- Add Patient Visit ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        visitHistory.addVisit(visit);
    }

    public static void removeVisit() {

        System.out.print("Enter Visit ID to remove: ");
        int visitId = scanner.nextInt();

        visitHistory.removeVisit(visitId);
    }

    public static void searchVisit() {

        System.out.print("Enter Visit ID to search: ");
        int visitId = scanner.nextInt();

        Visit visit = visitHistory.searchVisit(visitId);

        if (visit != null) {

            System.out.println("\nVisit Found:");
            visit.displayVisit();

        } else {

            System.out.println("Visit not found.");
        }
    }

    public static void displayVisitHistory() {

        visitHistory.displayHistory();
    }
}