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
			// 启动
			serversocket = new ServerSocket(8088);
			System.out.println("服务器启动成功！");
			// 接受请求
			socket = serversocket.accept();
			// 信息交互
			while (true) {
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				if ((str = dis.readUTF()) != null) {
					System.out.println("客户端说：" + str);
				}
				dos.writeUTF("server say：" + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
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
