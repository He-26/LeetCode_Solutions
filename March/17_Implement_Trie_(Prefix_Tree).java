class Trie {
    boolean isEnd;
    Trie[] link;
    public Trie() {
        isEnd=false;
        link=new Trie[26];
    }
    
    public void insert(String word) {
        int i=0;
        char[] ch=word.toCharArray();
        Trie t=this;
        while(t!=null && i<ch.length && t.link[ch[i]-'a']!=null){
            t=t.link[ch[i]-'a'];
            i++;
        }
        if(i==ch.length){
            t.isEnd=true;
            return;
        }
        for(;i<ch.length;i++){
            Trie temp=new Trie();
            t.link[ch[i]-'a']=temp;
            t=temp;
        }
        t.isEnd=true;
    }
    
    public boolean search(String word) {
        int i=0;
        char[] ch=word.toCharArray();
        Trie t=this;
        while(t!=null && i<ch.length && t.link[ch[i]-'a']!=null){
            t=t.link[ch[i]-'a'];
            i++;
        }
        if(i==ch.length && t.isEnd){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int i=0;
        char[] ch=prefix.toCharArray();
        Trie t=this;
        while(t!=null && i<ch.length && t.link[ch[i]-'a']!=null){
            t=t.link[ch[i]-'a'];
            i++;
        }
        if(i==ch.length){
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
