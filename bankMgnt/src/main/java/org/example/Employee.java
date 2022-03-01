package org.example;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Employee {

    private int ac_no;
    private String cname;
    private int balance;
    private int pass_code;

    @Override
    public String toString() {
        System.out.println("The Account Details Are As follows\n" +
                "==================================================================================");
        System.out.println("Acc_No     CName       Balance      Password");
        String s= " "+ac_no+"         "+cname+"         "+balance+"        "+pass_code+"\n\n";

        return s;

    }

}
