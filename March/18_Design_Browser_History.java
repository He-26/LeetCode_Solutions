class BrowserHistory {
    Stack<String> back=new Stack();
    Stack<String> forw=new Stack();
    public BrowserHistory(String homepage) {
        back.add(homepage);
    }
    
    public void visit(String url) {
        forw=new Stack();
        back.add(url);
    }
    
    public String back(int steps) {
        while(steps>0 && back.size()>1){
            forw.add(back.pop());
            steps--;
        }
        return back.peek();
    }
    
    public String forward(int steps) {
        while(steps>0 && forw.size()>0){
            back.add(forw.pop());
            steps--;
        }
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
