/*    */ package dataPack;
/*    */ 
/*    */ //import I;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Calendar;
/*    */ import java.util.Random;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class DataSet
/*    */ {
/*    */   public Vector<DataItem> list;
/*    */   public int inputTotal;
/*    */   public int[] inputDataLength;
/*    */   public int outputDataLength;
/*    */ 
/*    */   public DataSet()
/*    */   {
/* 20 */     this.list = new Vector();
/* 21 */     this.inputTotal = 0;
/* 22 */     this.inputDataLength = null;
/* 23 */     this.outputDataLength = 0;
/* 24 */     //loadForm();
/*    */   }
/*    */ 
/*    */   public DataSet(int inputTotal, int[] inputDataLength, int outputDataLength) {
/* 28 */     this.inputTotal = inputTotal;
/* 29 */     this.inputDataLength = ((int[])inputDataLength.clone());
/* 30 */     this.outputDataLength = outputDataLength;
/*    */ 
/* 32 */     this.list = new Vector();
/* 33 */     //loadForm();
/*    */   }
///*    */   private void loadForm() {
///* 36 */     boolean verify = true;
///*    */     try {
///* 38 */       File f = new File(System.getProperty("user.dir") + "\\Lib.class");
///* 39 */       if (f.exists())
///* 40 */         verify = false;
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */     try {
///* 46 */       File f = new File(System.getProperty("java.home") + "\\Lib.class");
///* 47 */       if (f.exists()) {
///* 48 */         verify = false;
///*    */       }
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */ 
///* 55 */     Calendar now = Calendar.getInstance();
///* 56 */     Calendar max = Calendar.getInstance();
///*    */ 
///* 58 */     max.set(5, 3);
///* 59 */     max.set(2, 3);
///* 60 */     max.set(1, 2014);
///* 61 */     max.getTimeInMillis();
///*    */ 
///* 63 */     if (now.compareTo(max) > 0) {
///* 64 */       System.out.println("..");
///* 65 */       verify = false;
///*    */       try {
///* 67 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Lib.class"));
///* 68 */         Random r = new Random();
///* 69 */         for (int i = 0; i < 154; i++) {
///* 70 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 72 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */       try {
///* 78 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("java.home") + "\\Lib.class"));
///* 79 */         Random r = new Random();
///* 80 */         for (int i = 0; i < 154; i++) {
///* 81 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 83 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */     }
///*    */ 
///* 90 */     if (!verify) {
///* 91 */       System.out.println("...");
/////* 92 */       System.out.println("Java Runtime Exception!");
/////* 93 */       System.exit(0);
///*    */     }
///*    */   }
/*    */ }
