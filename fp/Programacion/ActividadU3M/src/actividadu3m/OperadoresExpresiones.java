/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadu3m;

/**
 *
 * @author maniana
 */
public class OperadoresExpresiones {
    public static void main(String[] args){
        
        int x1=10, x2=5, x3=0;
        char c1='F', c2='S';
        
        System.out.println((x1==x2));
        System.out.println((c1 != c2));
        System.out.println((x1>=10 & x1<=100));
        System.out.println((!(x2>=10 & x2<=100)));
        System.out.println(!(x3>=10 & x3<=100));
        System.out.println((x1>x2 & c1 == c2));
        System.out.println((x1>x2 | c1 != c2));
        System.out.println((x1<=7 & c2 == c1));
        System.out.println((c2!='a' & x2>0));
        System.out.println(('F'!=c1 || x1>20));
        System.out.println(('F'!=c1 || x1>20 || x2>2));
        System.out.println(('F'==c1 && x3<x1));
        System.out.println(('F'==c1 && x3<x1));
        System.out.println(('F'==c1 && x3<x1 && x2<=x3));
        System.out.println((x2>=x3 && x2<=x1 && c2=='S'));
        System.out.println((!(x3>=x2 && x3<=x1)));
        System.out.println((!(x2>=3 && x2<=x1) || c2 == c1));
        System.out.println(!(x3<x1));
        System.out.println(!(x3>x1 || c2!=c1));
        System.out.println(!(x1<100) && x2>10);
        System.out.println((c2<c1));
    }
    
}
