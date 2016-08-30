package pack1;

import java.util.ArrayList;

public class Stack implements StackInterface<Disk> {

    @SuppressWarnings("CanBeFinal")
    public ArrayList<Disk> stack = new ArrayList<Disk>();

    public Stack(int diskAmt) { //fills the stack arrayList with the appropriate amount of disks.
        for (int i = 0; i < diskAmt; i++) {
            stack.add(new Disk(i));
        }
    }

    public Disk push(Disk o) {
        stack.add(0, o);
        return null;
    }

    public Disk peek() {
        return stack.get(0);
    }

    public Disk pop() {
        return stack.remove(0);
    }


    public boolean empty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }

    public Disk get(int x) {
        try {
            return stack.get(x);
        } catch (Exception e) {
            System.out.println("Invalid Index.");
        }
        return null;
    }
}