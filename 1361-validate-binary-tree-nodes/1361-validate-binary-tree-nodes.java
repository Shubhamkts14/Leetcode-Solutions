class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer,Integer> map=new HashMap();
        int lchild=0,rchild=0;
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<n;i++){
            lchild=leftChild[i];
            rchild=rightChild[i];
            if(lchild!= -1){
                if(checkIfCycle(lchild,i,map))
                return false;
                if(!map.containsKey(lchild)){
                    map.put(lchild,i);
                }else{
                    if(map.get(lchild)!=i){
                        return false;
                    }
                }
               if(!uf.union(lchild,i))
               return false;

            }
            if(rchild!=-1){
                if(checkIfCycle(rchild,i,map))
                return false;
                if(!map.containsKey(rchild)){
                    map.put(rchild,i);
                }else{
                    if(map.get(rchild)!=i){
                        return false;
                    }
                }
                if(!uf.union(rchild,i))
                return false;
            }
        }
        System.out.println(map+" "+uf.grp);
        if(uf.grp!=1)
        return false;
        return true;
    }
    public boolean checkIfCycle(int c,int p,Map<Integer,Integer> map){
        if(map.getOrDefault(p,-1)==c)
        return true;
    return false;

    } 
}

class UnionFind{
    int par[];
    int rank[];
    int grp;
    public UnionFind(int n){
        par=new int[n];
        rank=new int[n];
        grp=n;
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public int find(int x){
        if(par[x]==x)
        return x;
        return par[x]=find(par[x]);
    }
    public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            if(rank[px]>rank[py]){
                par[py]=px;
            }else if(rank[px]<rank[py]){
                par[px]=py;
            }else{
                par[px]=py;
                rank[py]+=1;
            }
            grp--;
            return true;
        }
        return false;
    }
}