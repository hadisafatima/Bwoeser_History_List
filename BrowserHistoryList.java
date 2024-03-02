public class BrowserHistoryList {
    private int size ;
    private HistoryNode top ;

    class HistoryNode{
        private Object data ;
        private HistoryNode next ;

        public HistoryNode(Object data, HistoryNode next) {
            this.data = data;
            this.next = next;
        }

        public HistoryNode(Object data) {
            this.data = data;
        }
    }

    public void forward(Object newURL){
        top = new HistoryNode(newURL, top);
        size++ ;
        System.out.println("New URL added!");
    }

    public Object backward(){
        if (top == null) return -1 ;

        else {
            Object oldTopURL = top.data;
            top = top.next ;
            size-- ;
            System.out.print("Previous top URL was : ");
            return oldTopURL;
        }
    }

    public void displayHistory(){
        for (HistoryNode p = top ; p != null ; p = p.next){
            System.out.println(p.data);
        }
    }

    public static void main(String[] args) {
        BrowserHistoryList historyList = new BrowserHistoryList();
        historyList.forward("URL1");
        historyList.forward("URL2");
        historyList.forward("URL3");

        System.out.println("\nHistory List is : ");
        historyList.displayHistory();

        System.out.println("\n" + historyList.backward());
        System.out.println("\nUpdated HistoryList : ");
        historyList.displayHistory();
    }

}
