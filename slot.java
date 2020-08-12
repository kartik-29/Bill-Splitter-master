import java.util.*;
class slot
{
    int id,value,flag;
    String name;
    
    slot(int id,int value,String name)
    {
		this.id=id;
		this.value=value;
		this.name=name;
		this.flag=0;
    }
    
    static void create(ArrayList<slot> s,int n,ArrayList<friends> group)
    {
        int k=0,nid,ve;
		String nm;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(group.get(i).name != group.get(j).name)
                {
                    nid=(i+1);
                    ve=0;
                    nm=group.get(j).name+" to "+group.get(i).name;
					
					slot newSlot = new slot(nid,ve,nm);
					s.add(newSlot);
                    k++;
                }
            }
        }
    }
	
	static void equally(ArrayList<slot> s,int id,int amount,int n)
	{
		int m,i=0,share;
		m=(n-1)*(id-1);
		
		share=amount/n;
		
		for(i=m; i<m+n-1; i++)
		{
			s.get(i).value+= share;
		}
	}
	
	static void unequally(ArrayList<slot> s,int id,int n)
	{
		Scanner s4= new Scanner(System.in);
		
		int m,i=0,share=0;
		m=(n-1)*(id-1);
		
		
		for(i=m; i<m+n-1; i++)
		{
			System.out.print("enter the amount for slot : "+s.get(i).name);
			share=s4.nextInt();
			System.out.println();
			s.get(i).value+= share;
			share=0;
		}
	}
	
	static void display(ArrayList<slot> s)
	{
		for(int i=0; i<s.size(); i++)
		{
			System.out.println("slot "+(i+1));
			System.out.println("name : "+s.get(i).name);
			System.out.println("amount : "+s.get(i).value);
			System.out.println();
		}
	}
	
	static void displayy(ArrayList<slot> fs)
	{
		for(int i=0; i<fs.size(); i++)
		{
			System.out.println("slot "+(i+1));
			System.out.println("name : "+fs.get(i).name);
			System.out.println("amount : "+fs.get(i).value);
			System.out.println();
		}
	}
	
	static void finish(ArrayList<slot> s,ArrayList<friends> group,int n)
	{
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<slot> fs = new ArrayList<slot>();
		
		int p=0,val=0;
		for(int k=0; k<n; k++)
		{
			for(int m=0; m<n; m++)
			{
				if(group.get(m).name != group.get(k).name)
				{
					names.add(group.get(k).name+" to "+group.get(m).name);
				}
			}	
		}
			
		for(int i=0; i<s.size(); i++)
		{
			for(int j=0; j<names.size(); j++)
			{
				if(s.get(i).name.equals(names.get(j)) && s.get(i).flag!=1 && s.get(j).flag!=1)
				{
					if(s.get(i).value>s.get(j).value)
					{
						val=s.get(i).value-s.get(j).value;
						
						slot newSlot1 = new slot(s.get(i).id,val,s.get(i).name);
						fs.add(newSlot1);
						s.get(i).flag=1;
						s.get(j).flag=1;
			
					}
					if(s.get(i).value==s.get(j).value)
					{
						s.get(i).flag=1;
						s.get(j).flag=1;
					}
					if(s.get(i).value<s.get(j).value)
					{
						val=s.get(j).value-s.get(i).value;
						
						slot newSlot2 = new slot(s.get(j).id,val,s.get(j).name);
						fs.add(newSlot2);
						s.get(i).flag=1;
						s.get(j).flag=1;
					}
				}
			}
		}
		slot.displayy(fs);
	}
}
