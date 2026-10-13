public class mca{

public static void main (String args[])
{
    String[] students = {"F_Ankita","M_Rahul","F_Neha","M_Rohit","F_Mihika","F_Roshni","M_Rajesh","M_Rohan","F_Ritika","F_Shital","M_Mohan","M_Mihir","F_Manisha","M_Hitesh","M_Harshit","M_Pankaj","F_Mihika","M_Neel","F_Anshika","F_Shikha","F_Rohini"};

    for (int i = 0; i<20; i+=2){
        if (students[i].charAt(0)==students[i+1].charAt(0)){
            continue;
        }
        int k=i+1;
        while(students[i].charAt(0)!=students[i+1].charAt(0)){
            if (students[i].charAt(0)==students[i+1].charAt(0)){
            break;
          }
          k++;
          if (k>20){
            break;
          }
          String temp = students[i+1];
          students[i+1]= students[k];
          students[k]= temp;
        }

    }
    for (String st:students){
        System.out.println(st);    }
    System.out.println("Student Left " + students[20]);
}
    
}