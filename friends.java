import java.util.*;
class friends
{
    String name;
    int id;
    
    friends(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
    
    static void createF(ArrayList<friends> group,int n)
    {
		int mid;
		String nm;
        Scanner s1 = new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the name of Person "+(i+1)+" : ");
            nm=s1.next();
            System.out.println();
            mid=(i+1);
			friends newFreiend = new friends(mid,nm);
			group.add(newFreiend);
        }
    }
	
	static int getId(ArrayList<friends> group,String fri)
	{
		int ret=0;
		for(int i=0;i<group.size(); i++)
		{
			if(fri==group.get(i).name)
			{
				ret=group.get(i).id;
			}
		}
		
		return ret;
	}
}
