import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public String reverse(String s) {
        Character ch; 
        String ans="";
        for (int i=0; i<s.length(); i++)
        {
          ch= s.charAt(i); 
          ans=ch+ans; 
        }
        return ans ;
    }

    public Character minChar(String s){
        char min = 'z';

        for (int i=0; i<s.length()-1; i++)   
            if (s.charAt(i) < min)
                min = s.charAt(i);  
        
        return min;         
    }

    public String caseChanger(String s){
        
        StringBuffer ans = new StringBuffer(s); 
         
        for (int i=0; i<s.length(); i++)
            if (Character.isLowerCase(s.charAt(i)))
            ans.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            else   ans.setCharAt(i, Character.toLowerCase(s.charAt(i)));

        return ans.toString();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
