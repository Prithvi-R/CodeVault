#include <stdio.h.>
#include <stdlib.h>

int* findMinMax(int *p,int n);
int* swapMinMax(int *p,int n);
int sum(int *p,int n);
int find(int *p,int n,int val);

int main()
{
    int n,i;
    printf("Enter Size of ARRAY: ");
    scanf("%d",&n);
    int *p= (int *) malloc(n*sizeof(int));

    for(i=0;i<n;i++)
        scanf("%d",(p+i));

    printf("\nElements: ");
    for(i=0;i<n;i++)
        printf("%d ",*(p+i));
    
    printf("\nMin Max: ");
    int *j;
    j=findMinMax(p,n);

    for(i=0;i<2;i++)
        printf("%d ",*(j+i));


    printf("\n Swapping the maximum and minimum index: ");
    j=swapMinMax(p,n);
    for(i=0;i<n;i++)
        printf("%d ",*(j+i));
    

    printf("\nSum: %d",sum(p,n));

    float avg;
    avg=(float)sum(p,n)/n;
    printf("\nAVERAGE: %.2f\n",avg);

    int val,index;
    printf("Enter the value: ");
    scanf("%d",&val);
    index=find(p,n,val);
    printf("Index: %d\n",index);

    printf("-----------Addresses----------\n");
    for(i=0;i<n;i++)
    {
        printf("%p\n",p+i);
    }

    return 0;
}

int find(int *p,int n,int val)
{
    int i;
    for(i=0;i<n;i++)
    {
        if(*(p+i)==val)
            return i;
    }
    return -1;
}

int sum(int *p,int n)
{
    int i,sum=0;
    for(i=0;i<n;i++)
    {
        sum+=*(p+i);
    }
    return sum;
}

int* swapMinMax(int *p,int n)
{
    int *j,temp;
    j=findMinMax(p,n);
    int a=*j,b=*(j+1);
    temp=p[b];
    p[b]=p[a];
    p[a]=temp;
    return p;
}
int* findMinMax(int *p,int n)
{
    int i,min[2]={*p,0},max[2]={*p,0};
    int *q= (int *) malloc(2*sizeof(int));
    for(i=0;i<n;i++)
    {
        if(min[0]>*(p+i)){
            min[1]=i;
            min[0]=*(p+i);
        }
        if (max[0]<*(p+i)){
            max[1]=i;
            max[0]=*(p+i);
        }
    }
    *q=min[1];
    *(q+1)=max[1];
    return q;
}