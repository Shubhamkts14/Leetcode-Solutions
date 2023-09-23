// Stack using  queue . push operatin costly
// put elements in q2
// elements in q1 has to put in q2
// add swap q1 and q2
// adding 2 in q2
// put q1 elements q2
// reverse q1 and q2
// put 3 
// put qi in q2
# include <bits/stdc++.h>
using namespace std;
class sta{
    
    int N;
    queue<int>q1;
    queue<int>q2;
    public:
    sta(){
        N=0;
    }
    void push(int val){
        q2.push(val);
        N++;
        while(!q1.empty()){
            q2.push(q1.front());
            q1.pop();
        }
        queue<int>temp=q1;
        q1=q2;
        q2=temp;
    }
    void pop(){
        q1.pop();
        N--;
    }
    int top(){
        return N;
    }
};
int main(){
    sta st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    cout<<st.top()<<endl;
    st.pop();
}