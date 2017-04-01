package com.cmy.controller.test;


    public class PrintABC implements Runnable{
        private static  Integer lock=0;
        private static boolean tagA=true;
        private static boolean tagB=false;
        private static boolean tagC=false;
        public synchronized  void run(){
            for(int i=0;i<10;i++){
                synchronized(lock){
                    if(Thread.currentThread().getName().equals("A")){
                        while(tagA==false){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                            System.out.println(Thread.currentThread().getName()+":"+i);
                            tagA=false;
                            tagB=true;
                            tagC=false;
                            lock.notifyAll();
                    }else if(Thread.currentThread().getName().equals("B")){
                        while(tagB==false){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                            System.out.println(Thread.currentThread().getName()+":"+i);
                            tagA=false;
                            tagB=false;
                            tagC=true;
                            lock.notifyAll();
                    }else{
                        while(tagC==false){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                            System.out.println(Thread.currentThread().getName()+":"+i);
                            tagA=true;
                            tagB=false;
                            tagC=false;
                            lock.notifyAll();
                    }
                }
            }

        }
        public static void main(String[] args) throws Exception{
            Thread a = new Thread(new PrintABC(),"A");
            Thread b = new Thread(new PrintABC(),"B");
            Thread c = new Thread(new PrintABC(),"C");
            //PrintABC.tagA=true;
            a.start();
            //Thread.sleep(10);
            b.start();
            c.start();
        }
    }

