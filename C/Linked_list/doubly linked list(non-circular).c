#include <stdio.h>
#include <stdlib.h>

struct truct_t
{
    struct truct_t *prev;
    int data;
    struct truct_t *next;
};
typedef struct truct_t *Node;

Node addFirst(Node node, int n)
{
    Node p = calloc(1, sizeof(struct truct_t));
    if (!node)
    {
        p->next = NULL;
        p->data = n;
        p->prev=NULL;
        return p;
    }
    // node->prev->next = p;
    node->prev = p;
    p->prev = NULL;
    p->next = node;
    p->data = n;
    return p;
}
Node addLast(Node node, int n)
{
    if (!node)
    {
        return addFirst(node, n);
    }
    Node q = node;
    Node p = calloc(1, sizeof(struct truct_t));
    p->data = n;
    for (; node->next; node = node->next)
        ;
    node->next = p;
    p->prev=node;
    p->next = NULL;
    return q;
}
Node addElement(Node node)
{
    Node q = node;
    int position;
    printf("Enter Position to add: ");
    scanf("%d", &position);
    int n;
    printf("Enter Data: ");
    scanf("%d", &n);
    if(!position)
        return addFirst(node,n);
     position--;
    for (; position && node; position--, node = node->next)
        ;
    Node p = calloc(1, sizeof(struct truct_t));
    node->next->prev=p;
    p->prev=node;
    p->next = node->next;
    node->next = p;
    p->data = n;
    return q;
}
Node addFirstOcc(Node node)
{
    Node q = node;
    int key;
    printf("Enter the Value of Data: ");
    scanf("%d", &key);
    for (; node; node = node->next)
        if (node->data == key)
            break;
    if (!node)
    {
        printf("The Give Value isn't present.\n");
        return q;
    }

    Node p = calloc(1, sizeof(struct truct_t));
    printf("Enter Data: ");
    int n;
    scanf("%d", &n);
    p->prev=node;
    node->next->prev=p;
    p->next = node->next;
    node->next = p;
    p->data = n;

    return q;
}

Node removeFirst(Node node)
{
    if (!node)
        return NULL;
    if (node->next == node)
        return NULL;
    Node p = node->next;
    p->prev=NULL;
    return p;
}
Node removeLast(Node node)
{
    Node p = node;
    for (; node->next->next; node = node->next)
        ;
    node->next = NULL;
    return p;
}
Node removeElement(Node node)
{
    Node q = node;
    int position;
    printf("Enter Position to Remove: ");
    scanf("%d", &position);
    if (position)
    {
        position--;

        for (; position && node; position--, node = node->next)
            ;
        node->next->prev = node;
        node->next = node->next->next;

        return q;
    }
    return removeFirst(q);
}
Node removeFirstOcc(Node node)
{
    Node q = node;
    int key;
    printf("Enter the Value of Data: ");
    scanf("%d", &key);
    if (node->data == key)
        return removeFirst(q);
    for (; node; node = node->next)
        if (node->data == key)
            break;
    if (!node)
    {
        printf("The Give Value isn't present.\n");
        return q;
    }
    node->next->next->prev=node;
    node->next = node->next->next;

    return q;
}


Node reversiii(Node node)
{
    if (!node)
        return NULL;
    Node p = NULL;
    int n;
    Node q = node->prev;
    for (; node != q; node = node->next)
    {
        n = getElement(node, 0);
        p = addFirst(p, n);
    }
    n = getElement(node, 0);
    p = addFirst(p, n);
    return p;
}
Node reverse(Node node)
{
    Node p = NULL;
    int n;
    while (node)
    {
        n = getElement(node, 0);
        p = addFirst(p, n);
        node = node->next;
    }
    return p;
}
void prin(Node p)
{
    printf("NULL -> ");
    for (; p; p = p->next){
        printf("%d -> ", p->data);
        if(p->next==NULL)
            break;
    }
    printf("NULL\n");
    
    printf("NULL -> ");
    for (; p; p = p->prev)
        printf("%d -> ", p->data);
    printf("NULL\n");
}

int getElement(Node node, int position)
{
    if (!node)
        return NULL;
    for (; position && node->next; position--, node = node->next)
        ;

    if (!position)
        return (node->data);
    printf("There isn't Element at Specific Position.\n");
    return 0;
}
// Node setElement(Node node)
// {
//     Node p = node;
//     int position;
//     printf("Position to set Element: ");
//     scanf("%d", &position);
//     for (; position && node->next; position--, node = node->next)
//         ;
//     if (!position)
//     {
//         int n;
//         printf("Data: ");
//         scanf("%d", &n);
//         node->data = n;
//         return p;
//     }
//     printf("There isn't Specific Position in List\n");
//     return p;
// }

Node sortaddition(Node node, int n)
{
    if (!node)
        return addFirst(node, n);
    Node q = node;
    if (n < node->data)
        return addFirst(q, n);
    for (; node; node = node->next)
    {
        if (!node->next)
            return addLast(q, n);
        if (n <= node->next->data)
            break;
    }
    Node p = calloc(1, sizeof(struct truct_t));
    p->next = node->next;
    node->next->prev=p;
    node->next = p;
    p->prev=node;
    p->data = n;

    return q;
}
Node sort(Node node)
{
    Node q = node, p = NULL;
    int n;
    while (node)
    {
        n = getElement(node, 0);
        p = sortaddition(p, n);
        node = node->next;
    }
    return p;
}
Node merge(Node p, Node q)
{
    if (!p && !q)
        return NULL;
    Node node = p;
    for (; node->next; node = node->next)
        ;
    node->next = q;
    q->prev = node;
    return p;
}
Node sortmerged(Node p, Node q)
{
    return sort(merge(p, q));
}
void recprin(Node node)
{
    if (node)
    {
        printf("%d->", node->data);
        recprin(node->next);
    }
    else
        printf("NULL");
}
void recrevprin(Node node)
{
    node = reverse(node);
    if (node)
    {
        printf("%d->", node->data);
        node = node->next;
        recprin(node);
    }
    else
        printf("NULL");
}
void recreverse(Node node)
{

    if (node)
    {
        recreverse(node->next);
        printf("->%d", node->data);
    }
    else
        printf("NULL");
    return;
}

int count(Node p)
{
    if (!p)
        return 0;
    int i;
    for (i = 0; p; i++, p = p->next)
        ;
    return i;
}

int main()
{
    int option = 0;
    Node p = NULL;
    printf("No.of Element u want to add in List:");
    int n, i;
    scanf("%d", &i);
    while (i--)
    {
        printf("Enter Data: ");
        scanf("%d", &n);
        p = addFirst(p, n);
    }
    prin(p);

    while (1)
    {
        switch (option)
        {
        case 0:
        {
            printf("1.  To add an element at the beginning of the list.\n");
            printf("2.  To print the elements in the list both with forward and backward traversals.\n");
            printf("3.  To count the number of elements in the list \n");
            printf("4.  To remove the first element of the list \n");
            printf("5.  To add an element at the end of the list \n");
            printf("6.  To remove the last element of the list \n");
            printf("7.  To add an element at a given list position \n");
            printf("8.  To remove the element at a given list position \n");
            printf("9.  To add data after the first occurrence of a given key value in the linked list \n");
            printf("10. To remove the first occurrence of a given data present in the list \n");
            printf("11. To reverse the elements in the list \n");
            printf("12. To reverse the elements in the list without creating a new list \n");
            printf("13. To insert an element in a sorted list so the final list remains sorted \n");
            printf("14. To sort the elements in a list \n");
            printf("15. To merge two lists \n");
            printf("16. To get access the data at the ith node of the list \n");
            printf("17. To merge two sorted linked lists so the resultant list remains sorted \n");
            printf("18. Print the list using Recurssion \n");
            printf("19. Print the list in the Reverse order using Recurssion \n");
            printf("20. Reverse the list using Recurssion\n");
            printf("0:  MENU\n");
            printf("Else Case:Exit \n");
            break;
        }
        case 1:
        {
            printf("Add Element at Beginning: ");
            scanf("%d", &n);
            p = addFirst(p, n);
            prin(p);
            break;
        }
        case 2:
        {
            prin(p);
            break;
        }
        case 3:
        {
            printf("Total Element: %d\n", count(p));
            break;
        }
        case 4:
        {
            p = removeFirst(p);
            printf("Remove Element at Beginning: \n");
            prin(p);
            break;
        }
        case 5:
        {
            printf("Add Element at End: ");
            scanf("%d", &n);
            p = addLast(p, n);
            prin(p);
            break;
        }
        case 6:
        {
            p = removeLast(p);
            printf("Remove Element at End: \n");
            prin(p);
            break;
        }
        case 7:
        {
            p = addElement(p);
            prin(p);
            break;
        }
        case 8:
        {
            p = removeElement(p);
            prin(p);
            break;
        }
        case 9:
        {
            printf("Add After First Occurence- \n");
            p = addFirstOcc(p);
            prin(p);
            break;
        }
        case 10:
        {
            printf("Remove After First Occurence- \n");
            p = removeFirstOcc(p);
            prin(p);
            break;
        }
        case 11:
        {
            printf("Reverse: \n");
            p = reverse(p);
            prin(p);
            break;
        }
        case 12:
        {

            printf("Reversiii: \n");
            p = reversiii(p);
            prin(p);
            break;
        }
        case 13:
        {
            int ad;
            printf("Add Element in Sorted List: \n");
            scanf("%d", &ad);
            p = sortaddition(p, ad);
            prin(p);
            break;
        }
        case 14:
        {
            printf("Sorted List:\n");
            p = sort(p);
            prin(p);
            break;
        }
        case 15:
        {
            Node q = NULL;
            printf("(NEW LIST TO MERGE) No.of Element u want to add:");
            scanf("%d", &i);
            while (i--)
            {
                printf("Enter Data: ");
                scanf("%d", &n);
                q = addFirst(q, n);
            }
            prin(q);
            printf("Merged List:\n");
            p = merge(p, q);
            prin(p);
            break;
        }
        case 16:
        {
            int position;
            printf("Enter Position to get Element from ith Position: ");
            scanf("%d", &position);
            printf("Your Element: %d\n", getElement(p, position));
            break;
        }
        case 17:
        {
            Node q = NULL;
            printf("(NEW LIST TO MERGE) No.of Element u want to add:");
            scanf("%d", &i);
            while (i--)
            {
                printf("Enter Data: ");
                scanf("%d", &n);
                q = addFirst(q, n);
            }
            prin(q);
            printf("Sorted Merged List:\n");
            p = sortmerged(p, q);
            prin(p);
            break;
        }
        case 18:
        {
            printf("Recurssion Print: ");
            recprin(p);
            break;
        }
        case 19:
        {
            printf("\nRecurssion Reverse Print: ");
            recrevprin(p);
            break;
        }
        case 20:
        {
            printf("\nRecurssion Reverse: ");
            recreverse(p);
            break;
        }
        default:
        {
            printf("Thanks for using!!");
            return 0;
        }
        }
        printf("\nNext Choice: ");

        scanf("%d", &option);
    }
}