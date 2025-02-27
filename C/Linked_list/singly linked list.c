#include <stdio.h>
#include <stdlib.h>

struct truct_t
{
    int data;
    struct truct_t *next;
};
typedef struct truct_t *Node;

Node addFirst(Node node, int n)
{
    Node p = calloc(1, sizeof(struct truct_t));
    p->data = n;
    p->next = node;
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
    scanf("%d", &n);
    if(!position)
        return addFirst(node,n);
    for (; position && node; position--, node = node->next)
        ;
    Node p = calloc(1, sizeof(struct truct_t));
    printf("Enter Data: ");
    
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
    p->next = node->next;
    node->next = p;
    p->data = n;

    return q;
}

Node removeFirst(Node node)
{
    Node p = node->next;
    free(node);
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
    node->next = node->next->next;

    return q;
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
    for (; p; p = p->next)
        printf("%d -> ", p->data);
    printf("NULL\n");
}

int getElement(Node node, int position)
{
    for (; position && node->next; position--, node = node->next)
        ;

    if (!position)
        return (node->data);
    printf("There isn't Element at Specific Position.\n");
    return 0;
}
Node setElement(Node node)
{
    Node p = node;
    int position;
    printf("Position to set Element: ");
    scanf("%d", &position);
    for (; position && node->next; position--, node = node->next)
        ;

    if (!position)
    {
        int n;
        printf("Data: ");
        scanf("%d", &n);
        node->data = n;
        return p;
    }
    printf("There isn't Specific Position in List\n");
    return p;
}
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
    node->next = p;
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
void recprin(Node node)
{
    if (node)
    {
        printf("%d->", node->data);
        node = node->next;
        recprin(node);
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
void recreverse(Node r, Node node)
{
    static Node q = NULL;
    static int i = 0;
    if (!node)
    {
        // printf("okki ");
        prin(q);
        return;
    }
    // printf("kdi ");

    if (!node->next)
    {
        // printf("ki ");
        if (r)
        {
            // printf("hi ");
            q = addLast(q, node->data);
            r = removeLast(r);
            node = r;
        }
        // printf("kisafa ");
    }
    // printf("ki ");

    if (!node->next)
    {
        q = addLast(q, node->data);
    }
    node = node->next;

    if (node)
    {
        // printf("i ");
        recreverse(r, node);
    }
    // printf("kkoioiioioi ");
    if (!i)
    {
        prin(q);
        i = 1;
    }
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
    Node p = NULL;
    printf("No.of Element u want to add:");
    int n, i;
    scanf("%d", &i);
    while (i--)
    {
        printf("Enter Data: ");
        scanf("%d", &n);
        p = addFirst(p, n);
    }

    printf("Add Element at Beginning: ");
    scanf("%d", &n);
    p = addFirst(p, n);

    prin(p);

    printf("Total Element: %d\n", count(p));

    p = removeFirst(p);
    printf("Remove Element at Beginning: ");
    prin(p);

    printf("Add Element at End: ");
    scanf("%d", &n);
    p = addLast(p, n);
    prin(p);

    p = removeLast(p);
    printf("Remove Element at End: ");
    prin(p);

    int position;
    printf("Enter Position to get Element: ");
    scanf("%d", &position);
    printf("Your Element: %d\n", getElement(p, position));

    p = setElement(p);
    prin(p);

    p = addElement(p);
    prin(p);

    p = removeElement(p);
    prin(p);


    printf("Add After First Occurence- \n");
    p = addFirstOcc(p);
    prin(p);

    printf("Remove After First Occurence- \n");
    p = removeFirstOcc(p);
    prin(p);

    printf("Reverse: ");
    p = reverse(p);
    prin(p);

    int ad;
    printf("Add Element in Sorted List: \n");
    scanf("%d", &ad);
    sortaddition(p, ad);
    prin(p);

    printf("Sorted List:");
    sort(p);
    prin(p);

    printf("Recurssion Print: ");
    recprin(p);

    printf("\nRecurssion Reverse Print: ");
    recrevprin(p);

    printf("\nRecurssion Reverse: ");
    recreverse(p, p);

    return 0;
}