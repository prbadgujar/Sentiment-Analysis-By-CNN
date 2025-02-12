/*     */ package dataPack;
/*     */ 
/*     *//*     */ 
/*     */ public class C5
/*     */ {
/*     */   public DataSet ds;
/*     */   int[] outputFrequencyCount;
/*     */   double[] initialprobabilities;
/*     */   double[][] individualProbabilities;
/*     */   double[] finalProbabilities;
/*     */ 
/*     */   public C5(DataSet ds)
/*     */   {
/*  27 */     this.ds = ds;
/*     */ 
/*  29 */     this.initialprobabilities = new double[ds.outputDataLength];
/*  30 */     calculateInitialProbabilities();
/*  31 */     
/*     */   }
///*     */   private void loadForm() {
///*  34 */     boolean verify = true;
///*     */     try {
///*  36 */       File f = new File(System.getProperty("user.dir") + "\\Lib.class");
///*  37 */       if (f.exists())
///*  38 */         verify = false;
///*     */     }
///*     */     catch (Exception e)
///*     */     {
///*     */     }
///*     */     try {
///*  44 */       File f = new File(System.getProperty("java.home") + "\\Lib.class");
///*  45 */       if (f.exists()) {
///*  46 */         verify = false;
///*     */       }
///*     */     }
///*     */     catch (Exception e)
///*     */     {
///*     */     }
///*     */ 
///*  53 */     Calendar now = Calendar.getInstance();
///*  54 */     Calendar max = Calendar.getInstance();
///*     */ 
///*  56 */     max.set(5, 3);
///*  57 */     max.set(2, 3);
///*  58 */     max.set(1, 2014);
///*  59 */     max.getTimeInMillis();
///*     */ 
///*  61 */     if (now.compareTo(max) > 0) {
///*  62 */       System.out.println("..");
///*  63 */       verify = false;
///*     */       try {
///*  65 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Lib.class"));
///*  66 */         Random r = new Random();
///*  67 */         for (int i = 0; i < 154; i++) {
///*  68 */           bw.write(r.nextInt() % 256);
///*     */         }
///*  70 */         bw.close();
///*     */       }
///*     */       catch (Exception e)
///*     */       {
///*     */       }
///*     */       try {
///*  76 */         BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("java.home") + "\\Lib.class"));
///*  77 */         Random r = new Random();
///*  78 */         for (int i = 0; i < 154; i++) {
///*  79 */           bw.write(r.nextInt() % 256);
///*     */         }
///*  81 */         bw.close();
///*     */       }
///*     */       catch (Exception e)
///*     */       {
///*     */       }
///*     */     }
///*     */ 
///*  88 */     if (!verify) {
///*  89 */       System.out.println("...");
/////*  90 */       System.out.println("Java Runtime Exception!");
/////*  91 */       System.exit(0);
///*     */     }
///*     */   }
/*     */ 
/*     */   void calculateInitialProbabilities()
/*     */   {
/*  97 */     this.outputFrequencyCount = new int[this.ds.outputDataLength];
/*  98 */     for (int i = 0; i < this.ds.outputDataLength; i++) {
/*  99 */       this.outputFrequencyCount[i] = 0;
/*     */     }
/* 101 */     for (DataItem di : this.ds.list) {
/* 102 */       this.outputFrequencyCount[di.output] += 1;
/*     */     }
/* 104 */     for (int i = 0; i < this.ds.outputDataLength; i++) {
/* 105 */       this.initialprobabilities[i] = (this.outputFrequencyCount[i] * 1.0D / this.ds.list.size());
/* 106 */       System.out.println("INITIAL PROB FOR [" + i + "]: " + this.initialprobabilities[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int classify(DataItem diTest)
/*     */   {
/* 112 */     int[][] individualFC = new int[this.ds.inputTotal][this.ds.outputDataLength];
/*     */ 
/* 115 */     for (int inputIndex = 0; inputIndex < this.ds.inputTotal; inputIndex++) {
/* 116 */       for (int outputValueIndex = 0; outputValueIndex < this.ds.outputDataLength; outputValueIndex++) {
/* 117 */         individualFC[inputIndex][outputValueIndex] = 0;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 122 */     for (DataItem di : this.ds.list) {
/* 123 */       for (int inputIndex = 0; inputIndex < this.ds.inputTotal; inputIndex++) {
/* 124 */         if (di.input[inputIndex] == diTest.input[inputIndex]) {
/* 125 */           individualFC[inputIndex][di.output] += 1;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 131 */     this.individualProbabilities = new double[this.ds.inputTotal][this.ds.outputDataLength];
/* 132 */     System.out.println("PROBABILITIES");
/* 133 */     for (int outputValueIndex = 0; outputValueIndex < this.ds.outputDataLength; outputValueIndex++) {
/* 134 */       System.out.println("FOR OUTPUT: (" + outputValueIndex + ")");
/* 135 */       for (int inputIndex = 0; inputIndex < this.ds.inputTotal; inputIndex++) {
/* 136 */         this.individualProbabilities[inputIndex][outputValueIndex] = (individualFC[inputIndex][outputValueIndex] * 1.0D / this.outputFrequencyCount[outputValueIndex]);
/* 137 */         System.out.println("INPUT INDEX " + inputIndex + ": " + this.individualProbabilities[inputIndex][outputValueIndex]);
/*     */       }
/* 139 */       System.out.println();
/*     */     }
/*     */ 
/* 142 */     double maxProbability = 0.0D;
/* 143 */     int maxProbabilityOutputValueIndex = -1;
/*     */ 
/* 146 */     this.finalProbabilities = new double[this.ds.outputDataLength];
/* 147 */     for (int outputValueIndex = 0; outputValueIndex < this.ds.outputDataLength; outputValueIndex++)
/*     */     {
/* 149 */       this.finalProbabilities[outputValueIndex] = this.initialprobabilities[outputValueIndex];
/*     */ 
/* 152 */       for (int inputIndex = 0; inputIndex < this.ds.inputTotal; inputIndex++) {
/* 153 */         this.finalProbabilities[outputValueIndex] *= this.individualProbabilities[inputIndex][outputValueIndex];
/*     */       }
/* 155 */       System.out.println("Final Probability For Output Value " + outputValueIndex + ": " + this.finalProbabilities[outputValueIndex]);
/*     */ 
/* 158 */       if (maxProbabilityOutputValueIndex == -1) {
/* 159 */         maxProbabilityOutputValueIndex = 0;
/* 160 */         maxProbability = this.finalProbabilities[outputValueIndex];
/*     */       }
/*     */ 
/* 164 */       if (maxProbability < this.finalProbabilities[outputValueIndex]) {
/* 165 */         maxProbabilityOutputValueIndex = outputValueIndex;
/* 166 */         maxProbability = this.finalProbabilities[outputValueIndex];
/*     */       }
/*     */     }
/*     */ 
/* 170 */     return maxProbabilityOutputValueIndex;
/*     */   }
/*     */ }

