package com.assignment.logging;

import java.util.Scanner;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//@SpringBootApplication
public class LoggingApplication {

		private static org.apache.log4j.Logger logger = Logger.getLogger(LoggingApplication.class);

		public static void main(String[] args) {
			BasicConfigurator.configure();
			System.out.println("Logger has been Initialize");
			System.out.println("Enter the Logger Level");
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.println("\n1. ALL");
				System.out.println("2. DEBUG");
				System.out.println("3. INFO");
				System.out.println("4. WARN");
				System.out.println("5. ERROR");
				System.out.println("6. FATAL");
				System.out.println("7. OFF");
				System.out.println("8. Terminate the Program");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				switch (choice) {
					case 1:
						logger.setLevel(Level.ALL);
						break;
					case 2:
						logger.setLevel(Level.DEBUG);
						break;
					case 3:
						logger.setLevel(Level.INFO);
						break;
					case 4:
						logger.setLevel(Level.WARN);
						break;
					case 5:
						logger.setLevel(Level.ERROR);
						break;
					case 6:
						logger.setLevel(Level.FATAL);
						break;
					case 7:
						logger.setLevel(Level.OFF);
						break;
					case 8:
						System.exit(0);
				}
					logger.trace("Trace Message!");
					logger.debug("Debug Message!");
					logger.info("Info Message!");
					logger.warn("Warn Message!");
					logger.error("Error Message!");
					logger.fatal("Fatal Message!");
			}
//			logger.trace("Trace Message!");
//			logger.debug("Debug Message!");
//			logger.info("Info Message!");
//			logger.warn("Warn Message!");
//			logger.error("Error Message!");
//			logger.fatal("Fatal Message!");
	}

}
