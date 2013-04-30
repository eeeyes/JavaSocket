import java.io.*;
import java.net.*;

public class EchoClient 
{
	public static void main(String[] args) throws IOException
	{
		Socket echoSocket = null;
		BufferedReader in = null;
		
		try {
			echoSocket = new Socket("127.0.0.1",7777);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		}catch (UnknownHostException e){
			System.err.println("don't know the host");
			System.exit(1);
		}catch (IOException e){
			System.err.println("couldn't got IO error");
			System.exit(1);
		}
		
		System.out.println(in.readLine());
		in.close();
		echoSocket.close();
		
	}
}
