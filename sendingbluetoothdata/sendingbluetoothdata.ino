#include <SoftwareSerial.h>

SoftwareSerial myPort(2,3);

int pot = 2; // potentiometer in analog pin 2
int val = 0; // variable to store the value 


// the setup routine runs once when you press reset:
void setup() {                
  myPort.begin(57600);  // create my own serial called myPort
  Serial.begin(9600); 

}


// the loop routine runs over and over again forever:
void loop() {

  val = analogRead(pot); // read the value of the sensor and set it to val
  Serial.println(val); 
  myPort.write(val);
  delay(1000);               // wait for 5 seconds

}



