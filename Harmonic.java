import java.util.LinkedList;
import java.util.ArrayList;

public class Harmonic{
  private int binSize=100;
  private LinkedList<Integer> hList;
  private int[][] bins1,bins2,bins3,bins4;
  private int totalBins=0;
  
  public Harmonic(LinkedList<Integer> originalList){
    hList=originalList;
    bins1=new int[hList.size()][hList.size()];
    bins2=new int[hList.size()][hList.size()];
    bins3=new int[hList.size()][hList.size()];
    bins4=new int[hList.size()][hList.size()];
    initArray(bins1);
    initArray(bins2);
    initArray(bins3);
    initArray(bins4);
  }
  
  public void firstFitFunction(LinkedList<Integer> targetList){
    for(int i=0;i<targetList.size();i++){//start from the very first element from the linkedlist
      boolean added=false;
      
      if(targetList.get(i)>50){
        for(int j=0;(j<bins1.length) &&(added==false);j++){        
          if((sum(bins1[j])+targetList.get(i))<=binSize){
            for(int z=0;(z<bins1[0].length) &&(added==false);z++){
              if(bins1[j][z]==0){
                bins1[j][z]=targetList.get(i);
                added=true;
                //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
              }
            }
          }
        }
      }
      else if((targetList.get(i)<=50)&&(targetList.get(i)>33)){
        for(int j=0;(j<bins2.length) &&(added==false);j++){        
          if((sum(bins2[j])+targetList.get(i))<=binSize){
            for(int z=0;(z<bins2[0].length) &&(added==false);z++){
              if(bins2[j][z]==0){
                bins2[j][z]=targetList.get(i);
                added=true;
                //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
              }
            }
          }
        }
      }
      else if((targetList.get(i)<=33)&&(targetList.get(i)>25)){
        for(int j=0;(j<bins3.length) &&(added==false);j++){        
          if((sum(bins3[j])+targetList.get(i))<=binSize){
            for(int z=0;(z<bins3[0].length) &&(added==false);z++){
              if(bins3[j][z]==0){
                bins3[j][z]=targetList.get(i);
                added=true;
                //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
              }
            }
          }
        }
      }
      else if(targetList.get(i)<=25){
        for(int j=0;(j<bins4.length) &&(added==false);j++){        
          if((sum(bins4[j])+targetList.get(i))<=binSize){
            for(int z=0;(z<bins4[0].length) &&(added==false);z++){
              if(bins4[j][z]==0){
                bins4[j][z]=targetList.get(i);
                added=true;
                //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
              }
            }
          }
        }
      }
    }
  }
  
  public int getTotalBins(){
    firstFitFunction(hList);
    int i;
    for(i=0;i<bins1.length;i++){
      if(bins1[i][0]==0){
        break;
      }
    }
    totalBins=i;
    
    for(i=0;i<bins2.length;i++){
      if(bins2[i][0]==0){
        break;
      }
    }
    totalBins=i+totalBins;
    
    for(i=0;i<bins3.length;i++){
      if(bins3[i][0]==0){
        break;
      }
    }
    totalBins=totalBins+i;

    for(i=0;i<bins4.length;i++){
      if(bins4[i][0]==0){
        break;
      }
    }
    totalBins=totalBins+i;
    return totalBins;
  }
  
  public void initArray(int[][] targetArray){
    for(int i=0;i<targetArray.length;i++){
      for(int j=0;j<targetArray[0].length;j++){
        targetArray[i][j]=0;
      }
    }
  }
  
  public int sum(int []targetBin){
    int sumResult=0;
    
    for(int i=0;(i<targetBin.length) && (targetBin[i]!=0);i++){
      sumResult=sumResult+targetBin[i];
    }
    
    return sumResult;
  }
  
  public void printResult(){
    int totalNumBins=0;
    
    for(int i=0;i<bins1.length;i++){
      if((bins1[i][0]!=0)){
        System.out.print("bin "+i+":");
        totalNumBins++;
      }      
      for(int j=0;(j<bins1[0].length) && (bins1[i][j]!=0);j++){
        System.out.print((bins1[i][j]+" "));
      }
      if(bins1[i][0]!=0){
        System.out.println("");
      }
    }
     for(int i=0;i<bins2.length;i++){
      if((bins2[i][0]!=0)){
        System.out.print("bin "+(totalNumBins+i)+":");
        totalNumBins++;
      }      
      for(int j=0;(j<bins2[0].length) && (bins2[i][j]!=0);j++){
        System.out.print((bins2[i][j]+" "));
      }
      if(bins2[i][0]!=0){
        System.out.println("");
      }
    }
     for(int i=0;i<bins3.length;i++){
      if((bins3[i][0]!=0)){
        System.out.print("bin "+(totalNumBins+i)+":");
        totalNumBins++;
      }      
      for(int j=0;(j<bins3[0].length) && (bins3[i][j]!=0);j++){
        System.out.print((bins3[i][j]+" "));
      }
      if(bins3[i][0]!=0){
        System.out.println("");
      }
    }
     for(int i=0;i<bins4.length;i++){
      if((bins4[i][0]!=0)){
        System.out.print("bin "+(totalNumBins+i)+":");
        totalNumBins++;
      }      
      for(int j=0;(j<bins4[0].length) && (bins4[i][j]!=0);j++){
        System.out.print((bins4[i][j]+" "));
      }
      if(bins4[i][0]!=0){
        System.out.println("");
      }
    }
    
  }
}