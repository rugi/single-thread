package mx.javaaldia.examples.thread;

public class Main{


  public static void main(String[]  argv) throws InterruptedException {
    System.out.println("----Begin----");
    Thread.sleep(10000);		
    Main m = new Main();
    Main.MyThread t1 = m.new MyThread("Primero", 10000);
    Main.MyThread t2 = m.new MyThread("Segundo", 5000); 
    Main.MyThread t3 = m.new MyThread("Tercero", 2500);
    t1.start();
    t2.start();
    t3.start();
    Thread.sleep(20000);
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
