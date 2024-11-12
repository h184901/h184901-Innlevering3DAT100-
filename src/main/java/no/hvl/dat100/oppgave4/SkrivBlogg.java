package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
			FileWriter writer = new FileWriter(mappe + filnavn);
			
			writer.write(samling.toString());
			writer.close();
			return true; 
			
		}
	catch(IOException e) {
		System.out.println("Feil ved skriving til fil: " + e.getMessage());
	}
		return false;
	}

}

