# Java-Password-Generator
This is a Java Graphical User Interface (GUI) application designed to generate random passwords and display password strength information.


## Background
Having a strong password is crucial these days. Strong password prevents unauthorized individuals from accessing our sensitive information. Inspired by KeepPassXC a password manager application, I decided to develop a password generator using Java to further develop my Java skill. This app uses Java Swing Framework to display Graphical User Interface. The password strength, measured by password entropy, is also displayed.

### Password Entropy Formula: 

$Entropy = L \log _{2} R  $

Where:

$R$ - Size of the pool of unique characters

$L$ - Password Length


### Password Quality Based On Entropy Value 

| Entropy Value | Category      | 
| ------------- |:-------------:| 
| 0 - 44      | Poor |
| 45 - 74      | Weak      | 
| 75 -99 | Good     |
| >= 100  | Excellent      |



## Functionalities
1. Generate Password: Users can generate passwords with different lengths and combinations of characters.

2. Check Password Strength: After generating the password, the password quality and entropy are displayed.

3. Copy to Clipboard: Additionally, users can copy the generated password to the clipboard by clicking the copy button.



## Screenshot
![img.png](img.png)
