import java.util.*;

public class GuessWord
{
   public Scanner read = new Scanner (System.in);

  private final static String[] dictionary = { "purple", "animal", "house", "book", "cat", "computer", "school",
  "teacher", "party", "dress", "earth", "apple", "university", "flower", "cookies" };

   private int gameW;
   private String guessedW;
   private int hNo;
   private int gNo;
   private double score;
   private Player p;
   
   public GuessWord()
   {
      gameW = -1;
      hNo =0;
      gNo = 0;
      score = 0;
   }
    
   
   public void connectPlayer(Player p)
   {
      this.p = p;
   }
   
   public void generateWord()
   {
     gameW = (int)(Math.random()*14 - 0);
      int length = dictionary[gameW].length();
      String gw ="";
      for(int i = 0; i< length; i++)
      gw +="-";
      setGuessedW(gw);
   }
   
   public void generateWord(int index)
   {
      gameW = index;
      boolean ok = true;
      while (ok)
      {
         try{
                int length = dictionary[gameW].length();
                String gw ="";
                for(int i = 0; i< length; i++)
                gw +="-";
                setGuessedW(gw);
                ok = false;
             }
             
            catch(ArrayIndexOutOfBoundsException e)
            {
               System.out.println("Error: there is no word available in the given index. Try again");
               gameW = read.nextInt();
            }
      }
      
  }
  
    public void generateRecord()
    {
      String record = "Name: "+p.getName()+" Word: "+guessedW+" Score: "+score;
      p.addRecord(record);
    }
    
    public void updateScore()
    {
      score = 5 * (((7-hNo-(0.5*gNo))/7));
    }
    
    public boolean isLoser()
    {
      if(gNo>=4)
      return true;
      
      return false;
     }
     
     public boolean isWinner()
     {
         if(dictionary[gameW].equals(guessedW))
         return true;
         
         return false;
     }
     
     public void hint() throws NumberExceededException{ 
     
      if(hNo == 3)
      {throw new NumberExceededException("Error: sorry, you consuned all the available hints");
                           
             }
            
  
      else{
      char c = 'r';
         
         for(int i =0; i<dictionary[gameW].length()  ; i++)
            {  if(guessedW.charAt(i) == '-'){
               c = dictionary[gameW].charAt(i);
              guess(c);
                hNo++;
                break;}
                 
              }
           }

        
      
      }
      
      public boolean guess(char ch)
      {   char c;
         int counter = 0;
         for(int i =0; i<dictionary[gameW].length();i++)
         {
             c = dictionary[gameW].charAt(i);
            if(c == ch)
               counter++;
               
         }
         
         
         if (counter == 0){
         gNo++;
         return false;
         }
         
         else 
         {
            for(int i = 0; i <dictionary[gameW].length(); i++)
               if(dictionary[gameW].charAt(i) == ch)
               guessedW = guessedW.substring(0,i)+ch+guessedW.substring(i+1);                  
             
             return true;
          }
          
      }
      
      
      public void reset()
      {
         hNo =0;
         gNo=0;
         gameW =-1;
         guessedW ="";
         score = 0;
      }
      
      public void displayRecords()
      {
         String[] fullRecord = p.getRecord();
         for (int i =0; i<p.getNumberOfRecord(); i++)
         {
            System.out.println(fullRecord[i]);

         }
     
    }
      
      public void setGuessedW(String s ){ guessedW = s;}
      public String getGuessedW(){return guessedW;}
      public String getGameWord(){return dictionary[gameW];}
   
      
      
 }
         
         
         
         
            
       
                  
      
      
      
      
      
             
              
                
                
                
         
         
      
      
   
   