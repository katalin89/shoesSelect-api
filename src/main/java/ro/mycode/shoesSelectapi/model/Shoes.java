package ro.mycode.shoesSelectapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="shoesSelect")
@AllArgsConstructor
@NoArgsConstructor

public class Shoes  implements Comparable<Shoes>{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id


    private long id;
    private String model;
    private String material;
    private String culoare;
    private  int pret;

//    public Shoes(long id, String model, String material, String culoare, int pret) {
//        this.id = id;
//        this.model = model;
//        this.material = material;
//        this.culoare = culoare;
//        this.pret = pret;
//    }

    @Override
    public int compareTo(Shoes o) {
        return 0;
    }

    @Override
    public String toString(){
        String text="";
        text+=id+","+model+","+material+","+culoare+","+pret;
        return  text;

    }

    public  int compare(Object o){
        Shoes shoes=(Shoes) o;
        if(this.pret>shoes.pret){
            return 1;
        }else if(this.pret<shoes.pret){
            return 0;
        }
        return -1;
    }
}


