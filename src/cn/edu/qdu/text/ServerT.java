package cn.edu.qdu.text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerT {
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String str = null;
		try {
			// ����
			serversocket = new ServerSocket(8088);
			System.out.println("�����������ɹ���");
			// ��������
			socket = serversocket.accept();
			// ��Ϣ����
			while (true) {
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				if ((str = dis.readUTF()) != null) {
					System.out.println("�ͻ���˵��" + str);
				}
				dos.writeUTF("server say��" + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر�
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
