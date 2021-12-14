import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManageObject {

	public ManageObject() {
	}

	public static void main(String[] args) {
		ManageObject manage = new ManageObject();
		String fullPath = "/Users/choejeong-gyun/Docum";
		SerialDTO dto = new SerialDTO("God of Java",1,true,100);
	}
	
	// 객체를 저장해 오기 
	public void saveObject(String fullPath,SerialDTO dto) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
	try {	
		fos = new FileOutputStream(fullPath);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(dto);
		System.out.println("Write Success");
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(oos != null) {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(fos != null) {
			try {
				fos.close();
			} catch(Exception e) {
				e.printStackTrace();
				}
			}
		}
	}
	
	// 객체를 읽어오기 
	public void loadObject(String fullPath) {
		FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(fullPath);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            SerialDTO dto = (SerialDTO)obj;
            System.out.println(dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
			}
		}
	}
}
