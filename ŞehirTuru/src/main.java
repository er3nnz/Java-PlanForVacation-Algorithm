import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class main {
     public static void islemler(){
 
        System.out.println("Sonraki - Bir sonraki sehre git...");
        System.out.println("Onceki - Bir onceki sehre git...");
        System.out.println("Sil - Istenilen Sehri Plandan Sil");
         System.out.println("Ekle -Istenilen Sehri Plana Ekle"); 
        System.out.println("q - Uygulamadan Cik.\n");
    }
     
     public static void sehirSil(LinkedList<String> linkedlist){
         System.out.println("****************");
         System.out.println("Lutfen Planinizdan Silmek Istediginiz Sehirin Adresini Giriniz.....");
         Scanner scanner=new Scanner(System.in);
         int index=scanner.nextInt();
         linkedlist.remove(index);
         System.out.println("\nPlan Listesinden "+linkedlist.get(index)+" eleman silinmistir....");
         
     }
     
     
     
     public static void sehirEkle(LinkedList<String> linkedlist){
         System.out.println("****************");
         System.out.println("Lutfen Planiniza Eklemek Istediginiz Sehir Adini ve Sirasini Giriniz....");
         System.out.println("****************");
         
         Scanner scanner=new Scanner(System.in);
         String Sehir=scanner.nextLine();
         int adres=scanner.nextInt();
         linkedlist.add(adres, Sehir);
         
         System.out.println("\nPlan Listesine "+linkedlist.get(adres)+" Eklenmistir...");
         
         
     }
     
     
     
  public static void islemsec(LinkedList<String> linkedlist){
      
        ListIterator<String> ıterator =linkedlist.listIterator();
        Scanner scanner=new Scanner(System.in);
        
        
       islemler();
       String islem;
       boolean a=false;
       boolean ileri = true;
       
       if (!ıterator.hasNext()) {
            
            System.out.println("Herhangi bir şehir bulunmuyor...");
        }
        
        while(!a){
            
            System.out.println("Bir islem seciniz:");
            islem = scanner.nextLine();
             
            
                if(islem.equals("Sonraki")){
                    
                      if (!ileri) {
                        if (ıterator.hasNext()) {
                            
                            ıterator.next();
                            
                        }
                        ileri = true;
                        
                    }
                     if(ıterator.hasPrevious()){
          
                   System.out.println("Sehire Gidiliyor... "+ıterator.previous());
                   }
                     else {
                   System.out.println("Herhangi Bir Sehir Bulunamiyor....\n");
                   }
                
                }
                         
                else if(islem.equals("Onceki")){
                    
                   if (ileri){
                        if (ıterator.hasPrevious()) {
                            ıterator.previous();
                            
                        }
                        ileri = false;
                        
                    }
                   if(ıterator.hasNext()){
          
                   System.out.println("Sehire Gidiliyor...  "+ıterator.next());
                  }
                   else{
                   System.out.println("Herhangi Bir Sehir Bulunamiyor....\n");
                    
                   }
                 
                }
                
                else if(islem.equals("Sil")){
                    
                    sehirSil(linkedlist);
                }
                
                else if(islem.equals("Ekle")){
                    
                    sehirEkle(linkedlist);
                }
                
                 else if(islem.equals("q")){
                     System.out.println("Sistemden Cikis Yapiliyor....");
                     a=true;
                     break;
                }
                 
                 else{
                     System.out.println("Yanlis ifade girilmistir...\n"
                             + "Lutfen Tekrar Deneyiniz.....");
                 }  
                  
            }
        
      }
        
 
  

  public static void sehiryazdir(LinkedList<String> a){
     
      for(String s: a){
          System.out.println(s);
      }
  }
    
    public static void main(String[] args) {
      
        LinkedList<String> linkedlist = new LinkedList<String>();
        System.out.println("Sehir Turu Programina Hosgeldiniz.....\n"
                + "Gidebileceginiz Sehirler Asagida Yazmaktadir....");  
        
        linkedlist.add("Ankara");
        linkedlist.add("Eskisehir");
        linkedlist.add("Malatya");
        
        System.out.println("****************************");
        sehiryazdir(linkedlist);
        System.out.println("****************************");
        
        islemsec(linkedlist);
        sehirEkle(linkedlist);
        sehirSil(linkedlist);
    }
}
