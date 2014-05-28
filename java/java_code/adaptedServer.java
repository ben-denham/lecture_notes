class Button {

    private ButtonServer buttonServer;

    public Button(ButtonServer buttonServer) {
	this.buttonServer = buttonServer;
    }

    private void pressed() {
	buttonServer.buttonPressed();
    }

}

abstract class ButtonServer {
    public abstract void buttonPressed();
}

class SendButtonAdapter extends ButtonServer {

    private Dialer dialer;

    public SendButtonAdapter(Dialer dialer) {
	this.dialer = dialer;
    }

    public void buttonPressed() {
	dialer.send();
    }
}

class DigitButtonAdapter extends ButtonServer {

    private Dialer dialer;

    public DigitButtonAdapter(Dialer dialer) {
	this.dialer = dialer;
    }

    public void buttonPressed() {
	dialer.digit();
    }
}

class Dialer {

    public Dialer() {
	new Button(new DigitButtonAdapter(this));
	new Button(new SendButtonAdapter(this));
    }

    public void send() { }

    public void digit() { }

}
