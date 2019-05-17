public class Player
{
   private String name;
   private String[] records;
   private int nOfR;
   
   public Player (String n)
   {
       name = n;
       records = new String[3];
       nOfR = 0;
   }
   
   public void addRecord(String r)
   {
      if(nOfR < records.length)
         records[nOfR++] = r;
       
        else 
        {
            for(int i = 0; i<2; i++)
            records[i] = records[i+1];
            
            records[2] = r;
        }
        
    }
    
    public String getName(){return name;}
    public String[] getRecord(){ return records; }
    public int getNumberOfRecord(){ return nOfR;}
    
}
            
            