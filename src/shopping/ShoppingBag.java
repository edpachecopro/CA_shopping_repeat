
package shopping;


public class ShoppingBag   { 
    
        public String Name;
        public String Course;
        public int qtd;
        public double Price;
                
       public ShoppingBag ( String name, String course, int qtd, double price){
             
           this.Name = name;
           this.Course = course;
           this.qtd = qtd;
           this.Price = price;
       
       }
       
       // get Name
       public String getName(){
           return this.Name;
       }
       
       public String setName(String newName){
           return (this.Name = newName);
       }
       
       // get Course
       public String getCourse(){
           return this.Course;
       }
       
       public String setCourse(String newCourse){
           return (this.Course = newCourse);
       }
       
       // get Qtd
        public int getqtd(){
           return this.qtd;
       }
       
       public int setqtd(int newqtd){
           return (this.qtd = newqtd);
       }
       
       // get Price
       
       
         public double getPrice(){
           return this.Price;
       }      
       
       
       public double setPrice(double newPrice){      
        return (this.Price = newPrice);
       
       }

       //Override
       @Override
       public String toString(){
       return String.format("%s\t%s\t%s\t€ %.2f", this.Name, this.Course, this.qtd, this.Price);

       }
    

}
