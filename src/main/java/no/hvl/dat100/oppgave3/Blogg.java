package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
		
	}
	
	public Innlegg[] getSamling() {
		return innleggstabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for(int i = 0; i<nesteledig;i++) {
			if(innleggstabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(int i = 0; i<nesteledig;i++) {
			if(innleggstabell[i].erLik(innlegg)) {
				return true;
			}
			}
		return false;
	}

	public boolean ledigPlass() {
		for(int i = 0; i<innleggstabell.length; i++){
			if(innleggstabell[i]==null) {
				return true;
			}
			
		}
		return false;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass()) {
			innleggstabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
			
			}
		
		return false;
	}
	
	public String toString() {
		return nesteledig + "\n" + innleggstabell.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvida = new Innlegg[2*innleggstabell.length];
		for(int i = 0; i<utvida.length; i++) {
			utvida[i] = innleggstabell[i];
		}
		innleggstabell = utvida;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(leggTil(innlegg) == true) {
			return true;
		}
		if(nesteledig>=innleggstabell.length) {
			utvid();
			if(leggTil(innlegg));
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		for(int i = 0; i<nesteledig; i++) {
			if(innleggstabell[i].getId()==innlegg.getId()) {
				innleggstabell[i] = null;
			}
			for(int j = i; j<nesteledig -1; j++) {
				innleggstabell[j] = innleggstabell[j+1];
			}
			innleggstabell[nesteledig -1] = null;
			nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		
		int ordAntall = 0;
		for(int i = 0; i<nesteledig; i++) {
			if(innleggstabell[i].getTekst().contains(keyword)) {
				ordAntall++;
			}
		}
			int [] idTabell = new int[ordAntall];
				int index = 0;
				
			for(int i = 0; i<nesteledig; i++) {
				if(innleggstabell[i].getTekst().contains(keyword)) {
					index++;
					idTabell[index]=innleggstabell[i].getId();
				}
		}
			return idTabell;
	}
}
