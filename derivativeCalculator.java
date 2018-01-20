/*
Written by William Fan

 */

import java.util.*;
import java.io.*;

public class derivativeCalculator {
    public static void main (String [] args) {
        
        System.out.println("Welcome to this derivative calculator!");
        System.out.println("This calculator is capable of differentiating any polynomial");
        boolean run = true;
        
        Scanner input = new Scanner (System.in);
        do {
        
        System.out.println("Enter an equation: ");
        String equation = input.nextLine();
        equation = equation + "+";
        equation = equation.replaceAll(" ","");
        equation = equation.replaceAll("-", "+-");
        String equation1 = equation;
        String result = "";
        //+-x^2+
        while (equation1.indexOf("+") > -1) {
        int index = equation1.indexOf("+");
        if (equation1.substring(0,2).equals("+-")) {
        equation1= equation.substring(1);
        }
        //System.out.println(equation1);
        index = equation1.indexOf("+");
        String term = equation1.substring(0, index);
        //System.out.println(term);
if (term.charAt(0) == 'x') {
        term = "1" + term;
        }
        if (term.length() > 2) {
        if (term.substring(0,2).equals("-x")) {
        term = term.substring(0,1) + "1" + term.substring(1);
        }
    }
        if (term.indexOf(".") < 0) {
        String coef = coef(term);
        
        int coefI = Integer.parseInt(coef);
   
        String exp = exp(term);
        
        int expI = Integer.parseInt(exp);
        
         boolean bool = false;
        
        int coefD = coefD(coefI, expI);
        if (coefD >= 0) {
        bool = true;
        }
        int expD = expD(expI);
        
        String coefDS = Integer.toString(coefD);
        if (bool == true) {
        coefDS = "+" + coefDS;
        }
        String expDS = Integer.toString(expD);
        
        result += coefDS + "x^" + expDS + " ";
        
    
    }
    else {
    String coef = coef(term);
    double coefDub = Double.valueOf(coef);
    String exp = exp(term);
    double expDub = Double.valueOf(exp);
    boolean bool = false;
    double coefD = coefD(coefDub, expDub);


    if (coefD >= 0) {
        bool = true;
    }
    double expD = expD(expDub);
    expD = (int)(expD * 10000 + 0.5)/10000.0;
    coefD = (int)(coefD * 10000 + 0.5)/10000.0;
    String coefDS = String.valueOf(coefD);
    if (bool == true) {
    coefDS = "+" + coefDS;
    }
    String expDS = String.valueOf(expD);
    result += coefDS + "x^" + expDS + " ";
    }
    equation1 = equation1.substring(index+1);
    }
    int length = result.length();
    result = result.substring(0, length - 1);
    if (result.substring(0,1).equals("+")) {
    result = result.substring(1);
    }
    
    if (result.indexOf("^0") > -1) {
    int index = result.indexOf("^0");
    result = result.substring(0, index-1) + result.substring(index+2);
    }
    if (result.indexOf("^1") > -1 && result.charAt(result.indexOf("^1")+2) != '.') {
        int index = result.indexOf("^1");
    result = result.substring(0, index) + result.substring(index + 2);
    }
    if (result.indexOf("0x^-1") > -1) {
    int index = result.indexOf("0x^-1");
    result = result.substring(0,index) + result.substring(index+5);
    }
    if (result.equals("")) {
    result = "0";
    }
    result = result.replaceAll(" ","");
    length = result.length();
    if (result.charAt(length-1) == '+') {
    result = result.substring(0, length-1);
    }
    if (result.charAt(0) == '+') {
    result = result.substring(1);
    }
    if (result.indexOf(".0") > -1) {
    int index = result.indexOf(".0");
    result = result.substring (0, index) + result.substring(index + 2);
    }
        System.out.println("Your differentiated polynomial is: " + result);
        
        boolean run2 = true;
        do {
        System.out.println("Would you like to run the calculator again? (y/n)");
        String yn = input.nextLine();
        
        if (yn.equals("y")) {
        run = true;
        run2 = false;
        }
        else if (yn.equals("n")) {
        run = false;
        run2 = false;
        }
        else {
        System.out.println("Please enter a valid input (Either \"y\" or \"n\")");
        run2 = true;
        }
    }
    while (run2 == true);
        
    }
    while (run == true);
    System.out.println("Thank you for using this derivative calculator");
}

public static int coefD (int a, int b) {
return (a * b);
}
public static double coefD (double a, double b) {
return (a * b);
}
public static int expD (int b) {
return (b-1);
}
public static double expD (double b) {
return ((double)b-1);
}
public static String coef (String str) {
    String coefD = "";

if (str.indexOf("x") > -1) {
    int index = str.indexOf("x");
coefD = str.substring(0, index);
}
else {
coefD = "0";
}
return coefD;
}
public static String exp (String str) {
    //str = str + " ";
    String expD = "";
//int index = str.indexOf("^");
int length = str.length();
if (str.indexOf("^") > -1) {
    str = str + " ";
    int index = str.indexOf("^");
expD = str.substring(index+1, length);
}
else if (str.indexOf("x") > -1 && str.indexOf("^") < 0){
    
str = str + "^1 ";
length = str.length(); 
int index = str.indexOf("^");
expD = str.substring(index+1, length-1);
}
else {
expD = "0";
}


return expD;
}
}