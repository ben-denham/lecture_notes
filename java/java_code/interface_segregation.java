class Dialer {

    private DialerDisplay display;

    public Dialer(DialerDisplay display) {
	this.display = display;
	display.displayDigit(5);
    } 

}

class CellularRadio {

    private CRDisplay display;

    public CellularRadio(CRDisplay display) {
	this.display = display;
	display.inUse();
    } 

}

interface DialerDisplay {
    void displayDigit(int code);
}

interface CRDisplay {
    void inUse();
}

class Display implements DialerDisplay, CRDisplay {

    public void displayDigit(int code) { }
    public void inUse() { }

}
