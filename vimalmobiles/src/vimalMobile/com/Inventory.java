package vimalMobile.com;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class Inventory {
	  mobile mob[];
	  Statement stmt;
	  ResultSet rs;
	  String qry=null;
	  DButil db=new DButil();
	  Connection con;
	  List<mobile> list=new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      int i;
	  int e;
	private Object count;
      public void add(mobile m)
      {
    	     
    
    	     try
    	     {
    	      	   Statement stmt;
    	    	   Connection con=db.getDBConnection();
    	    	   stmt = con.createStatement();
    	    	   String qry=null;
    	    	   int count = stmt.executeUpdate("Insert into product(Brandname,Generation,model,price) values ('"+m.getBrandname()+"','"+m.getGeneration()+"','"+m.getModel_name()+"','"+m.getPrice()+"')");
   	    	     if(count==1)
   	    	     {    	    		  
   	    	    	 System.out.println("1 row inserted");
    	    	   }
    	    	  else 
    	    	  {
    	    		  throw new Exception();
    	    	  }
   	    	  } catch(Exception ex)
    	    		  {
    	    			   System.out.println(ex);
   	    		  }
    }
      public void show()
      {
//    	  System.out.println(list);
    	  Statement stmt;
    	  ResultSet rs;
    	  String qry=null;
    	  DButil db=new DButil();
    	  Connection con;
   	     try {
         con=db.getDBConnection();
         stmt=con.createStatement();
         rs=stmt.executeQuery("select * from product");
         while(rs.next())
         System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
      }
      catch(Exception e) 
   	  {
      System.out.println(e.getMessage());
      }
      }
      
      public mobile search(String id)
      {
    	  
    	  for(i=0;i<list.size();i++)
    	  {
    		  if(id.equals(list.get(i).getId()))
    	         return list.get(i);
    	  }
		return null;
      }
    public String Gtid(mobile mob)
    {
    	String id;
    	String n=mob.getBrandname();
        String bn=mob.getModel_name();
    	n=n.substring(0,2);
    	bn=bn.substring(0,2);
    	n=n.toUpperCase();
    	id=n+bn;
    	return id;
    }
     public void remove(String id)
     { 

    	 try
	     {
	      	   Statement stmt;
	    	   Connection con=db.getDBConnection();
	    	   stmt = con.createStatement();
	    	   String qry=null;
	    	   int count = stmt.executeUpdate("delete from product where id='"+id+"'");
	    	     if(count==1)
	    	     {    	    		  
	    	    	 System.out.println("1 row is deleted");
	    	   }
	    	  else 
	    	  {
	    		  throw new Exception();
	    	  }
	    	  } catch(Exception ex)
	    		  {
	    			   System.out.println("No row is deleted");
	    		  }
    	 
     }
     public void update(String id)
     {
    	 Scanner sc=new Scanner(System.in);
 		int ch;
 		try
 		{
 		  Connection con=db.getDBConnection();
 		  stmt=con.createStatement();
 		  System.out.print("Enter to update 1.Brandname 2.Generation 3.model 4.Price 5.exit");
 		  ch=sc.nextInt();
 		  switch(ch)
 		  {
 		    case 1:
 		    {
 			   
 			   qry="update product set brandname='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 2:
 		    {
 			  
 			   qry="update product set generation='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 3:
 		    {
 			   
 			   qry="update product set model_name='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 4:
 		    {
 	
 			   qry="update product set price='"+sc.nextInt()+"' where id='"+id+"'";
 			   break;
 		    }
 		 
 		    default:
 		    {
 			   System.out.println("Invalid choice");
 		    }
 		  }
 		  int count=stmt.executeUpdate(qry);
 		  if(count==1)
 			  System.out.println("1 row is updated");
 		  else
 			  throw new Exception("No row is updated");
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
     }
}




