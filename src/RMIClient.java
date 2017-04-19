import java.rmi.*;
public class RMIClient {
	public static void main(String args[])
	{
		try {
		String host = "rmi://127.0.0.1/host";
		RemoteFileObject fObject = (RemoteFileObject) Naming.lookup(host);
		fObject.open("file.txt");
		String word;
		String addWord = "";
		while((word = fObject.readLine())!= null)
		{
		System.out.println(word);
		addWord += " " + word;
		}
		System.out.println(addWord);
		fObject.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
}
