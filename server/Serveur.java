package server;

import java.util.Properties;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import app.Implementation;

public class Serveur {

	public static void main(String[] args) throws Exception{
		Implementation implementation = new Implementation();
		Properties props = new Properties();
		props.put("org.omg.CORBA.ORBInitialHost", "localhost");
		props.put("org.omg.CORBA.ORBInitialPort", "1050");
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
		POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();
		org.omg.CORBA.Object ncobj = orb.resolve_initial_references("NameService");
		NamingContext nc = NamingContextHelper.narrow(ncobj);
		org.omg.CORBA.Object obj = rootPOA.servant_to_reference(implementation);
		NameComponent[] names = new NameComponent[] { new NameComponent("myapp", "") };
		nc.rebind(names, obj);
		System.out.println("Server is ready...");
		orb.run();
		
		
		
		
	}
	
}
