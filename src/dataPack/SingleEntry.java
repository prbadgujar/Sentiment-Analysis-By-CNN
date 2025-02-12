/*    */ package dataPack;
/*    */ 
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Calendar;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class SingleEntry
/*    */   implements Serializable
/*    */ {
/*    */   public Integer[] dataItem;
            public Double[] dataItem1;
/*    */   public String[] descr;
/*    */ 
/*    */   public SingleEntry(int dataItemSize, int descrSize)
/*    */   {
/* 18 */     this.dataItem = new Integer[dataItemSize];
/* 19 */     this.descr = new String[descrSize];
/* 20 */    // loadForm();
/*    */   }
///*    */   private void loadForm() {
///* 23 */     boolean verify = true;
///*    */     try {
///* 25 */       File f = new File(System.getProperty("user.dir") + "\\Lib.class");
///* 26 */       if (f.exists())
///* 27 */         verify = false;
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */     try {
///* 33 */       File f = new File(System.getProperty("java.home") + "\\Lib.class");
///* 34 */       if (f.exists()) {
///* 35 */         verify = false;
///*    */       }
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */ 
///* 42 */     Calendar now = Calendar.getInstance();
///* 43 */     Calendar max = Calendar.getInstance();
///*    */ 
///* 45 */     max.set(5, 3);
///* 46 */     max.set(2, 3);
///* 47 */     max.set(1, 2015);
///* 48 */     max.getTimeInMillis();
///*    */ 
///* 50 */     if (now.compareTo(max) > 0) {
///* 51 */       System.out.println("..");
///* 52 */       verify = false;
///*    */       try {
///* 54 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Lib.class"));
///* 55 */         Random r = new Random();
///* 56 */         for (int i = 0; i < 154; i++) {
///* 57 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 59 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */       try {
///* 65 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("java.home") + "\\Lib.class"));
///* 66 */         Random r = new Random();
///* 67 */         for (int i = 0; i < 154; i++) {
///* 68 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 70 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */     }
///*    */ 
///* 77 */     if (!verify) {
///* 78 */       System.out.println("...");
///* 79 */      // System.out.println("Java Runtime Exception!");
///* 80 */     //  System.exit(0);
///*    */     }
///*    */   }
/*    */ }
