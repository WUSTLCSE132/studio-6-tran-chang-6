package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	private boolean writeByte;
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	public boolean writeByte(byte b){
		setDebug(true);
		if(debug) {
			try{
				writeByte = port.writeByte(b);
			} catch (SerialPortException e){
				e.printStackTrace();
			}
			System.out.println(b);

		}	
		return writeByte;
	}
	// TODO: Add available() method
	public boolean available(){
		int sarah = 0;
		try {
			sarah = port.getInputBufferBytesCount();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(sarah != -1) {
				return true;
			}
			else {
				return false;
			}
		
	}
	
	// TODO: Add readByte() method	
	public byte readByte() {
		byte[] sarah = new byte[1];
		try {
			sarah = port.readBytes(1);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b = sarah[0];
		return b;
	}
	// TODO: Add a main() method
	
	public void main(String[] args) {
		
	}
}
