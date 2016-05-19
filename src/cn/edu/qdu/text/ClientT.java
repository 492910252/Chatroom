package cn.edu.qdu.text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientT {
	public static void main(String[] args) {
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String str = null;
		String s = null;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			// 发送请求
			socket = new Socket("127.0.0.1", 8088);
			// 信息交互
			do {
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				System.out.print("请客户端说：");
				s = input.nextLine();
				dos.writeUTF(s);
				if ((str = dis.readUTF()) != null) {
					System.out.println(str);
				}
			} while (!s.equals("bye"));
			System.out.println("服务器关闭！");
		} catch (IOException e) {
			System.out.println("客户端关闭！");
		} finally {
			// 关闭
			try {
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
