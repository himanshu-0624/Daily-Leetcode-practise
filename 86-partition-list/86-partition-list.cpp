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
        ListNode* p1 = new ListNode(0);
        ListNode* p2 = new ListNode(0);
        ListNode* big = p1;
        ListNode* small  = p2;
        while(head != NULL)
        {
            ListNode* l = new ListNode(head->val);
            if(head->val >= x)
            {
                big->next = l;
                big = big->next;
            }
            else
            {
                small->next = l;
                small = small->next;
            }
            head = head->next;
        }
        
        small->next = p1->next;
        return p2->next;
        
        
    }
};