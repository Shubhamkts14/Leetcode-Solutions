/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *temp = head;
        ListNode *p = head;
        int k = n;
        while(p!=NULL && p->next!=NULL && n>0){
            p = p->next;
            n--;
        }
        if(temp->next==NULL){
            temp = NULL;
            return temp;
        }
        if(n>0){
            temp = temp->next;
            return temp;
        }
        // if(p->next==NULL){
            
        // }
        while(p!=NULL && p->next!=NULL){
            temp = temp->next;
            p = p->next;
        }
        
        temp->next = temp->next->next;
        cout<<temp->val;
        return head;
    }
};