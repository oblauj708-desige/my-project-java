public class Book {
    private int id,year,price;
    private String name,author,genre,publisher;
    private static int idcount = 0;

    public Book(String name,String author,String genre,int year,int price,String publisher){
        this.id = ++ idcount;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.publisher = publisher;

    }
    //getter
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getGenre(){
        return this.genre;
    }
    public int getYear(){
        return this.year;
    }
    public int getPrice(){
        return this.price;
    }
    public String getPublisher(){
        return this.publisher;
    }
    //setter
    public void setName(String newName){
        if(newName.length() > 20){
            newName = newName.substring(0,19);
        }
        this.name = newName;
    }
    public void setAuthor(String newData){
        this.author = newData;
    }
    public void setGenre(String newData){
        this.genre = newData;
    }
    public void setYear(int newData){
        this.year = newData;
    }
    public void setPrice(int newData){
        if(newData < 1)newData = 1;
        this.price = newData;
    }
    public void setPublisher(String newData){
        this.publisher = newData;
    }


}
