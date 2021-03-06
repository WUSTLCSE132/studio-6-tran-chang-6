const int buttonPin = 2;
volatile int count = 0;
unsigned long lastTime = 100;
unsigned long buttonTime = 0;
void buttonPressed() {
  if (millis() - buttonTime > lastTime) {
  Serial.println("Interrupt");
  Serial.println(count);
  count++;
  }
  buttonTime = millis();
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, CHANGE);
  Serial.begin(9600);
}

void loop() {
    
}
