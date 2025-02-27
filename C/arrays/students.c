#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct student_t
{
    char *name;
    int roll;
    float cpi;
};
typedef struct student_t *Student;

typedef int (*Comparator)(Student, Student);
int compareRoll(Student a, Student b)
{
    return a->roll > b->roll ? 1 : 0;
}
int compareCPI(Student a, Student b)
{
    return a->cpi > b->cpi ? 1 : 0;
}
void sortStudents(Student *p, int m, Comparator c)
{
    for (int i = 1; i < m; i++)
    {
        Student key = p[i];
        int j = i - 1;
        while (j >= 0 && c(p[j], key))
        {
            p[j + 1] = p[j];
            j = j - 1;
        }
        p[j + 1] = key;
    }
}

#define MAX_SIZE 500
Student AddStudent()
{
    fflush(stdin);
    Student p = (Student)calloc(1, sizeof(struct student_t));
    char buffer[MAX_SIZE];
    int roll;
    float cpi;
    buffer[MAX_SIZE - 1] = '\0';
    printf("Enter Name: ");
    scanf(" %s", buffer);
    printf("Enter Roll: ");
    scanf("%d", &roll);
    printf("Enter CPI obtained: ");
    scanf("%g", &cpi);
    char *name = (char *)calloc((strlen(buffer) + 1), sizeof(char));
    strcpy(name, buffer);
    p->name = name;
    p->roll = roll;
    p->cpi = cpi;
    return p;
}

Student *AddElements(Student *pStudent, int *pM, int *pN)
{
    if (*pM < *pN)
    {
        Student q = AddStudent();
        pStudent[*pM] = q;
        *pM = *pM + 1;
        AddElements(pStudent, pM, pN);
    }
    else
    {
        return pStudent;
    }
}
Student *AddLast(Student *pStudent, int *pM, int *pN)
{

    int i;
    int n;
    n = ceil(1.2 * *pN);
    Student *p = (Student *)calloc(n, sizeof(Student));
    for (i = 0; i < *pN; i++)
        p[i] = pStudent[i];
    free(pStudent);
    // printf("%s->%d\n",__func__,n);printf("%s->%d\n",__func__,*pN);
    printf("Insert Element:\n");
    while (i < n)
        p[i++] = AddStudent();
    // printf("%s %d %.2f",p[i]->name,p[i]->roll,p[i]->cpi);

    *pM += 1;
    *pN = n;
    return p;
}
Student *AddFirst(Student *pStudent, int *pM, int *pN)
{

    int i;
    int n;
    n = ceil(1.2 * *pN);
    Student *p = (Student *)calloc(n, sizeof(Student));
    for (i = 0; i <= *pN; i++)
        p[n - *pN + i] = pStudent[i];
    free(pStudent);
    // printf("%s->%d\n",__func__,n);printf("%s->%d\n",__func__,*pN);
    i = n - *pN;
    printf("Insert Element:\n");
    while (i > 0)
        p[--i] = AddStudent();
    // printf("%s %d %.2f",p[i]->name,p[i]->roll,p[i]->cpi);

    *pM += 1;
    *pN = n;
    return p;
}
Student *AddMiddle(Student *pStudent, int *pM, int *pN)
{

    int i, k;
    int n;
    n = ceil(1.2 * *pN);
    Student *p = (Student *)calloc(n, sizeof(Student));
    printf("Position u want to add the element: ");
    scanf("%d", &k);
    for (i = 0; i < k; i++)
        p[i] = pStudent[i];

    printf("Insert Element:\n");
    p[i] = AddStudent();

    for (i = k; i < *pN; i++)
        p[1 + i] = pStudent[i];
    free(pStudent);
    *pM += 1;
    *pN = n;
    return p;
}

Student *DelLast(Student *pStudent, int *pM, int *pN)
{

    int i;
    Student *p = (Student *)calloc((*pN - 1), sizeof(Student));
    for (i = 0; i < *pN - 1; i++)
        p[i] = pStudent[i];
    free(pStudent);
    *pM -= 1;
    if (*pM < 0.5 * *pN)
    {
        int n;
        n = ceil(0.75 * *pN);
        Student *pm = (Student *)calloc(n, sizeof(Student));
        for (i = 0; i < n-1; i++)
            pm[i] = p[i];
        free(p);    
        *pM = n;
        *pN = n;
        return pm;
    }else
    {
        return p;
    }
}
Student *DelFirst(Student *pStudent, int *pM, int *pN)
{
    int i;
    Student *p = (Student *)calloc((*pN - 1), sizeof(Student));
    for (i = 1; i < *pN; i++)
        p[i - 1] = pStudent[i];
    free(pStudent);
    *pM -= 1;
    if (*pM < 0.5 * *pN)
    {
        int n;
        n = ceil(0.75 * *pN);
        Student *pm = (Student *)calloc(n, sizeof(Student));
        for (i = *pN - n; i < *pN; i++)
            pm[i - (*pN - n)] = p[i];
        free(p);
        *pM = n;
        *pN = n;
        return pm;
    }else
    {
        return p;
    }
}
Student *DelMiddle(Student *pStudent, int *pM, int *pN)
{
    int i, k;
    printf("Enter the Position u want to delete the Element:");
    scanf("%d", &k);
    Student *p = (Student *)calloc(*pN, sizeof(Student));
    for (i = 0; i < k; i++)
        p[i] = pStudent[i];
    for (i = k + 1; i < *pN; i++)
        p[i - 1] = pStudent[i];
    free(pStudent);
    *pM -= 1;
    if (*pM < 0.5 * *pN)
    {
        int n;
        n = ceil(0.75 * *pN);
        Student *pm = (Student *)calloc(n, sizeof(Student));
        for (i = 0; i < k; i++)
            pm[i] = p[i];
        for (i = k + 1; i < n; i++)
            pm[i - 1] = p[i];
        free(p);
        *pM = n;
        *pN = n;
        return pm;
    }else
    {
        return p;
    }
}

void prin(Student *p, int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d) %s  %d  %g\n", i + 1, p[i]->name, p[i]->roll, p[i]->cpi);
    }
}

int main()
{
    int option = 0;

    printf("1:Insert an Element at the End\n2:Insert an Element at the Beginning\n3:Insert an Element at the i-th Location\n4:Delete an Element from the End\n5:Delete an Element from the Beginning\n6:Delete an Element from the ith Location\n7:Sort by Roll\n8:Sort by CPI\nElse Case:Exit\n");
    scanf("%d", &option);

    int n = 3, m = 0;
    printf("Enter Elements:\n");
    Student *p = (Student *)calloc(n, sizeof(Student));
    p = AddElements(p, &m, &n);

    while (1)
    {
        switch (option)
        {
        case 1:
        {
            printf("Insert an Element at the End:\n");
            p = AddLast(p, &m, &n);
            prin(p, n);
            break;
        }
        case 2:
        {
            printf("Insert an Element at the Beginning:\n");
            p = AddFirst(p, &m, &n);
            prin(p, n);
            break;
        }
        case 3:
        {
            printf("Insert an Element at the i-th Location:\n");
            p = AddMiddle(p, &m, &n);
            prin(p, n);
            break;
        }
        case 4:
        {
            printf("Delete the Element at the Last:\n");
            p = DelLast(p, &m, &n);
            prin(p, m);
            break;
        }
        case 5:
        {
            printf("Delete the Element at the Beginning:\n");
            p = DelFirst(p, &m, &n);
            prin(p, m);
            break;
        }
        case 6:
        {
            printf("Delete the Element from the i-th position:\n");
            p = DelMiddle(p, &m, &n);
            prin(p, m);
            break;
        }
        case 7:
        {
            printf("Sorted by roll: \n");
            sortStudents(p, m, compareRoll);
            prin(p, m);
            break;
        }
        case 8:
        {
            printf("Sorted by CPI: \n");
            sortStudents(p, m, compareCPI);
            prin(p, m);
            break;
        }
        default:
        {
            printf("Thanks for using!!");
            return 0;
        }
        }
        scanf("%d", &option);
    }
}
