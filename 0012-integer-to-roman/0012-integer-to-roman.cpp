class Solution {
public:
    string intToRoman(int num) {
        string res="";
        map <int ,string > keys=
        {
        {1000,"M"},
        {900,"CM"},
        {500,"D"},
        {400,"CD"},
        {100,"C"},
        {90,"XC"},
        {50,"L"},
        {40,"XL"},
        {10,"X"},
        {9,"IX"},
        {5,"V"},
        {4,"IV"},
        {1,"I"}
        };

         for (auto it = keys.rbegin(); it != keys.rend(); ++it) {
             int check =num/it->first;
             while(check!=0)
             {
                 res+=it->second;
                 check--;
                 num=num%it->first;

             }
    }
        return res;
    }
};