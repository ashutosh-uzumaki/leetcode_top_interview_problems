public class BrowserHistory {
    class Node{
        String page;
        Node next;
        Node prev;
        Node(){
                
        }
        Node(String page){
            this.page = page;
        }
    }
    
    class BrowserHistorys {
        Node head;
        Node tail;
        Node currPage;    
        public BrowserHistorys(String homepage) {
            head = new Node(homepage);
            tail = head;
            currPage = head;
        }
        
        public void visit(String url) {
            Node newPage = new Node(url);
            newPage.prev = currPage;
            currPage.next = newPage;
            tail = currPage = newPage;
        }
        
        public String back(int steps) {
            while(steps > 0){
                if(currPage == head){
                    return currPage.page;
                }
    
                currPage = currPage.prev;
                steps--;
            }
    
            return currPage.page;
        }
        
        public String forward(int steps) {
            while(steps > 0){
                if(currPage == tail){
                    return currPage.page;
                }
    
                currPage = currPage.next;
                steps--;
            }
    
            return currPage.page;
        }
    }
    
    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
