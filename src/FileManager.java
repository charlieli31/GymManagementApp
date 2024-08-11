import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileManager {

    public static void saveTrainersToFile(ArrayList<Trainer> trainerBook) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tb.bin"))) {
            oos.writeObject(trainerBook);// s);
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
    
    public static void saveMembersToFile(ArrayList<Member> memberBook) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mb.bin"))) {
            oos.writeObject(memberBook);
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }

    public static ArrayList<Member> loadMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
        	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mb.bin"));
            members = (ArrayList<Member>) ois.readObject();
            if (members.isEmpty()) {
                JOptionPane.showMessageDialog(null, "The member list is empty.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            return members;
        } 
        catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Error loading members from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           // e.printStackTrace();
        	return members;
        }
      //  return members;
    }
    
    
    public static ArrayList<Trainer> loadTrainersFromFile() throws Exception{
    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tb.bin"));
    	ArrayList<Trainer> trainers = (ArrayList<Trainer>) ois.readObject();
        return trainers;
        } 
  
    }
    
    

