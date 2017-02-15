import java.util.Scanner;
class demo
{
	static int get(int n,int c,int r)
	{
		if(c-r>=0)
			return c-r;
		return n+c-r;
	}
	static void rotate(int arr[][],int i1,int j1,int i2,int j2,int r)
	{
		int tm=i2-i1+1,tn=j2-j1+1,c=0,i,j,n;
		n=2*tm+2*tn-4;
		int arr1[]=new int[n];
		r%=n;
		for(i=i1,j=j1;j<j2;j++)
			arr1[demo.get(n,c++,r)]=arr[i][j];
		for(i=i1,j=j2;i<i2;i++)
			arr1[demo.get(n,c++,r)]=arr[i][j];
		for(i=i2,j=j2;j>j1;j--)
			arr1[demo.get(n,c++,r)]=arr[i][j];
		for(i=i2,j=j1;i>i1;i--)
			arr1[demo.get(n,c++,r)]=arr[i][j];
		c=0;
		for(i=i1,j=j1;j<j2;j++)
			arr[i][j]=arr1[c++];
		for(i=i1,j=j2;i<i2;i++)
			arr[i][j]=arr1[c++];
		for(i=i2,j=j2;j>j1;j--)
			arr[i][j]=arr1[c++];
		for(i=i2,j=j1;i>i1;i--)
			arr[i][j]=arr1[c++];
	}
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		int m,n,r,i,j;
		System.out.print("Enter no. of rows : ");
		m=sc.nextInt();
		System.out.print("Enter no. of cols : ");
		n=sc.nextInt();
		System.out.print("Enter no. of rotation units : ");
		r=sc.nextInt();
		int arr[][]=new int[m][n];
		for(i=0;i<m;i++)
			for(j=0;j<n;j++)
				arr[i][j]=sc.nextInt();
		if(m<n)
			for(i=0;i<m/2;i++)
				demo.rotate(arr,i,i,m-i-1,n-i-1,r);
		else
			for(i=0;i<n/2;i++)
				demo.rotate(arr,i,i,m-i-1,n-i-1,r);
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
}
