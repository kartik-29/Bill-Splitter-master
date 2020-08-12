import java.util.*;
public class trip
{
    public static void main(String[] args)
    {
		int n,nos,ch,ch3,ch4,ch5,sid,money;
		String f;
		char ch1,ch2;
	
		System.out.println("WELCOME");
		System.out.println("Start the trip");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter no. of friends");
		n=sc.nextInt();
		ArrayList<friends> group = new ArrayList<friends>();
		friends.createF(group,n);
		
		nos=n*(n-1);
		ArrayList<slot> s = new ArrayList<slot>();
		slot.create(s,n,group);
        
		do
		{
			System.out.println("1. Pay : ");
			System.out.println("2. Display all slots : ");
			
			ch=sc.nextInt();
			
			switch(ch)
			{
				case 1 :
					System.out.println("Enter the name of person who paid the bill : ");
					for(int i=0;i<group.size(); i++)
					{
						System.out.println((i+1)+". "+group.get(i).name);
					}
					System.out.print("Choice : ");
					sid = sc.nextInt();System.out.println();
					System.out.print("Enter the paid amount : ");
					money=sc.nextInt();System.out.println();
					
					System.out.println("1. Divide equally");
					System.out.println("2. Divide unequally : ");
					ch3=sc.nextInt();
					switch(ch3)
					{
						case 1:
							slot.equally(s,sid,money,n);
							break;
						
						case 2:
							slot.unequally(s,sid,n);
							break;
					}
					break;
				
				case 2:
					System.out.println("Displaying all slots");
					slot.display(s);
					break;
				
			}
			
			System.out.println("do you want to add another transaction");
			System.out.println("if yes press Y or Y");
			ch1= sc.next().charAt(0);
		}while(ch1=='y' || ch1=='Y');
		
		slot.finish(s,group,n);
		
		System.out.println("Trip ended");
	}
}
