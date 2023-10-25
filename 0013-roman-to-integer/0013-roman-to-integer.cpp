class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char,int> map;
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        int res = 0;
        int prev = 0;
        for(int i =s.length()-1;i>=0;i--){
            int val = map[s[i]];
            if(val<prev){
                res -=val;
            }
            else{
                res += val;
            }
            prev = val;
        }
        return res;
    }
};