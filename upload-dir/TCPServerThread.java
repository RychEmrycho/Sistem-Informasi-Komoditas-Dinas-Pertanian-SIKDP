import java.net.*;
import java.io.*;

public class TCPServerThread extends Thread {
    private Socket connectionSocket = null;

    public TCPServerThread(Socket socket) {
        super("TCPServerThread");
        this.connectionSocket = socket;
    }

    public void run() {
        try {
            String clientSentence;
            String capitalizedSentence;
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            // baca greetings
            String namaClient = inFromClient.readLine();
            System.out.println("Client " + namaClient + "Terhubung");
            outToClient.writeBytes("Horas " + namaClient + '\n');
            while ((clientSentence = inFromClient.readLine()) != null) {
                System.out.println("dari " + namaClient + " : " + clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence);
                if (capitalizedSentence.equals("QUIT\n")) {
                    System.out.println(namaClient + " telah berhenti");
                    break;
                }
            }
            connectionSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}