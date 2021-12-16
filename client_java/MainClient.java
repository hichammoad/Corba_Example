package client_java;

import java.util.Properties;
import java.util.Scanner;

import ex1.App;
import ex1.AppHelper;
import ex1.Question;
import ex1.Response;

public class MainClient {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("org.omg.CORBA.ORBInitialHost", "localhost");
		props.put("org.omg.CORBA.ORBInitialPort", "1050");

		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);

		String url = "corbaname::localhost:1050#myapp";
		org.omg.CORBA.Object obj = orb.string_to_object(url);

		App app = AppHelper.narrow(obj);
		Question[] question = app.getquestions();
		Scanner sc = new Scanner(System.in);

		for (Question q : question) {
			System.out.println("-------------------");
			System.out.println(q.id + " " + q.ennonce);
			for (Response r : q.responsesList) {
				System.out.println(r.id + " " + r.ennonce);
			}
			System.out.println("your answer? (answer id [21, 22, ...])");
			int idr = sc.nextInt();
			System.out.println(app.verifierrep(idr, q.id));
		}

		// System.out.println(app.verifierrep(1, 1));

	}
}
