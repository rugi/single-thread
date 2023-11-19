package mx.javaaldia.examples.thread;

public class Main{


  public static void main(String[]  argv) throws InterruptedException {
    System.out.println("----Begin----");
    System.out.println("Tienes 10 segundos para abrir VMWare y abrir este proceso.");
    System.out.println("Iniciarán 3 hilos, el 1o dura 10 segundos, el 2o 5 segundos y el 3o 2.5 segundos");
    System.out.println("Terminados los 3 hilos, el proceso principal continuará otros 20 segundos para que puedas apreciar como se libera la memoria y la cantidad de hilos");
    Thread.sleep(10000);		
    Main m = new Main();
    Main.MyThread t1 = m.new MyThread("Primero", 10000);
    Main.MyThread t2 = m.new MyThread("Segundo", 5000); 
    Main.MyThread t3 = m.new MyThread("Tercero", 2500);
    t1.start();
    t2.start();
    t3.start();
    Thread.sleep(30000);
    System.out.println("----End------"); 
  }

  class MyThread extends Thread{ 

   private String name;
   private int duration;
   public MyThread(String name, int duration){
	super();
	this.name     =  name;
	this.duration =  duration;
   }
 
    public void run(){
      try{ 
          System.out.println("Inicia thread:"+this.name);  
          Thread.currentThread().sleep(this.duration); 
          System.out.println("Termina thread:"+this.name);
      }catch(InterruptedException excp){
        //
      }
    }  

  }//class 

}
