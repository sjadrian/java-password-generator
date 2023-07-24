# Java-Password-Generator
This is a Java Graphical User Interface (GUI) application to produce random passwords and display password strength information.


## Background
Having a strong password is crucial these days. Strong password prevents unauthorized individual to access our sensitive information. Inspired by KeepPassXC a password manager application, I decided to make a simple password generator using Java to further develop my Java skill. Password strength which is measured by password entropy is also shown.


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
1. Generate Password: User is able to generate password with different length and combinations of characters. 

2. Check Password's Strength: After generating the password, the password quality and entropy are shown.

3. Copy to Clipboard: In additon, user can copy the generated password to clipboard by clicking the copy button.

The password generator uses Java Swing Framework to display Graphical User Interface. 

## Screenshot
![img.png](img.png)
