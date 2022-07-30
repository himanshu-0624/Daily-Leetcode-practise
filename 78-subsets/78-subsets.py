class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        o = []
        ans = []
        i = 0
        self.solve(nums,o,i,ans)

        
        return ans
    
    def solve(self,a, o, i, ans):
        if i == len(a):
            f = []
            for i in o:
                f.append(i)
                
            ans.append(f)
            return

            # exclude
        self.solve(a, o, i+1, ans)
            # include
        o.append(a[i])
        self.solve(a, o, i+1, ans)
        o.pop()