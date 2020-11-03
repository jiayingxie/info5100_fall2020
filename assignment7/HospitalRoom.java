public class HospitalRoom {
    //TODO: implement your code here

    // the number of doctor in the room.
    private static int doctorNum = 0;
    private final Object doctorLock = new Object();
    // the number of patient in the room.
    private static int patientNum = 0;
    private final Object patientLock = new Object();

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        //TODO: implement your code here

        // use synchronized (doctorLock), so the other thread will
        // not use the resources.
        synchronized (doctorLock) {
            // there is already a doctor in the room, this doctor(thread)
            // has to wait until be notified.
            if (doctorNum == 1) {
                System.out.println("Doctor " + d.name
                        + " is waiting to Enter, number of doctor " + doctorNum);
                doctorLock.wait();
                // !!!pay attention, in main(), while(!room.doctorEnter(p1)),
                // means if the doctor could not enter, he/she will try
                // again and again until he/she is able to enter. So when
                // doctorNum is equal to 1, the room for doctor is full,
                // the doctor is not allowed to enter. The return value
                // should be false, only in this way, the code
                // while(!room.doctorEnter(john)) {} will run again and again.
                return false;
            } else {
                doctorNum += 1;
                System.out.println("Doctor " + d.name
                        + " Entered, number of doctor" + doctorNum);
                // now, there is a doctor in the room, so we could
                // notify the leave method.
                doctorLock.notify();
                // now, since the doctor enter the room, in main() I do
                // not need to execute while(!room.doctorEnter(john)) {},
                // only when return value is true, the previous code
                // will not run.
                return true;
            }
        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        //TODO: implement your code here
        synchronized (doctorLock) {
            // since there is no doctor in the room, I do not have
            // person to leave, so this thread has to wait.
            if (doctorNum == 0) {
                doctorLock.wait();
                // same as doctor enter
                return false;
            } else {
                doctorNum -= 1;
                System.out.println("Doctor " + d.name
                        + " Left, number of doctor " + doctorNum);
                // now, there is no doctor in the room, so notify
                // the enter method.
                doctorLock.notify();
                // same as doctor enter
                return true;
            }
        }
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        //TODO: implement your code here
        synchronized (patientLock) {
            // now the room is full, the others have to wait until
            // some person leave.
            if (patientNum == 3) {
                System.out.println("Patient " + p.name
                        + " is waiting to enter, number of patients " + patientNum);
                patientLock.wait();
                return false;
            } else {
                // some person leave.
                patientNum += 1;
                System.out.println("Patient " + p.name
                        + " entered, number of patients " + patientNum);
                // notify leave method.
                patientLock.notify();
                return true;
            }
        }
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        //TODO: implement your code here
        synchronized (patientLock) {
            // there is no patient in the room.
            if (patientNum == 0) {
                patientLock.wait();
                return false;
            } else {
                patientNum -= 1;
                System.out.println("Patient " + p.name + " left");
                patientLock.notify();
                return true;
            }
        }
    }
}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                    while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                    while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
    /*
    * console output
Doctor siva Entered, number of doctor1
Patient p1 entered, number of patients 1
Doctor john is waiting to Enter, number of doctor 1
Patient p2 entered, number of patients 2
Patient p3 entered, number of patients 3
Patient p4 is waiting to enter, number of patients 3
Patient p5 is waiting to enter, number of patients 3
Patient p1 left
Doctor siva Left, number of doctor 0
Doctor john Entered, number of doctor1
Patient p2 left
Patient p5 entered, number of patients 2
Patient p4 entered, number of patients 3
Patient p3 left
Doctor john Left, number of doctor 0
Patient p5 left
Patient p4 left
    * */
}
