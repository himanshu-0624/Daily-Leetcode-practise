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
    ListNode* partition(ListNode* head, int x) {
        ListNode* p1 = NULL;
        ListNode* p2 = NULL;
        ListNode* big = NULL;
        ListNode* small  =NULL;
        while(head != NULL)
        {
            ListNode* l = new ListNode(head->val);
            if(head->val >= x )
            {
                if(big ==NULL)
                {  big = l;
                p1 = l;}
                else
                {big->next = l;
                
                big = big->next;}
            }
            else
            {
                if(small == NULL)
                {
                    small = l;
                    p2 = l;
                }
                else
                {small->next = l;
                
                small = small->next;}
            }
            head = head->next;
        }
        
       if(p1 == NULL && p2 == NULL)
           return NULL;
        
        if(p1 == NULL)
        {
            return p2;
        }
        if(p2 == NULL)
            return p1;
        small->next = p1;
        return p2;
        
    }
};