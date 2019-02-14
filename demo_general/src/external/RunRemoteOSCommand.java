package external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.StreamGobbler;

// be sure to download and add ganymed-ssh2-build210 as an ext jar

public class RunRemoteOSCommand {

	public static void main(String[] args) throws IOException {
		new RunRemoteOSCommand().SSHClient("192.168.1.101", "dir", "Admin", "Pa$$w0rd");

	}
	
	public void SSHClient(String serverIp,String command, String usernameString,String password) throws IOException{
        System.out.println("inside the ssh function");
        try
        {
            Connection conn = new Connection(serverIp);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(usernameString, password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");        
            ch.ethz.ssh2.Session sess = conn.openSession();
            sess.execCommand(command);  
            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            System.out.println("the output of the command is");
            while (true)
            {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            System.out.println("ExitCode: " + sess.getExitStatus());
            sess.close();
            conn.close();
        }
        catch (IOException e)
        {
            e.printStackTrace(System.err);

        }
    }

}
