package ro.pub.cs.systems.pdsd.practicaltest02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import android.util.Log;
import android.widget.TextView;

public class ClientThread extends Thread {

	
	String address;
	int port;
	String word;
	String tv;
	TextView textView;
	
	private Socket socket;

    public ClientThread(
            String address,
            int port,
            String city,
            TextView textViewInfo) {
        this.address = address;
        this.port = port;
        this.word = word;
      
        this.textView = textView;
    }
    
	@Override
	public void run() {
	  try {
	    socket = new Socket(address, port);
	    if (socket == null) {
	      Log.e(Constants.TAG, "[CLIENT THREAD] Could not create socket!");
	      return;
	    }
	    BufferedReader bufferedReader = Utilities.getReader(socket);
	    PrintWriter    printWriter    = Utilities.getWriter(socket);
	    if (bufferedReader != null && printWriter != null) {
	      printWriter.println(word);
	      printWriter.flush();
	   
	      while ((tv = bufferedReader.readLine()) != null) {
	        final String finalizedWeatherInformation = tv;
	        textView.post(new Runnable() {
	          @Override
	          public void run() {
	            textView.append(finalizedWeatherInformation + "\n");
	          }
	        });
	      }
	    } else {
	      Log.e(Constants.TAG, "[CLIENT THREAD] BufferedReader / PrintWriter are null!");
	    }
	    socket.close();
	  } catch (IOException ioException) {
	    Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
	    if (Constants.DEBUG) {
	      ioException.printStackTrace();
	    }
	  }
	}
}
