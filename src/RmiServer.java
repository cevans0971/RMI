import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;


public class RmiServer extends UnicastRemoteObject implements RemoteFileObject {
	

	BufferedReader buff;
public RmiServer() throws RemoteException {
		
		// TODO Auto-generated constructor stub
	}
     public static void main(String args[]){
     
    	 try
    	 {
    		 RemoteFileObject host = new RmiServer();
    		 Naming.rebind("host1",host);
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    	 }
    	
     }
	@Override
	
	public void open(String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		try
		{
			buff = new BufferedReader(new FileReader(fileName));
		}
		catch(java.io.IOException e){
   	 
   		 throw new RemoteException("Io Exception",e);
		}
	}

	@Override
	public String readLine() throws RemoteException {
		// TODO Auto-generated method stub
		try
		{
		return buff.readLine();
	}
		catch(java.io.IOException e){
		   	 
	   		 throw new RemoteException("Io Exception",e);
			}
	}

	@Override
	public void close() throws RemoteException {
		// TODO Auto-generated method stub
		try
		{
		buff.close();
	}
		catch(java.io.IOException e){
		   	 
	   		 throw new RemoteException("Io Exception",e);
			}
	}
	}


