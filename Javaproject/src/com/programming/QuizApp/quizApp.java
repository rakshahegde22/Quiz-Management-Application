package com.programming.QuizApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class quizApp {
    public static void main(String[] args) {
        Quiz q=new Quiz();
        q.logic();

    }
}

class Quiz{
    Scanner sc=new Scanner(System.in);
    int correctAnsCount=0;
    int wrongAnsCount=0;
    public void logic(){
        questions q1 = new questions("Which statement is true about Java?", "A. Java is a sequence-dependent programming language ", "B. Java is a code dependent programming language ", "C. Java is a platform-dependent programming language ", "D. Java is a platform-independent programming language ");
        questions q2 = new questions("What is the extension of java code files?", "A. .txt", "B. .pdf", "C. .sql", "D. .java");
        questions q3 = new questions("Who invented Java Programming? ", "A. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup");
        questions q4 = new questions("Which one of the following is not a Java feature?", "A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible");
        questions q5 = new questions("Which of these cannot be used for a variable name in Java?", "A. identifier & keyword", "B. identifier", "C. Keyword", "D. none of the mentioned");

     // Creating an empty HashMap
        Map<questions,Character> hmap=new HashMap<>();
     // Inserting entries in the Map
        // using put() method
        hmap.put(q1,'D');
        hmap.put(q2,'D');
        hmap.put(q3,'B');
        hmap.put(q4,'B');
        hmap.put(q5,'C');

        // Iterating over Map using for each loop
        for(Map.Entry<questions,Character> map:hmap.entrySet()){
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.println("Enter Your Answer: ");
            Character ans=sc.next().charAt(0);

            int cans=Character.compare(ans,map.getValue());
            if(cans==0){
                System.out.println("Correct");
                System.out.println();
                correctAnsCount++;
            }
            else{
                System.out.println("Wrong");
                System.out.println();
                wrongAnsCount++;
            }

        }

        System.out.println();
        System.out.println("--------Result---------");
        System.out.println("Total Questions: "+hmap.size());
        System.out.println("Correct Answered Questions : "+correctAnsCount);
        System.out.println("Wrong Answered Questions : "+wrongAnsCount);
        float percentage=(100*correctAnsCount)/hmap.size();
        System.out.println("Percentage : "+percentage);
        if(percentage>95){
            System.out.println("Performance : Very Good");
        }
        else if(percentage<35){
            System.out.println("Performance : Very Low");
        }
        else{
            System.out.println("Performance : Medium");
        }
    }
}
