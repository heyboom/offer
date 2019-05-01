package file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TestFile {
	public static void main(String[] args) {
		write();
		print();
	}

	public static void print() {
		File f = new File("E:/iotest/lol.txt");
		try(FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);)
		{
			Boolean bo = dis.readBoolean();
			int num = dis.readInt();
			String str = dis.readUTF();
			System.out.println(bo);
			System.out.println(num);
			System.out.println(str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		File f = new File("E:/iotest/lol.txt");
		try(FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			)
		{
			dos.writeBoolean(true);
			dos.writeInt(123);
			dos.writeUTF("my wife is a lazy lady");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
