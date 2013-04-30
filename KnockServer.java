import java.net.*;
import java.io.*;

public class KnockServer
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(7777);
		}catch(IOException e){
			System.err.println("cloud not listen on 7777");
			System.exit(1);
		}
		
		Socket clientSocket = null;
		PrintWriter out = null;
		while(true){
			try{
				clientSocket = serverSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				out.println("heavily computed");
				out.close();
				clientSocket.close();
			}catch(IOException e){
				System.err.println("accept failed");
				System.exit(1);
			}
		}			
	
	}
}
