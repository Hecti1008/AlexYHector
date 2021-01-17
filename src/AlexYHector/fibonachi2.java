/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlexYHector;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 *
 * @author megah
 */

public class fibonachi2 extends RecursiveTask<Long> {
    long numero;
    public fibonachi2(long numero){
        this.numero=numero;
    }    
    @Override
    protected Long compute() {
        // ATENCIO **1** double calcul = java.lang.Math.cos(54879854);
        if(numero <= 1) return numero;
        fibonachi2 fib1 = new fibonachi2(numero-1);
        //fib1.fork();
	fibonachi2 fib2 = new fibonachi2(numero-2);
        fib2.fork();
	 return fib1.compute()+ fib2.join();
	 }
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Calculat:  " + pool.invoke(new fibonachi2(21)));    
    }
}


