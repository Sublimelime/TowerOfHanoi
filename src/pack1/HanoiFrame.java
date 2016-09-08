package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal", "WeakerAccess"})
public class HanoiFrame extends JFrame implements KeyListener {

    private int windowWidth = 700, windowHeight = 500; //size of the window.

    //private BufferedImage buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_4BYTE_ABGR);
    private int diskHeight, diskWidth;
    //stacks for poles
    private Stack diskStack1, diskStack2, diskStack3;

    public HanoiFrame(int disksAmt) {
        super("Tower Of Hanoi");// creates the JFrame with the given name

        //setup disks, stacks, etc.
        diskStack1 = new Stack(disksAmt);
        diskStack2 = new Stack(0); //other two stacks start empty
        diskStack3 = new Stack(0);
        diskHeight = 300 / disksAmt;
        diskWidth = 170 / disksAmt;

        //window handling
        addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Sets the close button to exit the program
        setResizable(false);// makes the window not able to be resized
        setSize(windowWidth, windowHeight);// sets the frame's size
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");
        setVisible(true);// shows the frame

    }

    public void paint(Graphics bg) {
        //todo paint graphics to screen, reinstate buffered graphics
        //Graphics bg = buffer.getGraphics();

        int poleWidth = 15; //width of the disk poles.
        int pole1X = (windowWidth / 4) + poleWidth / 2; //x position of the left of pole 1.
        int pole2X = 2 * ((windowWidth / 4)) + poleWidth / 2; //x position of the left of pole 2.
        int pole3X = 3 * ((windowWidth / 4)) + poleWidth / 2; //...

        //background --------------------------
        bg.setColor(Color.white);
        bg.fillRect(0, 0, windowWidth, windowHeight);

        //base ------------------------------
        bg.setColor(Color.gray);
        bg.fillRect(20, windowHeight - 40, windowWidth - 20, 20);

        //disk poles ------------------------------
        for (int i = windowWidth / 4; i < windowWidth; i += windowWidth / 4) {
            bg.fillRect(i, 100, poleWidth, windowHeight - 130);
        }

        //Displaying disks on poles ---------------------------

        //pole 1 ---------------------------------

        if (!diskStack1.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack1.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack1.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack1.get(i).getColor(0));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack1.get(i).getColor(1));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack1.get(i).getColor(2));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack1.get(i).getColor(3));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack1.get(i).getColor(4));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack1.get(i).getColor(5));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack1.get(i).getColor(6));
                        fillCenteredRect(pole1X, (i * diskHeight) + 160, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack1.get(i).getSize());
                        break;
                }
            }
        }

        //pole 2 ------------------------------

        if (!diskStack2.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack2.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack2.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack2.get(i).getColor(0));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack2.get(i).getColor(1));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack2.get(i).getColor(2));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack2.get(i).getColor(3));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack2.get(i).getColor(4));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack2.get(i).getColor(5));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack2.get(i).getColor(6));
                        fillCenteredRect(pole2X, (i * diskHeight) + 160, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack2.get(i).getSize());
                        break;
                }
            }
        }

        //pole 3 ----------------------------------------

        if (!diskStack3.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack3.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack3.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack3.get(i).getColor(0));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack3.get(i).getColor(1));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack3.get(i).getColor(2));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack3.get(i).getColor(3));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack3.get(i).getColor(4));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack3.get(i).getColor(5));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack3.get(i).getColor(6));
                        fillCenteredRect(pole3X, (i * diskHeight) + 160, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack3.get(i).getSize());
                        break;
                }
            }
        }

        //g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }

    //variables for keyTyped
    private boolean secondKey = false;
    private char firstKeyChar = ' ';
    private char secondKeyChar = ' ';

    @Override
    public void keyTyped(KeyEvent e) {
        //determine what key press this was

        if (!secondKey) { //if this is the first key pressed
            firstKeyChar = e.getKeyChar();
            secondKey = true; //next key will be the second key
        } else { //this is the second key
            secondKeyChar = e.getKeyChar();
            secondKey = false; //next typed key will be first key
            //make the movement
            if (firstKeyChar == '1' && secondKeyChar == '2') { //1>2
                if (transfer(diskStack1, diskStack2))
                    Logger.logUserMessage("Moved disk from stack 1 to stack 2.");
            }
            if (firstKeyChar == '1' && secondKeyChar == '3') { //1>3
                if (transfer(diskStack1, diskStack3))
                    Logger.logUserMessage("Moved disk from stack 1 to stack 3.");
            }
            if (firstKeyChar == '2' && secondKeyChar == '1') { //2>1
                if (transfer(diskStack2, diskStack1))
                    Logger.logUserMessage("Moved disk from stack 2 to stack 1.");
            }
            if (firstKeyChar == '2' && secondKeyChar == '3') { //2>3
                if (transfer(diskStack2, diskStack3))
                    Logger.logUserMessage("Moved disk from stack 2 to stack 3.");
            }
            if (firstKeyChar == '3' && secondKeyChar == '2') { //3>2
                if (transfer(diskStack3, diskStack2))
                    Logger.logUserMessage("Moved disk from stack 3 to stack 2.");
            }
            if (firstKeyChar == '3' && secondKeyChar == '1') { //3>1
                if (transfer(diskStack3, diskStack1))
                    Logger.logUserMessage("Moved disk from stack 3 to stack 1.");
            }
            repaint(); //repaint to update graphics.
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //unused
    }

    /**
     * Moves a disk from one stack to another stack
     *
     * @param from The stack to move from
     * @param to   The stack to move to.
     */
    private static boolean transfer(Stack from, Stack to) {
        if (!(from.empty()) && to.empty()) {
            to.push(from.pop());
            return true;
        }
        if (from.empty() || from.peek().getSize() > to.peek().getSize()) { //if bad move, from is empty, large onto small, etc.
            System.out.println("Invalid move made.");
            JOptionPane.showMessageDialog(null, "Invalid move. \nTry another move."); //warn the user about invalid move
            Logger.logUserMessage("User attempted invalid move.");
            return false;
        } else {
            to.push(from.pop());
            return true;
        }
    }


    /**
     * Draws a rectangle where the center of the rectangle is the X, instead of the upper left corner.
     * Height works similar to drawRect.
     *
     * @param x        X value to draw from.
     * @param y        Y value to draw from
     * @param width    Width of the rectangle
     * @param height   height of the rectangle
     * @param graphics Graphics to use to draw.
     */
    private void fillCenteredRect(int x, int y, int width, int height, Graphics graphics) {
        int newX = x - width / 2;
        /*System.out.println("Pole x is "+x);
        System.out.println("half of width is "+width/2);
        System.out.println("New x is:" +newX);*/
        graphics.fillRect(newX, y, width, height);
    }

}
