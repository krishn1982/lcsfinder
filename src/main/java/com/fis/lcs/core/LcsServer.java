package com.fis.lcs.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import com.fis.lcs.servlet.LCSServlet;

public class LcsServer {
	
	 public static void main( String[] args ) throws Exception
	    {
	        
	        Server server = new Server(8090);

	        ServletHandler handler = new ServletHandler();
	        server.setHandler(handler);	       
	        handler.addServletWithMapping(LCSServlet.class, "/lcs");	        
	        server.start();
	        server.join();
	    }

}
