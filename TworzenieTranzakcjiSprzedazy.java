package projekt;

public class TworzenieTranzakcjiSprzedazy extends TworzenieTranzakcji{

	@Override
	Tranzakcja DodajTranzakcje() {
		return new Sprzedaz();
	}

}
