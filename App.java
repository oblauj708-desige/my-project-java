import java.util.*;
import java.io.*;
public class App {
    static ArrayList<Book> books = new ArrayList<Book>();
    static Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) throws Exception {
        loadBookData();
       while(true){
        System.out.println("操作を選んでください\n1:書籍一覧の表示\n2:書籍情報の表示\n3:書籍の追加\n4:書籍の削除\n5:書籍データの変更\n6:終了");
        int selected = Integer.parseInt(sc.nextLine());
        if(selected == 1)getList();
        else if(selected == 2)getBook();
        else if(selected == 3)addBook();
        else if(selected == 4)removeBook();
        else if(selected == 5)setBook();
        else if(selected == 6)break;
        else System.out.println("無効な入力です。");

       }
       sc.close();
    }
    public static void getList(){
        int count = 0;
        for(Book b : books){
            System.out.println(++count+":"+b.getName());
        }

    }
    public static void getBook(){
        System.out.println("どの本を調べますか。");
        int index = Integer.parseInt(sc.nextLine());
        outputBookData(index);
    }
    public static void outputBookData(int index){
        Book selected = books.get(index-1);
        System.out.println(selected.getName()+"に関する情報を以下の通りです。");
        System.out.println("筆者："+selected.getAuthor());
        System.out.println("ジャンル："+selected.getGenre());
        System.out.println("出版年："+selected.getYear());
        System.out.println("価格："+selected.getPrice());
        System.out.println("出版社："+selected.getPublisher());
        
    }
    public static void addBook(){
        System.out.println("追加する本の情報を入力してください。");
        
        System.out.println("タイトル:");
        String tittle = sc.nextLine();
        System.out.println("筆者:");
        String author = sc.nextLine();
        System.out.println("ジャンル:");
        String genre = sc.nextLine();
        System.out.println("出版年：");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("価格：");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("出版社：");
        String publisher = sc.nextLine();
        books.add(new Book(tittle,author,genre,year,price,publisher));
        saveBookData();
    }
    public static void removeBook(){
        System.out.println("どの本を削除しますか。");
        getList();
        int index = Integer.parseInt(sc.nextLine());
        books.remove(index-1);
        System.out.println("削除しました。");
        saveBookData();
    }
    public static void setBook(){
        System.out.println("どの本のデータを変更しますか。");
        int index = Integer.parseInt(sc.nextLine());
        outputBookData(index);
        System.out.println(books.get(index-1).getName()+"どのデータを変更しますか？(1:書名,2:筆者名,3:ジャンル名,4:出版年名,5:価格名,6:出版社)");
        int selected = Integer.parseInt(sc.nextLine());
        if(selected == 1){
            System.out.println("変更後の書名を入力してください。");
            String newName = sc.nextLine();
            books.get(index-1).setName(newName);

        }
        else if(selected == 2){
            System.out.println("変更後の筆者名を入力してください。");
            String newData = sc.nextLine();
            books.get(index-1).setAuthor(newData);

        }
        else if(selected == 3){
            System.out.println("変更後のジャンル名を入力してください。");
            String newData = sc.nextLine();
            books.get(index-1).setGenre(newData);

        }
        else if(selected == 4){
            System.out.println("変更後の出版年名を入力してください。");
            int newData =Integer.parseInt(sc.nextLine());
            books.get(index-1).setYear(newData);

        }
        else if(selected == 5){
            System.out.println("変更後の価格名を入力してください。");
            int newData =Integer.parseInt(sc.nextLine());
            books.get(index-1).setPrice(newData);

        }
        else if(selected == 6){
            System.out.println("変更後の出版社名を入力してください。");
            String newData = sc.nextLine();
            books.get(index-1).setPublisher(newData);

        }
        saveBookData();
        outputBookData(index);
    }
    public static void loadBookData(){
        BufferedReader br = null;
        try{
            File file = new File("./src/Book.csv");
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) !=null){
                String[] d = line.split(",");
                books.add(new Book(d[0],d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),d[5]));
            }
            }catch(Exception e){
                System.out.println("hoge"+e.getMessage());
            }finally{
                try{
                    br.close();
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }   

    }
    public static void saveBookData(){
        FileWriter fw = null;
        String txt = "";
        for(Book b : books){
            txt += b.getName()+","+b.getAuthor()+","+b.getGenre()+","+String.valueOf(b.getYear())+","+b.getPrice()+","+b.getPublisher()+",";
        }

        try{
            fw = new FileWriter("./src/Book.csv");
            fw.write(txt);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
              fw.close();
            }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
}
}
