#include <iostream>
#include <map>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int data) {
        this->data = data;
        this->next = NULL;
    }

    ~Node() {
        int value = this->data;
        if (this->next != NULL) {
            delete next;
            this->next = NULL;
        }
        cout << "Memory is free for node with data " << value << endl;
    }
};

Node* reverse(Node* &head) {
    Node* prevptr = NULL;
    Node* currptr = head;
    Node* nextptr;

    while (currptr != NULL) {
        nextptr = currptr->next;
        currptr->next = prevptr;

        prevptr = currptr;
        currptr = nextptr;
    }

    head = prevptr;
    
    return head;
}

void display(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

int main() {
    Node* head = NULL;

    for (int i = 1; i <= 5; i++) {
        Node* newNode = new Node(i);
        newNode->next = head;
        head = newNode;
    }
   // original
    display(head);

    head = reverse(head);

    //reversed list
    display(head);

    return 0;
}
