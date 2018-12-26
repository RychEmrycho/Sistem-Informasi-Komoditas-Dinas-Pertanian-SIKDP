import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        if (argv.length != 1) {
            System.out.println("Jalankan server dengan memberikan argumen port");
            System.err.println("Contoh: java TCPServer 8999");
            System.exit(1);
        }
        // tambahkan code disini
        try (ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(argv[0]))) {
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                // baca greetings
                String namaClient = inFromClient.readLine();
                System.out.println("Client " + namaClient + " Terhubung");
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
            }
        } catch (IOException e) {
            System.err.println("Server tidak bisa menggunakan port " + argv[0]);
            System.err.println("Port tersebut kemungkinan sudah digunakan !!");
            System.exit(-1);
        }
    }
}