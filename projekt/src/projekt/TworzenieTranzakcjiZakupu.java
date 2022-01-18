package projekt;

public class TworzenieTranzakcjiZakupu extends TworzenieTranzakcji{

	@Override
	Tranzakcja DodajTranzakcje() {
		return new Zakup();
	}

}
