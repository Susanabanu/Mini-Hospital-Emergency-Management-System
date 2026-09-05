# Mini Hospital Emergency Management System

## Introduction

This project is a Mini Hospital Emergency Management System developed using Java and Data Structures.

The system manages patient records, emergency patients, treatment history, and patient visit history using different data structures.

## Data Structures Used

### 1. Binary Search Tree (BST)
Used to manage patient records.

Operations:
- Insert patient
- Search patient by Patient ID
- Delete patient
- Display patients using in-order traversal

### 2. Queue
Used to manage emergency patients.

Operations:
- Enqueue patient
- Dequeue patient
- Display waiting patients
- Check whether the queue is empty

The Queue follows FIFO (First In, First Out).

### 3. Stack
Used to manage treatment history.

Operations:
- Push treatment record
- Pop latest treatment record
- Display treatment history
- Check whether the stack is empty

The Stack follows LIFO (Last In, First Out).

### 4. Singly Linked List
Used to manage patient visit history.

Operations:
- Add visit
- Remove visit
- Search visit
- Display visit history

## Technologies Used

- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure

```text
Mini-Hospital-Emergency-Management-System
│
└── src
    └── hospital
        ├── Patient.java
        ├── PatientBST.java
        ├── EmergencyQueue.java
        ├── TreatmentStack.java
        ├── Visit.java
        ├── VisitHistory.java
        └── Main.java


## Class Description

### Patient.java

Stores patient information including:
- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

### PatientBST.java

Implements the Binary Search Tree for patient records.

### EmergencyQueue.java

Implements the emergency patient Queue using FIFO.

### TreatmentStack.java

Implements the treatment history Stack using LIFO.

### Visit.java

Stores patient visit information including:
- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

### VisitHistory.java

Implements the Singly Linked List for patient visit history.

### Main.java

Contains the main menu and connects all data structures to provide the hospital management system.

## How to Run

1. Open Eclipse IDE.
2. Open the `MiniHospitalEmergencySystem` Java project.
3. Make sure all Java files are inside the `hospital` package.
4. Open `Main.java`.
5. Right-click `Main.java`.
6. Select **Run As → Java Application**.
7. The hospital management menu will appear in the Eclipse Console.
8. Select the required option by entering the menu number.
9. Enter the required patient, treatment, or visit details.

## Example Operations

### Patient Management

Patients can be registered using the Patient ID, name, age, contact number, and medical condition.

### Emergency Queue

Registered patients can be added to the emergency queue and treated according to FIFO order.

### Treatment History

Completed treatments are stored in the stack. The most recent treatment can be removed using the Pop operation.

### Visit History

Patient visits can be added, searched, removed, and displayed using the Singly Linked List.

## Testing

The following operations were tested:

- Patient insertion
- Patient search
- Patient deletion
- In-order patient display
- Emergency patient enqueue
- Emergency patient dequeue
- Emergency queue display
- Treatment push
- Treatment pop
- Treatment history display
- Visit addition
- Visit search
- Visit removal
- Visit history display

## Author

CIT300 - Data Structures and Algorithms

Individual Mid Assignment

Mini Hospital Emergency Management System
