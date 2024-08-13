import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileManager {

    public static void saveTrainersToFile(ArrayList<Trainer> trainerBook) {
        try (FileOutputStream fos = new FileOutputStream("tb.bin");
        	 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(trainerBook);// s);
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
    
    public static void saveMembersToFile(ArrayList<Member> memberBook) {
        try (FileOutputStream fos = new FileOutputStream("mb.bin");
        	 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(memberBook);
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }

    public static ArrayList<Member> loadMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
        	FileInputStream fis = new FileInputStream("mb.bin");
        	ObjectInputStream ois = new ObjectInputStream(fis);
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
    }
    
    
    public static ArrayList<Trainer> loadTrainersFromFile() throws Exception{
    	FileInputStream fis = new FileInputStream("tb.bin");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	ArrayList<Trainer> trainers = (ArrayList<Trainer>) ois.readObject();
        return trainers;
    } 
    
    public static void saveMembershipFee(int membershipFee) {
        try (FileOutputStream fos = new FileOutputStream("membershipFee.bin");
        	 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(membershipFee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadMembershipFee() {
        int fee = 0;
        try (FileInputStream fis = new FileInputStream("membershipFee.bin");
        	 ObjectInputStream ois = new ObjectInputStream(fis)) {
            fee = ois.readInt();
        } catch (IOException e) {
            // If the file doesn't exist or there's an error, assume 0
            fee = 0;
        }
        return fee;
    }
  

}
    
    

